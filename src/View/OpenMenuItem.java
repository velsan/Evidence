package View;

import Controler.OpenFileMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída reprezentuje tlačítko "Open" v menu "File"
 *
 * @author Suchý Vojtěch
 */
public class OpenMenuItem {

    private static JMenuItem item = null;

    private OpenMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("Open File", IconUtils.getGeneralIcon("Open", 16));
            //Hot-key O+CTRL
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
            item.addActionListener(new OpenFileMenuItemEvent());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return item;
        } else {
            return item;
        }
    }
}
