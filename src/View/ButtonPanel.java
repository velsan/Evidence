package View;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *Tato třída reprezentuje JPanel - panel který je zobrazen v horní části obrazovky
 * a jsou v něm zobrazena tačítka pro řazení seznamu
 * @author Suchý Vojtěch
 */
public class ButtonPanel {

    private static JPanel panel = null;

    private ButtonPanel() {
    }

    public static JPanel getInstance() {
        if (panel == null) {
            panel = new JPanel(new FlowLayout());
            panel.add(DeleteButton.getInstance());
            panel.add(AddButton.getInstance());
            panel.add(ModifyButton.getInstance());
            panel.setBackground(Color.decode("#B3EE3A"));
            return panel;
        } else {
            return panel;
        }
    }
}
