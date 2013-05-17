package View;

import Controler.RedoMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída reprezentuje tlačítko "Redo" v menu "Edit"
 *
 * @author Suchý Vojtech
 */
public class RedoMenuItem {

    private static JMenuItem redo = null;

    private RedoMenuItem() {
    }

    public static JMenuItem getInstace() {
        if (redo == null) {
            redo = new JMenuItem("Redo", IconUtils.getGeneralIcon("Redo", 16));
            redo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
            redo.addActionListener(new RedoMenuItemEvent());
            redo.setEnabled(false);
            return redo;
        } else {
            return redo;
        }
    }
}
