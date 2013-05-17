package View;

import Controler.NewFileMenuItemEvent;
import Model.IconUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Tato třída slouží pro reprezentaci tlačítka "New" v menu "File" Rakcí na
 * kliknutí je vyvoření nového souboru
 *
 * @see Controler.NewFileMenuItemEvent
 * @author Suchý Vojtěch
 */
public class NewFileMenuItem {

    private static JMenuItem item = null;

    private NewFileMenuItem() {
    }

    public static JMenuItem getInstance() {
        if (item == null) {
            item = new JMenuItem("New File", IconUtils.getGeneralIcon("New", 16));
            //Hot-key N+CTRL
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
            item.addActionListener(new NewFileMenuItemEvent());
            item.setCursor(new Cursor(Cursor.HAND_CURSOR));

            return item;
        } else {
            return item;
        }
    }
}
