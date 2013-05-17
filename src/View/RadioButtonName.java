package View;

import Controler.RadioBtNameEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JRadioButton;

/**
 * Třída reprezentující RadioButton. Reakcí na zaškrtnutí tohoto tlačíka bude
 * seřazení seznamu knih abecedně podle názvu
 *
 * @author Suchý Vojtěch
 */
public class RadioButtonName {

    private static JRadioButton jrb = null;
     private static Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private RadioButtonName() {
    }

    public static JRadioButton getInstance() {
        if (jrb == null) {
            jrb = new JRadioButton("Name");
            jrb.addItemListener(new RadioBtNameEvent());
            jrb.setToolTipText("Click this button to sort list alphabetically according to Name");
            //jrb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
             jrb.setBackground(Color.decode("#B3EE3A"));
            //jrb.setBorder(BorderFactory.createBevelBorder(10));
            //jrb.setBorderPainted(true);
            jrb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jrb.setFont(font);
            return jrb;
        } else {
            return jrb;
        }
    }
}
