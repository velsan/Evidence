package Model;

import View.SearchTextField;
import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 * Tato třída slouží pro reprezentaci instance třídy Document, jež je získána od
 * komponenty JTextField
 * 
 * @see javax.swing.text.Document
 * @author Suchý Vojtěch
 */
public class DocumentSearchField {

    private static Document doc = null;
    private final static JTextField field = SearchTextField.getInstance();
    
    private DocumentSearchField() {
    }
    
    public static Document getInstance() {
        if (doc == null) {
            doc = field.getDocument();
        }
        return doc;
    }
}
