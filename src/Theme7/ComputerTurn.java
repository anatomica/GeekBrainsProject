package Theme7;
import java.util.Random;

public class ComputerTurn extends TicTacToeGUI{
    public static final boolean SILLY_MODE = false;
    public static final boolean TRUE_MODE = true;
    private static Random random = new Random();

    public ComputerTurn(){
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(Map.SIZE);
                y = random.nextInt(Map.SIZE);
            } while(!Checkers.isCellValid(x, y));
        }

        else if (TRUE_MODE) {
            do {
                x = random.nextInt(Map.SIZE);
                y = random.nextInt(Map.SIZE);
            } while (!Checkers.isCellValidNear(x, y));
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        Map.map[y][x] = DOT_O;
        Map.printMap();
        int cell = (y * Map.SIZE) + x;
        GUI.numButtons[cell].setText("O");
        TicTacToeGUI.passTurn();
    }
}
