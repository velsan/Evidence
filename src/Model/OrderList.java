package Model;

import java.util.Comparator;

/**
 * Tato třída je využita pro seřazení SeznamuKnih a má tři vnitřní třídy.
 * Vnitřní třídy implementují rozrahní Comparator a slouží k řaení seznamu podle
 * autora, názvu a data vydání
 *
 * @author Suchý Vojtěch
 */
public class OrderList {

    private final AutorCompare autor = new AutorCompare();
    private final NameCompare nazev = new NameCompare();
    private final DateCompare vydano = new DateCompare();
    
    /*
     * getry pro Comparatory
     */

    public AutorCompare getAutorCompare() {
        return autor;
    }
    public NameCompare getNameCompare() {
        return nazev;
    }

    public DateCompare getDateCompare() {
        return vydano;
    }

    /**
     * Vnitřní třída sloužící pro seřazení ArrayListu objektů třídy Seznam podle
     * autora knihy. Implementuje rozhraní Comparator
     */
    public class AutorCompare implements Comparator<Kniha> {

        @Override
        public int compare(Kniha first, Kniha second) {
            return first.getAutor().compareToIgnoreCase(second.getAutor());
        }
    }

    /**
     * Vnitřní třída sloužící pro seřazení ArrayListu objektů třídy Seznam podle
     * názvu knihy. Implementuje rozhraní Comparator
     */
    public class NameCompare implements Comparator<Kniha> {

        @Override
        public int compare(Kniha first, Kniha second) {
            return first.getNazev().compareToIgnoreCase(second.getNazev());
        }
    }

    /**
     * Vnitřní třída sloužící pro seřazení ArrayListu objektů třídy Seznam podle
     * data vydání. Implementuje rozhraní Comparator
     */
    public class DateCompare implements Comparator<Kniha> {

        @Override
        public int compare(Kniha first, Kniha second) {
            return first.getVydano().compareToIgnoreCase(second.getVydano());
        }
    }
}
