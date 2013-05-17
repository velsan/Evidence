package View;

import Controler.OpenTableMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Suchý Vojtěch
 */

public class OpenTableMenuItem {
    
 private static JMenuItem item = null;

    private OpenTableMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("Open Table", IconUtils.getGeneralIcon("Open", 16));
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
            item.addActionListener(new OpenTableMenuItemEvent ());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return item;
        } else {
            return item;
        }
    }   
}
