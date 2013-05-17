package View;

import java.awt.Cursor;
import javax.swing.JMenu;

/**
 * Tato třída reprezentuje ikonu "Edit" v menu programu
 *
 * @author Suchý Vojtěch
 */
public class MenuEdit {

    private static JMenu edit = null;

    private MenuEdit() {
    }

    public static JMenu getInstance() {
        if (edit == null) {
            edit = new JMenu("Edit");
            edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return edit;
        } else {
            return edit;
        }
    }
}
