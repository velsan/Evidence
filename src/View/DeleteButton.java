package View;

import Controler.DeleteBtEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Tato třída reprezentuje tlačítko "Delete", jež je zobrazeno ve spodní části
 * obrazovky
 *
 * @author Suchý Vojtěch
 */
public class DeleteButton {

    private static JButton bt = null;
    private static final Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private DeleteButton() {
    }

    public static JButton getInstance() {
        if (bt == null) {
            bt = new JButton("Delete");
            bt.addActionListener(new DeleteBtEvent());
            bt.setToolTipText("Click this button to delet selected entry");
            bt.setFont(font);
            bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return bt;
        } else {
            return bt;
        }
    }
}
