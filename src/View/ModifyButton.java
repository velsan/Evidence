package View;

import Controler.ModifyBtEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Tato třída reprezentuje tlačítko "Modify" v dolní části programu
 *
 * @author Suchý Vojtěch
 */
public class ModifyButton {

    private static JButton modifyBt = null;
    private final static Font font = new Font("SansSerif", Font.ITALIC + Font.BOLD, 14);

    private ModifyButton() {
    }

    public static JButton getInstance() {
        if (modifyBt == null) {
            modifyBt = new JButton("Modify");
            modifyBt.setFont(font);
            modifyBt.setToolTipText("Click this button to modify existing entry");
            modifyBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            modifyBt.addActionListener(new ModifyBtEvent());
            return modifyBt;
        } else {
            return modifyBt;
        }
    }
}
