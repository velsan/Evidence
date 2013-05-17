package View;

import Controler.NewTableMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída slouží jako reprezentace tlačítka "New Table" v menu "Database"
 *
 * @author Suchý Vojtěch
 */
public class NewTableMenuItem {
    
    private static JMenuItem item = null;
    
        private NewTableMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("New Table", IconUtils.getGeneralIcon("New", 16));
            //Hot-key N+CTRL
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
            item.addActionListener(new NewTableMenuItemEvent());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return item;
        } else {
            return item;
        }
    }
}
