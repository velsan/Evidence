package View;

import javax.swing.JMenuBar;

/**
 * Tato třída reprezentuje MenuBar - zde jsou zobrazena tlačítka "File" a "Edit"
 *
 * @author Suchý Vojtěch
 */
public class MenuBar {

    private static JMenuBar bar = null;

    private MenuBar() {
    }

    public static JMenuBar getInstance() {
        if (bar == null) {
            bar = new JMenuBar();
            return bar;
        } else {
            return bar;
        }
    }
}
