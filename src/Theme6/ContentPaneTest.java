package Theme6;
import javax.swing.*;

public class ContentPaneTest extends JFrame {
    public ContentPaneTest ()
    {
        super ( "Test ContentPane" );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
// Создание панели с двумя кнопками
        JPanel contents = new JPanel();
        contents.add( new JButton( "Java" ));
        contents.add( new JButton( "PHP" ));
// Замена панели содержимого
        setContentPane(contents);
// Определение размера окна
        setSize( 200 , 100 );
// Открытие окна
        setVisible( true );
    }
    public static void main (String[] args) {
        JFrame.setDefaultLookAndFeelDecorated( true );
        new ContentPaneTest();
    }
}