package Model;

import Model.File.ListOfBooks;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 * Tato třída sloiží pro vypasání Sezamu knih na obrazovku (do JList, defacto
 * DefaultListModel, jež slouží pro správu dat v JList)
 *
 * @author Suchý Vojtěch
 */
public class WriteList {

    public void vypis() {
        DefaultListModel list = ListOfBooks.getInstance();
        ArrayList<Kniha> seznam = SeznamKnih.getInstanceCopy();
        Kniha kniha = new Kniha();
        list.removeAllElements();//vyčištění obrazovky

        for (Iterator<Kniha> iterator = seznam.iterator(); iterator.hasNext();) {
            kniha = iterator.next();
            list.addElement(kniha.getNazev() + "; " + kniha.getAutor() + "; " + kniha.getVydano() + "; ");
        }
    }
}
