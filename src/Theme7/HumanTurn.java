package Theme7;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanTurn implements ActionListener {

    HumanTurn() {
    }

    public void actionPerformed (ActionEvent e) {

        // Получить источник действия
        JButton clickedButton = (JButton) e.getSource();
        Object button = e.getSource();

        // Ход игрока
        for (int i = 0; i < (Map.SIZE * Map.SIZE); i++) {
        }
        if (button == GUI.numButtons[0]) {
            if (Checkers.isCellValid(0, 0)) {
                clickedButton.setText("X");
                Map.map[0][0] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[1]) {
            if (Checkers.isCellValid(1, 0)) {
                clickedButton.setText("X");
                Map.map[0][1] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[2]) {
            if (Checkers.isCellValid(2, 0)) {
                clickedButton.setText("X");
                Map.map[0][2] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[3]) {
            if (Checkers.isCellValid(0, 1)) {
                clickedButton.setText("X");
                Map.map[1][0] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[4]) {
            if (Checkers.isCellValid(1, 1)) {
                clickedButton.setText("X");
                Map.map[1][1] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[5]) {
            if (Checkers.isCellValid(2, 1)) {
                clickedButton.setText("X");
                Map.map[1][2] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[6]) {
            if (Checkers.isCellValid(0, 2)) {
                clickedButton.setText("X");
                Map.map[2][0] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[7]) {
            if (Checkers.isCellValid(1, 2)) {
                clickedButton.setText("X");
                Map.map[2][1] = TicTacToeGUI.DOT_X;
            }
        }
        if (button == GUI.numButtons[8]) {
            if (Checkers.isCellValid(2, 2)) {
                clickedButton.setText("X");
                Map.map[2][2] = TicTacToeGUI.DOT_X;
            }
        }

        Map.printMap();
        TicTacToeGUI.passTurn();
    }
}
