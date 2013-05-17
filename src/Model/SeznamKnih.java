package Model;

import java.util.ArrayList;

/**
 * V instanci třídy SeznamKnih je uložen seznam položek (Knih) načtených ze
 * souboru na disku.
 *
 * @author Suchý Vojtěch
 */
public class SeznamKnih {

    private static ArrayList<Kniha> Singleton = null;
    private static ArrayList<Kniha> SingletonCopy = null;

    /**
     * Privátní konstruktor
     */
    private SeznamKnih() {
    }

    /**
     * Tato instance je kopií instance v níž jsou načteny knihy ze souboru na
     * disku Je používána při operaci s knihami vypsanými na obrazovku (Add,
     * Modify, Delete) Důvodem vytvoření této třídy je, že při použití
     * fulltextového vyhledávání je třeba z kompletního seznamu položky
     * vymazávat a dále s nimi pracovat. Chce-li ale uživatel použít všechny
     * záznamy ze souboru na disku (nebo lépe řečeno po použití klávesy
     * BackSpace)
     *
     * @return Objekt třídy Seznam
     */
    public static ArrayList<Kniha> getInstanceCopy() {
        if (SingletonCopy == null) {
            changeCopy();
        }
        return SingletonCopy;
    }

    /**
     * V této instanci jsou uchovány knihy načtené ze souboru na disku
     *
     * @return ArrayList s knihami
     */
    public static ArrayList<Kniha> getInstance() {
        if (Singleton == null) {
            Singleton = new ArrayList<Kniha>();
        }
        return Singleton;
    }

    /**
     * Proč je tu tato metoda changeCopy()? Při použití klávesy BackSpace(či
     * obecně vymazání znaku v poli vyhledat - JTextField) se načtou do
     * SigletonCopy položky ze souboru na disku
     */
    public static void changeCopy() {
        SingletonCopy = getInstance();
    }

    /**
     * Při prohledání Jlistu s položkami se returnují vyhledané položky do
     * SingletonCopy, který je dále použit pro další práce (Save, Delete,
     * Modify...)
     */
    public static void setCopy(ArrayList<Kniha> list) {
        SingletonCopy = list;
    }
}
