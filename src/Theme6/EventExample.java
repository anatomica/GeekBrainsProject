package Theme6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventExample extends JFrame {

    public EventExample() {
        JFrame frame = new JFrame("Test Button");
        frame.setSize(260, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contents = new JPanel(new FlowLayout());
        JButton button = new JButton("Button");
        JTextField field = new JTextField (20);

        contents.add (button);
        contents.add (field);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed...");
            }
        };

        field.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                System.out.println ( "Your message: " + field.getText ());
            }
        });

        button.addActionListener(listener);
        field.addActionListener(field.getAction());
        frame.setContentPane(contents);
        frame.setVisible( true );
    }

    public static void main (String[] args) {
        new EventExample();
    }
}
