package Theme3;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char [][] map; // матрица игры
    private static int SIZE = 3; //размерность поля

    private static final char DOT_EMPTY = '*'; // пустой символ
    private static final char DOT_X = 'X'; // крестик
    private static final char DOT_O = 'O'; // нолик

    private static final boolean SILLY_MODE = false;
    private static final boolean TRUE_MODE = true;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            if (verifyCompWin()) {
                isEndGame(DOT_O);
                break;
            }
            if (!verifyHumanWin()) {
                computerTurn();
            }
            if (isEndGame(DOT_O)) {
                break;
            }
            humanTurn();
            if (isEndGame(DOT_X)) {
                break;
            }
        }
        System.out.println("Игра закончена!");
    }

    // Метод подготовки игрового поля
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i ++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // Печать игрового поля
    private static void printMap() {
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i =0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Ход игрока
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }
        while(!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    // Ход компьютера
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while(!isCellValid(x, y));
        }

        else if (TRUE_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValidNear(x, y));
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }

    // Метод валидации запрашиваемой ячейки
    private static boolean isCellValid(int x, int y){
        boolean result = true;
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            result = false;
        if(map[y][x] != DOT_EMPTY)
            result = false;
        return result;
    }

    // Метод проверки лучшей ячейки рядом
    private static boolean isCellValidNear(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return false;
        if (map[y][x] != DOT_EMPTY)
            return false;
        if ((map[0][0] != DOT_O) && (map[0][1] != DOT_O) && (map[0][2] != DOT_O)
                && (map[1][0] != DOT_O) && (map[1][1] != DOT_O) && (map[1][2] != DOT_O)
                && (map[2][0] != DOT_O) && (map[2][1] != DOT_O) && (map[2][2] != DOT_O))
            return true;

        // Проверка первой линии
        if ((y == 0) && (x == 0) && ((map[0][1] == DOT_O) ||
                (map[1][0] == DOT_O) || (map[1][1] == DOT_O)))
            return true;
        if ((y == 0) && (x == 1) && ((map[0][0] == DOT_O) ||
                (map[0][2] == DOT_O) || (map[1][1] == DOT_O)))
            return true;
        if ((y == 0) && (x == 2) && ((map[0][1] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[1][2] == DOT_O)))
            return true;

        // Проверка второй линии
        if ((y == 1) && (x == 0) && ((map[0][0] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[2][0] == DOT_O)))
            return true;
        if ((y == 1) && (x == 1) && ((map[0][0] == DOT_O) ||
                (map[0][1] == DOT_O) || (map[0][2] == DOT_O) ||
                (map[1][0] == DOT_O) || (map[1][2] == DOT_O) ||
                (map[2][0] == DOT_O) || (map[2][1] == DOT_O) ||
                (map[2][2] == DOT_O)))
            return true;
        if ((y == 1) && (x == 2) && ((map[0][2] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[2][2] == DOT_O)))
            return true;

        // Проверка третьей линии
        if ((y == 2) && (x == 0) && ((map[1][0] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[2][1] == DOT_O)))
            return true;
        if ((y == 2) && (x == 1) && ((map[2][0] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[2][2] == DOT_O)))
            return true;
        if ((y == 2) && (x == 2) && ((map[2][1] == DOT_O) ||
                (map[1][1] == DOT_O) || (map[1][2] == DOT_O)))
            return true;

        else
            return false;
    }

    // Проверка игры на завершение
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        // Проверка на необходимость следующего хода
        if(checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        // Проверка на заполненность поля
        if(isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    // Проверка победы
    private static boolean checkWin (char playerSymbol) {
        boolean winH = true;
        boolean winV = true;
        boolean winD;
        boolean winD1;
        boolean result = false;

        //проверка наличия заполненных горизонтальных и вертикальных рядов
        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != playerSymbol) {
                    winH = false;
                }
                if (map[j][i] != playerSymbol) {
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
            for (int i = 0; i <SIZE ; i++) {
                if (map[i][i] != playerSymbol)
                    winD = false;
                if (map[i][SIZE -1 -i] != playerSymbol)
                    winD1 = false;
                if (!winD && !winD1)
                    break;
            }
            result = (winD || winD1);
        }
        return result;
    }

    // Проверка на заполненность поля
    private static boolean isMapFull () {
        boolean result = true;

        for(int i =0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }

        return result;
    }

    private static boolean verifyHumanWin() {
        int x = 0;
        int y = 0;
        boolean result = false;

        // Ход против игрока (проверка по вертикали)
        if ((map[0][0] == DOT_X) && (map[1][0] == DOT_X) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[0][1] == DOT_X) && (map[1][1] == DOT_X) && (map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }
        if ((map[0][2] == DOT_X) && (map[1][2] == DOT_X) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[2][0] == DOT_X) && (map[1][0] == DOT_X) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[2][1] == DOT_X) && (map[1][1] == DOT_X) && (map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((map[2][2] == DOT_X) && (map[1][2] == DOT_X) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((map[0][0] == DOT_X) && (map[2][0] == DOT_X) && (map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((map[0][1] == DOT_X) && (map[2][1] == DOT_X) && (map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((map[0][2] == DOT_X) && (map[2][2] == DOT_X) && (map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }

        // Ход против игрока (проверка по горизонтали)
        if ((map[0][0] == DOT_X) && (map[0][1] == DOT_X) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((map[1][0] == DOT_X) && (map[1][1] == DOT_X) && (map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }
        if ((map[2][0] == DOT_X) && (map[2][1] == DOT_X) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[0][2] == DOT_X) && (map[0][1] == DOT_X) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[1][2] == DOT_X) && (map[1][1] == DOT_X) && (map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((map[2][2] == DOT_X) && (map[2][1] == DOT_X) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[0][0] == DOT_X) && (map[0][2] == DOT_X) && (map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((map[1][0] == DOT_X) && (map[1][2] == DOT_X) && (map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((map[2][0] == DOT_X) && (map[2][2] == DOT_X) && (map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }

        // Ход против игрока (проверка по диагонали)
        if ((map[0][0] == DOT_X) && (map[1][1] == DOT_X) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[2][2] == DOT_X) && (map[1][1] == DOT_X) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[0][2] == DOT_X) && (map[1][1] == DOT_X) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[2][0] == DOT_X) && (map[1][1] == DOT_X) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }

        if (result) {
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_O;
            printMap();
        }
        return result;
    }

    private static boolean verifyCompWin() {
        int x = 0;
        int y = 0;
        boolean result = false;

        // Проверка победы (по вертикали)
        if ((map[0][0] == DOT_O) && (map[1][0] == DOT_O) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[0][1] == DOT_O) && (map[1][1] == DOT_O) && (map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }
        if ((map[0][2] == DOT_O) && (map[1][2] == DOT_O) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[2][0] == DOT_O) && (map[1][0] == DOT_O) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[2][1] == DOT_O) && (map[1][1] == DOT_O) && (map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((map[2][2] == DOT_O) && (map[1][2] == DOT_O) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((map[0][0] == DOT_O) && (map[2][0] == DOT_O) && (map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((map[0][1] == DOT_O) && (map[2][1] == DOT_O) && (map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((map[0][2] == DOT_O) && (map[2][2] == DOT_O) && (map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }

        // Проверка победы (по горизонтали)
        if ((map[0][0] == DOT_O) && (map[0][1] == DOT_O) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }
        if ((map[1][0] == DOT_O) && (map[1][1] == DOT_O) && (map[1][2] == DOT_EMPTY)) {
            y = 1;
            x = 2;
            result = true;
        }
        if ((map[2][0] == DOT_O) && (map[2][1] == DOT_O) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[0][2] == DOT_O) && (map[0][1] == DOT_O) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[1][2] == DOT_O) && (map[1][1] == DOT_O) && (map[1][0] == DOT_EMPTY)) {
            y = 1;
            x = 0;
            result = true;
        }
        if ((map[2][2] == DOT_O) && (map[2][1] == DOT_O) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[0][0] == DOT_O) && (map[0][2] == DOT_O) && (map[0][1] == DOT_EMPTY)) {
            y = 0;
            x = 1;
            result = true;
        }
        if ((map[1][0] == DOT_O) && (map[1][2] == DOT_O) && (map[1][1] == DOT_EMPTY)) {
            y = 1;
            x = 1;
            result = true;
        }
        if ((map[2][0] == DOT_O) && (map[2][2] == DOT_O) && (map[2][1] == DOT_EMPTY)) {
            y = 2;
            x = 1;
            result = true;
        }

        // Проверка победы (по диагонали)
        if ((map[0][0] == DOT_O) && (map[1][1] == DOT_O) && (map[2][2] == DOT_EMPTY)) {
            y = 2;
            x = 2;
            result = true;
        }
        if ((map[2][2] == DOT_O) && (map[1][1] == DOT_O) && (map[0][0] == DOT_EMPTY)) {
            y = 0;
            x = 0;
            result = true;
        }
        if ((map[0][2] == DOT_O) && (map[1][1] == DOT_O) && (map[2][0] == DOT_EMPTY)) {
            y = 2;
            x = 0;
            result = true;
        }
        if ((map[2][0] == DOT_O) && (map[1][1] == DOT_O) && (map[0][2] == DOT_EMPTY)) {
            y = 0;
            x = 2;
            result = true;
        }

        if (result) {
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_O;
            printMap();
        }
        return result;
    }

}
