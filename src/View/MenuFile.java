package View;

import java.awt.Cursor;
import javax.swing.JMenu;

/**
 * Tato třída reprezentuje ikonu "File" v menu programu
 *
 * @author Suchý Vojtěch
 */
public class MenuFile {

    private static JMenu menu = null;

    private MenuFile() {
    }

    public static JMenu getInstance() {
        if (menu == null) {
            menu = new JMenu("File");
            menu.getAccessibleContext().setAccessibleDescription(
                    "The menu of Evidence 2.0");
            menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return menu;
        } else {
            return menu;
        }
    }
}
