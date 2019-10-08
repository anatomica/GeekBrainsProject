package Theme6;
import javax.swing.*;
import java.awt.*;

public class CalculatorMy extends JFrame{
    public CalculatorMy() {
        super ("Калькулятор");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField displayField;
        JPanel contents = new JPanel(new BorderLayout());
        displayField = new JFormattedTextField();
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        contents.add("North",displayField);

        JButton [] numButtons= new JButton[20];
        numButtons[0] = new JButton(" ");
        numButtons[1] = new JButton(" ");
        numButtons[2] = new JButton(" ");
        numButtons[3] = new JButton("/");
        numButtons[4] = new JButton(" 1 ");
        numButtons[5] = new JButton(" 2 ");
        numButtons[6] = new JButton(" 3 ");
        numButtons[7] = new JButton(" * ");
        numButtons[8] = new JButton(" 4 ");
        numButtons[9] = new JButton(" 5 ");
        numButtons[10] = new JButton(" 6 ");
        numButtons[11] = new JButton(" - ");
        numButtons[12] = new JButton(" 7 ");
        numButtons[13] = new JButton(" 8 ");
        numButtons[14] = new JButton(" 9 ");
        numButtons[15] = new JButton(" + ");
        numButtons[16] = new JButton(" ");
        numButtons[17] = new JButton(" 0 ");
        numButtons[18] = new JButton(".");
        numButtons[19] = new JButton("=");

        JPanel Buttons;
        Buttons = new JPanel();
        GridLayout gl =new GridLayout(5,4, 5,5);
        Buttons.setLayout(gl);
        for (int i=0; i<=19; i++){
            Buttons.add(numButtons[i]);
        }

        setContentPane(contents);
        getContentPane().add(Buttons);
        setVisible( true );
    }

    public static void main (String[] args) {
        new CalculatorMy();
    }
}
