package View;

import Controler.SaveFileMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída reprezentuje tlačítko "Save" v menu "File"
 *
 * @author Suchý Vojtěch
 */
public class SaveFileMenuItem {

    private static JMenuItem item = null;

    private SaveFileMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("Save File", IconUtils.getGeneralIcon("Save", 16));
            //Hot-key N+CTRL
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
            item.addActionListener(new SaveFileMenuItemEvent());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return item;
        } else {
            return item;
        }
    }
}
