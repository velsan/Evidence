package View;

import java.awt.Cursor;
import javax.swing.JMenu;

/**
 * Tato třída slouží jako reprezentace tlačítka "Database" v liště pro menu
 *
 * @author Suchý Vojtěch
 */
public class MenuDatabase {

    private static JMenu menu;

    private MenuDatabase() {
    }

    public static JMenu getInstance() {
        if (menu == null) {
            menu = new JMenu("Database");
            menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return menu;
        } else {
            return menu;
        }
    }
}
