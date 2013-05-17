package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Tato třída slouží pro reprezentaci hlavního frame
 *
 * @author Suchý Vojtěch
 */
public class Frame {

    private static JFrame jframe = null;
    private static Image picture;
    private static Toolkit tool;

    public static JFrame getInstance() {
        if (jframe == null) {
            jframe = new JFrame();
            inicialize();
            setIcon();
            return jframe;
        } else {
            return jframe;
        }
    }

    /**
     * Inicializuje úvodní nastavení komponenty
     */
    private static void inicialize() {
        jframe.setVisible(true);
        jframe.setTitle("Evidence");
        jframe.setLayout(new BorderLayout(10, 10));
        jframe.setSize(350, 350);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocation(500, 150);
        jframe.setBackground(Color.decode("#CDCD00"));
    }

    /**
     * Přidá komponentě vlastní ikonu
     */
    private static void setIcon() {
        tool = Toolkit.getDefaultToolkit();
        picture = tool.getImage("book.png");
        jframe.setIconImage(picture);

    }
}
