package Theme7;

public class Checkers extends TicTacToeGUI {

    // Проверка игры на завершение
    public static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        // Проверка на необходимость следующего хода
        if(checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            if (playerSymbol == DOT_O) {
                GUI.showMessage("Победил компьютер! \nНачинаем новую игру!");
            }
            if (playerSymbol == DOT_X) {
                GUI.showMessage("Поздравляю! Вы победили! \nНачинаем новую игру!");
            }
            new EmptyField();
            GamerStart ();
            result = true;
        }

        // Проверка на заполненность поля
        if(isMapFull()) {
            System.out.println("Ничья");
            GUI.showMessage("Ничья! \nНачинаем новую игру!");
            new EmptyField();
            GamerStart();
            result = true;
        }

        return result;
    }

    // Проверка победы
    public static boolean checkWin (char playerSymbol) {
        boolean winH;
        boolean winV;
        boolean winD;
        boolean winD1;
        boolean result = false;

        //проверка наличия заполненных горизонтальных и вертикальных рядов
        for (int i = 0; i < Map.SIZE ; i++) {
            winH = true;
            winV = true;
            for (int j = 0; j < Map.SIZE; j++) {
                if (Map.map[i][j] != playerSymbol) {
                    winH = false;
                }
                if (Map.map[j][i] != playerSymbol) {
                    winV = false;
                }
            }
            if (winH || winV) {
                result = true;
                break;
            }
        }

        // проверка наличия заполненных диагональных рядов
        if (!result){
            winD = true;
            winD1 = true;
            for (int i = 0; i < Map.SIZE ; i++) {
                if (Map.map[i][i] != playerSymbol)
                    winD = false;
                if (Map.map[i][Map.SIZE -1 -i] != playerSymbol)
                    winD1 = false;
                if (!winD && !winD1)
                    break;
            }
            result = (winD || winD1);
        }
        return result;
    }

    // Проверка на заполненность поля
    public static boolean isMapFull () {
        boolean result = true;

        for(int i =0; i < Map.SIZE; i++) {
            for (int j = 0; j < Map.SIZE; j++) {
                if (Map.map[i][j] == DOT_EMPTY) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    // Метод валидации запрашиваемой ячейки
    public static boolean isCellValid(int x, int y){
        boolean result = true;
        if(x < 0 || x >= Map.SIZE || y < 0 || y >= Map.SIZE) {
            GUI.showMessage("Так ходить нельзя!");
            result = false;
        }
        if(Map.map[y][x] != DOT_EMPTY) {
            GUI.showMessage("Так ходить нельзя!");
            result = false;
        }
        return result;
    }

    // Метод проверки лучшей ячейки рядом
    public static boolean isCellValidNear(int x, int y) {
        if (x < 0 || x >= Map.SIZE || y < 0 || y >= Map.SIZE)
            return false;
        if (Map.map[y][x] != DOT_EMPTY)
            return false;
        if ((Map.map[0][0] != DOT_O) && (Map.map[0][1] != DOT_O) && (Map.map[0][2] != DOT_O)
                && (Map.map[1][0] != DOT_O) && (Map.map[1][1] != DOT_O) && (Map.map[1][2] != DOT_O)
                && (Map.map[2][0] != DOT_O) && (Map.map[2][1] != DOT_O) && (Map.map[2][2] != DOT_O))
            return true;

        // Проверка первой линии
        if ((y == 0) && (x == 0) && ((Map.map[0][1] == DOT_O) ||
                (Map.map[1][0] == DOT_O) || (Map.map[1][1] == DOT_O)))
            return true;
        if ((y == 0) && (x == 1) && ((Map.map[0][0] == DOT_O) ||
                (Map.map[0][2] == DOT_O) || (Map.map[1][1] == DOT_O)))
            return true;
        if ((y == 0) && (x == 2) && ((Map.map[0][1] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[1][2] == DOT_O)))
            return true;
        // Проверка второй линии
        if ((y == 1) && (x == 0) && ((Map.map[0][0] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[2][0] == DOT_O)))
            return true;
        if ((y == 1) && (x == 1) && ((Map.map[0][0] == DOT_O) ||
                (Map.map[0][1] == DOT_O) || (Map.map[0][2] == DOT_O) ||
                (Map.map[1][0] == DOT_O) || (Map.map[1][2] == DOT_O) ||
                (Map.map[2][0] == DOT_O) || (Map.map[2][1] == DOT_O) ||
                (Map.map[2][2] == DOT_O)))
            return true;
        if ((y == 1) && (x == 2) && ((Map.map[0][2] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[2][2] == DOT_O)))
            return true;
        // Проверка третьей линии
        if ((y == 2) && (x == 0) && ((Map.map[1][0] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[2][1] == DOT_O)))
            return true;
        if ((y == 2) && (x == 1) && ((Map.map[2][0] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[2][2] == DOT_O)))
            return true;
        if ((y == 2) && (x == 2) && ((Map.map[2][1] == DOT_O) ||
                (Map.map[1][1] == DOT_O) || (Map.map[1][2] == DOT_O)))
            return true;
        else return false;
    }

    public static boolean DOT_X () {
        boolean result = false;

        for(int i =0; i < Map.SIZE; i++) {
            for (int j = 0; j < Map.SIZE; j++) {
                if (Map.map[i][j] == DOT_X) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
