package View;

import Controler.AddBtEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Třída reprezentuje tlačítko "Add" jež je zobrazeno v dolním panelu. Reakcí na
 * vyvolání události tohoto tlačítka je přidání nové polořky/knihy
 *
 * @see Controler.AddBtEvent
 * @author Suchý Vojtěch
 */
public class AddButton {

    private static JButton bt = null;
    private final static Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private AddButton() {
    }

    public static JButton getInstance() {
        if (bt == null) {
            bt = new JButton("Add");
            bt.addActionListener(new AddBtEvent());
            bt.setToolTipText("Click this button to add new entry");
            bt.setFont(font);
            bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return bt;
        } else {
            return bt;
        }
    }
}
