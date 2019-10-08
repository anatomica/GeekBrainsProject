package Theme6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemo extends JFrame implements ActionListener {
    public MenuDemo () {
    // Создаем панель меню
        JMenuBar menubar = new JMenuBar();
    // Создаем меню
        JMenu menu = new JMenu( "File" );
        // ------------------------------------
        // Добавление простых элементов меню
        // Элемент 1
        JMenuItem itm = new JMenuItem( "New" );
        menu.add(itm);
        itm.addActionListener( this );
        // Элемент 2
        itm = new JMenuItem( "Open" );
        itm.addActionListener( this );
        menu.add(itm);
        // Элемент 3
        itm = new JMenuItem( "Close" );
        itm.addActionListener( this );
        menu.add(itm);
        // Если нужен элемент меню с иконкой
        //itm = new JMenuItem("Close", new ImageIcon("image.gif"));
        //itm = new JMenuItem(new ImageIcon("image.gif"));
        // Добавляем разделитель
        menu.add( new JSeparator());
        // Создаем вложенное меню
        JMenu submenu = new JMenu( "Sub" );
        itm = new JMenuItem( "Print" );
        itm.addActionListener( this );
        submenu.add(itm);
        // Следующему элементу назначим быструю
        // клавишу: ALT+E
        itm = new JMenuItem( "Export" );
        itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                ActionEvent.ALT_MASK));
        itm.addActionListener( this );
        submenu.add(itm);
        // Добавляем вложенное меню
        menu.add(submenu);
        // Добавляем меню в панель меню
        menubar.add(menu);
        // Добавляем панель меню в окно
        setJMenuBar(menubar);
        // -------------------------------------------
        // Настройка окна
        setTitle( "Menu Demo" ); // заголовок окна
        // Желательные размеры окна
        setPreferredSize( new Dimension( 640 , 480 ));
        // Завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Устанавливаем желательные размеры
        setVisible( true ); // Отображаем окно
    }
    @Override
    public void actionPerformed (ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());
    }
    public static void main (String[] args) {
        new MenuDemo();
    }
}