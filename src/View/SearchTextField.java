package View;

import java.awt.Color;
import javax.swing.JTextField;

/**
 * Tato třída reprezentuje JTextField do pomocí kterého může uživatel
 * fulltextově vyhledávat v seznamu knih
 *
 * @see Controler.SearchFieldEvent
 * @author Suchý Vojtěch
 */
public class SearchTextField {

    private static JTextField searchField = null;

    private SearchTextField() {
    }

    public static JTextField getInstance() {
        if (searchField == null) {
            searchField = new JTextField(10);
            searchField.setBackground(Color.WHITE);
            return searchField;
        } else {
            return searchField;
        }
    }
}
