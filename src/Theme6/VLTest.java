package Theme6;
import javax.swing.*;

public class VLTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame("VerticalLayoutTest");
        frame.setSize(260, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new VerticalLayout());
        contents.add (new JButton("Продукты"));
        contents.add (new JButton("Галантерея"));
        contents.add (new JTextField(20));
        frame.setContentPane(contents);
        frame.setVisible( true );
    }
}