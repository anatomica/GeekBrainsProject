package Theme7;

public class TicTacToeGUI {

    public static final char DOT_EMPTY = '*'; // пустой символ
    public static final char DOT_X = 'X'; // крестик
    public static final char DOT_O = 'O'; // нолик
    public static int PlayerTurn = 1;

    public static void main(String[] args) {
        new GUI();
        new Map();
        Map.printMap();

        while (true) {
            if (PlayerTurn == 1) {
                if (Metods.verifyCompWin()) {
                    Checkers.isEndGame(DOT_O);
                }
                if (!Metods.verifyHumanWin() && PlayerTurn == 1) {
                    new ComputerTurn();
                }
                Checkers.isEndGame(DOT_O);
            }
            if (PlayerTurn == 2) {
                new HumanTurn();
                if (Checkers.DOT_X()){
                    Checkers.isEndGame(DOT_X);
                }
            }
        }
    }

    public static void passTurn() {
        if (PlayerTurn == 1)
            PlayerTurn = 2;
        else PlayerTurn = 1;
    }

    public static void GamerStart() {
        PlayerTurn = 1;
    }

}
