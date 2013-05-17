package View;

import Controler.SaveTableMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída reprezentuje talčítko "Save Table" v menu "Database"
 *
 * @author Suchý Vojtěch
 */
public class SaveDBMenuItem {
        private static JMenuItem item = null;

    private SaveDBMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("Save Table", IconUtils.getGeneralIcon("Save", 16));
            //Hot-key N+CTRL
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
            item.addActionListener(new SaveTableMenuItemEvent());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return item;
        } else {
            return item;
        }
    }
}
