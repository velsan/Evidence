package View;

import Controler.RadioBtAutorEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JRadioButton;

/**
 * Třída reprezentující RadioButton. Reakcí na zaškrtnutí tohoto tlačíka bude
 * seřazení seznamu knih abecedně podle autora
 *
 * @author Suchý Vojtěch
 */
public class RadioButtonAutor {

    private static JRadioButton jrb = null;
     private static Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private RadioButtonAutor() {
    }

    public static JRadioButton getInstance() {
        if (jrb == null) {
            jrb = new JRadioButton("Autor");
            jrb.addItemListener(new RadioBtAutorEvent());
            jrb.setToolTipText("Click this button to sort list alphabetically according to Autor");
            jrb.setBackground(Color.decode("#B3EE3A"));
            //jrb.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(5), BorderFactory.createLineBorder(Color.decode("#E0EEE0"),1)));
            //jrb.setBorderPainted(true);
            jrb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jrb.setFont(font);
            return jrb;
        } else {
            return jrb;
        }
    }
}
