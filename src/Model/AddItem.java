package Model;

import View.AddForm;
import View.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Třída AddItem slouží pro přidávání nových položek do obejtku třídy SeznamKnih
 *
 * @author Suchý Vojtěch
 */
public class AddItem {

    private ArrayList<Kniha> seznam;
    private static Kniha kniha = null;
    private AddForm form;

    /**
     * Metoda pro přidání nové instance do objektu třídy Seznam. Načte název,
     * autora a datum vydání knihy, kterou následně uloží.
     */
    public void pridejDoSeznamu() {
        form = AddForm.getInstance();
        seznam = SeznamKnih.getInstanceCopy();
        Kniha kniha = new Kniha();
        String autor = form.getAutor();
        String nazev = form.getName();
        String vydano = form.getDate();

        if (autor.isEmpty() && nazev.isEmpty() && vydano.isEmpty()) {
            ModifiedFileVariable.FileWasSaved();
            JOptionPane.showMessageDialog(Frame.getInstance(), "No data entered!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //nastavené autora knihy
            if (autor.isEmpty()) {
                kniha.setAutor("Nezadáno!");
            } else {
                kniha.setAutor(autor);
            }
            //nastavení názvu knihy
            if (nazev.isEmpty()) {
                kniha.setNazev("Nezadáno!");
            } else {
                kniha.setNazev(nazev);
            }
            //nastavení data vydání knihy
            if (vydano.isEmpty()) {
                kniha.setVydano("Nezadáno!");
            } else if (vydano.toString().matches("^\\d{0,4}?$")){
                kniha.setVydano(vydano);
            } else {
                JOptionPane.showMessageDialog(Frame.getInstance(), "Date must be 0-4 digit number!", "Error", JOptionPane.ERROR_MESSAGE);
                kniha.setVydano("Nezadáno!");
            }
            

            seznam.add(kniha);
            //nastavení instanční proměnné kniha
            setKniha(kniha);
            //nastavení "lokální proměnné" na null
            kniha = null;
        }
    }

    /**
     * Tato metoda je volána ze třídy ConfirmAddForm, kde je třeba předat tříde
     * AddButtonEdit do konstruktoru vytvořenou knihu
     *
     * @return vyvořená kniha
     */
    public static Kniha getKniha() {
        return kniha;
    }

    public void setKniha(Kniha kniha) {
        this.kniha = kniha;
    }
}
