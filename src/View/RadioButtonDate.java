package View;

import Controler.RadioBtDateEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JRadioButton;

/**
 * Třída reprezentující RadioButton. Reakcí na zaškrtnutí tohoto tlačíka bude
 * seřazení seznamu knih podle data vydání.
 *
 * @author Suchý Vojtěch
 */
public class RadioButtonDate {

    private static JRadioButton jrb = null;
    private final static Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private RadioButtonDate() {
    }

    public static JRadioButton getInstance() {
        if (jrb == null) {
            jrb = new JRadioButton("Date");
            jrb.addItemListener(new RadioBtDateEvent());
            jrb.setToolTipText("Click this button to sort list numerically according to date of release");
            jrb.setBackground(Color.decode("#B3EE3A"));
            //jrb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            //jrb.setBorderPainted(true);
            jrb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jrb.setFont(font);
            return jrb;
        } else {
            return jrb;
        }
    }
}
