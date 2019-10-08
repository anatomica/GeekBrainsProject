package Theme7;

public class Metods extends TicTacToeGUI {

    public static boolean verifyCompWin() {
        int x = 0;
        int y = 0;
        boolean result = false;

        // Проверка победы (по вертикали)
        if ((Map.map[0][0] == DOT_O) && (Map.map[1][0] == DOT_O) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[0][1] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }
        if ((Map.map[0][2] == DOT_O) && (Map.map[1][2] == DOT_O) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[2][0] == DOT_O) && (Map.map[1][0] == DOT_O) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[2][1] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((Map.map[2][2] == DOT_O) && (Map.map[1][2] == DOT_O) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((Map.map[0][0] == DOT_O) && (Map.map[2][0] == DOT_O) && (Map.map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((Map.map[0][1] == DOT_O) && (Map.map[2][1] == DOT_O) && (Map.map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((Map.map[0][2] == DOT_O) && (Map.map[2][2] == DOT_O) && (Map.map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }

        // Проверка победы (по горизонтали)
        if ((Map.map[0][0] == DOT_O) && (Map.map[0][1] == DOT_O) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((Map.map[1][0] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }
        if ((Map.map[2][0] == DOT_O) && (Map.map[2][1] == DOT_O) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[0][2] == DOT_O) && (Map.map[0][1] == DOT_O) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[1][2] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((Map.map[2][2] == DOT_O) && (Map.map[2][1] == DOT_O) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[0][0] == DOT_O) && (Map.map[0][2] == DOT_O) && (Map.map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((Map.map[1][0] == DOT_O) && (Map.map[1][2] == DOT_O) && (Map.map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((Map.map[2][0] == DOT_O) && (Map.map[2][2] == DOT_O) && (Map.map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }

        // Проверка победы (по диагонали)
        if ((Map.map[0][0] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[2][2] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[0][2] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[2][0] == DOT_O) && (Map.map[1][1] == DOT_O) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }

        if (result) {
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            Map.map[y][x] = DOT_O;
            Map.printMap();
            int cell = (y * Map.SIZE) + x;
            GUI.numButtons[cell].setText("O");
            TicTacToeGUI.passTurn();
        }
        return result;
    }

    public static boolean verifyHumanWin() {
        int x = 0;
        int y = 0;
        boolean result = false;

        // Ход против игрока (проверка по вертикали)
        if ((Map.map[0][0] == DOT_X) && (Map.map[1][0] == DOT_X) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[0][1] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }
        if ((Map.map[0][2] == DOT_X) && (Map.map[1][2] == DOT_X) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[2][0] == DOT_X) && (Map.map[1][0] == DOT_X) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[2][1] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((Map.map[2][2] == DOT_X) && (Map.map[1][2] == DOT_X) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((Map.map[0][0] == DOT_X) && (Map.map[2][0] == DOT_X) && (Map.map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((Map.map[0][1] == DOT_X) && (Map.map[2][1] == DOT_X) && (Map.map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((Map.map[0][2] == DOT_X) && (Map.map[2][2] == DOT_X) && (Map.map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }

        // Ход против игрока (проверка по горизонтали)
        if ((Map.map[0][0] == DOT_X) && (Map.map[0][1] == DOT_X) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((Map.map[1][0] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }
        if ((Map.map[2][0] == DOT_X) && (Map.map[2][1] == DOT_X) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[0][2] == DOT_X) && (Map.map[0][1] == DOT_X) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[1][2] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((Map.map[2][2] == DOT_X) && (Map.map[2][1] == DOT_X) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[0][0] == DOT_X) && (Map.map[0][2] == DOT_X) && (Map.map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((Map.map[1][0] == DOT_X) && (Map.map[1][2] == DOT_X) && (Map.map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((Map.map[2][0] == DOT_X) && (Map.map[2][2] == DOT_X) && (Map.map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }

        // Ход против игрока (проверка по диагонали)
        if ((Map.map[0][0] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((Map.map[2][2] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((Map.map[0][2] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((Map.map[2][0] == DOT_X) && (Map.map[1][1] == DOT_X) && (Map.map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }

        if (result) {
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            Map.map[y][x] = DOT_O;
            Map.printMap();
            int cell = (y * Map.SIZE) + x;
            GUI.numButtons[cell].setText("O");
            TicTacToeGUI.passTurn();
        }
        return result;
    }

}
