package View;

import Controler.UndoMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída slouží pro reprezentaci talčítka "Undo" v menu "Edit"
 *
 * @see Controler.UndoMenuItemEvent
 * @author Suchý Vojtěch
 */
public class UndoMenuItem {

    private static JMenuItem undo = null;

    private UndoMenuItem() {
    }

    public static JMenuItem getInstace() {
        if (undo == null) {
            undo = new JMenuItem("Undo", IconUtils.getGeneralIcon("Undo", 16));
            undo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
            undo.addActionListener(new UndoMenuItemEvent());
            undo.setEnabled(false);
            return undo;
        } else {
            return undo;
        }
    }
}
