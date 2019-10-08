package Theme6;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow () {
        setBounds ( 500 , 500 , 400 , 300 );
        setTitle ( "Demo" );
        setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
        JPanel pan = new JPanel ();
        add ( pan );
        pan . addMouseListener ( new MouseAdapter() {
            @Override
            public void mouseReleased ( MouseEvent e ) {
                System . out . println ( "MousePos: " + e . getX () + " " + e . getY ());
            }
        });
        setVisible ( true );
    }

    public static void main (String[] args) {
        new MyWindow();
    }
}