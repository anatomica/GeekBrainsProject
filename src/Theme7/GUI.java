package Theme7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public static JButton[] numButtons = new JButton[Map.SIZE * Map.SIZE];
    public static JPanel contents;

    public GUI() {
        super("Крестики - нолики");
        setSize(400, 400);
        setLocation(new Point(450, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contents = new JPanel(new BorderLayout());

        // Кнопка Новая игра
        JPanel newGame = new JPanel();
        JButton newGameButton = new JButton("Новая игра!");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmptyField();
            }
        });
        newGame.setLayout(new BoxLayout(newGame, BoxLayout.Y_AXIS));
        newGameButton.setSize(100, 100);
        newGameButton.setBackground(Color.lightGray);
        contents.add("North", newGameButton);

        // Генерация кнопок
        String[] button = {"", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < (Map.SIZE * Map.SIZE); i++) {
            for (int j = 0; j < (Map.SIZE * Map.SIZE); j++) {
                if (i == j)
                    numButtons[i] = new JButton(button[i]);
            }
        }

        // Размещение кнопок на панели
        JPanel Buttons;
        Buttons = new JPanel();
        GridLayout layout = new GridLayout(Map.SIZE, Map.SIZE, 5, 5);
        Buttons.setLayout(layout);
        for (int i = 0; i < (Map.SIZE * Map.SIZE); i++) {
            JButton jButton = numButtons[i];
            jButton.setBackground(Color.white);
            jButton.setFont(new Font("Some-Font-Name", Font.BOLD, 60));
            Buttons.add(jButton);
        }
        Buttons.setBackground(Color.lightGray);
        contents.add("Center", Buttons);

        // Слушаем кнопки
        HumanTurn Engine = new HumanTurn();
        for (JButton numButton : numButtons) {
            numButton.addActionListener(Engine);
        }

        // Размещение панели в окне
        setContentPane(contents);
        setVisible(true);

    }

    public static void showMessage (String MessageText) {
        JOptionPane.showMessageDialog(contents, MessageText);

    }
}
