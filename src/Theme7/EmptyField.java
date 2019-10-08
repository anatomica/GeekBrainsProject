package Theme7;

public class EmptyField extends Map {

    public EmptyField() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        for (int i = 0; i < (Map.SIZE * Map.SIZE); i++) {
            GUI.numButtons[i].setText("");
        }
        Map.printMap();
        GamerStart();
    }

}
