package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tato třída slouží pro vyhledávání položek v seznamu knih a je využita k
 * fulltextovému vyhledávání.
 *
 * @author Suchý Vojtěch
 */
public class SearchInList {

    private ArrayList<Kniha> seznam;
    private ArrayList<Kniha> vyhledane;
    private Kniha kniha;

    public SearchInList() {
        vyhledane = new ArrayList<Kniha>();
        seznam = SeznamKnih.getInstanceCopy();
    }

    /**
     * Metoda vyhledej() prochází pomocí metody iterator() jednotlivé objekty,
     * jež jsou uložené v ArrayListu seznam, a vyhledává v jednotlivých
     * atributech požadovaný text.
     *
     * @see Controler.SearchFieldEvent
     */
    public void vyhledej(String text) {
        vyhledane.clear();

        for (Iterator<Kniha> it = seznam.iterator(); it.hasNext();) {

            kniha = (Kniha) it.next();
            if (kniha.getNazev().contains(text)) {
                vyhledane.add(kniha);
                continue;
            } else if (kniha.getVydano().contains(text)) {
                vyhledane.add(kniha);
                continue;
            } else if (kniha.getAutor().contains(text)) {
                vyhledane.add(kniha);
                continue;
            }
        }
    }

    /**
     * Metoda pro přístup k položkám vyhledaných pomocí vyhledej()
     *
     * @see Controler.SearchFieldEvent
     * @return ArrayList obsahující vyhledané položky
     */
    public ArrayList<Kniha> getVyhledane() {
        return vyhledane;
    }
}
