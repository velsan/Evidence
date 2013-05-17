package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tato třída repreznetuje Jpanel, že je zobrazen ve vrchní části GUI
 *
 * @author Suchý Vojtěch
 */
public class SortPanel {

    private static JPanel panel = null;

    private SortPanel() {
    }

    public static JPanel getInstance() {
        if (panel == null) {
            panel = new JPanel(new BorderLayout());
            inicialize();
            return panel;
        } else {
            return panel;
        }
    }

    private static void inicialize() {
        //přidání RadioBox pro třídění
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(RadioButtonName.getInstance());
        panel2.add(RadioButtonAutor.getInstance());
        panel2.add(RadioButtonDate.getInstance());
        panel2.setBackground(Color.decode("#B3EE3A"));

        //přidání předešlého panelu společně s JTextField pro vyhledávání a popiskem
        panel.add(panel2, BorderLayout.NORTH);
        JLabel label = new JLabel("   Search:    ", JLabel.LEFT);
        panel.add(label, BorderLayout.WEST);
        panel.add(SearchTextField.getInstance(), BorderLayout.CENTER);
        panel.setBackground(Color.decode("#B3EE3A"));
    }
}
