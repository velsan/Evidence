package Controler;

import Model.DocumentSearchField;
import Model.Kniha;
import Model.SearchInList;
import Model.SeznamKnih;
import Model.WriteList;
import View.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * obsluhuje událost jež posílá Document od DocumentSearchField. Událost je
 * zaslána pokaždé, když uživatel zadá jakýkoliv znak.
 *
 * @see View.SearchTextField
 * @see Model.DocumentSearchField
 * @author Suchý Vojtěch
 */
public class SearchFieldEvent implements DocumentListener {

    private final Document doc = DocumentSearchField.getInstance();
    private final SearchInList search = new SearchInList();
    private final WriteList vypsat = new WriteList();

    /**
     * Tato metoda obsluhuje událost jež posílá Document od DocumentSearchField
     * a která nastává při vložení znaku do JTextField
     *
     * @param de
     */
    @Override
    public void insertUpdate(DocumentEvent de) {
        try {
            //text jež bude vyhledán
            String s = doc.getText(0, doc.getLength());
            //hledání textu
            search.vyhledej(s);
            ArrayList<Kniha> vyhledane = search.getVyhledane();
            //nastavení nového ArrayListu pro další práci (nejen vyhledávání ale i přidávání, mazání...)
            SeznamKnih.setCopy(vyhledane);
            //aktualizacce výpisu na obrazovku
            vypsat.vypis();

        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while searching", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * Tato metoda obsluhuje událost jež posílá Document od DocumentSearchField
     * a která nastává při vymazání znaku z JTextFiel
     *
     * @param de
     */
    @Override
    public void removeUpdate(DocumentEvent de) {
        try {
            //získání řetězce pro vyhládávání
            String s = doc.getText(0, doc.getLength());

            /*změna ArrayListu pro další práci - pri zmčáknutí Backspace (vymazání
             * znaku) musím vyhledávat z původního ArrayListu (POZN. tady by to šlo i  bez toho
             * protože špatně funguje iterator)
             */
            SeznamKnih.changeCopy();
            search.vyhledej(s);
            ArrayList<Kniha> vyhledane = search.getVyhledane();
            SeznamKnih.setCopy(vyhledane);
            vypsat.vypis();
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while searching", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    //Plain text components do not fire these events
    @Override
    public void changedUpdate(DocumentEvent de) {
    }
}
