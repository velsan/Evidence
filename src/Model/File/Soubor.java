package Model.File;

import java.io.File;

/**
 * Objekt třídy Soubor slouží pro abstraktní reprezentaci souboru na disku, ze
 * kterého budou načítána data.
 *
 * @author Suchý Vojtěch
 */
public class Soubor {

    private static File Singleton = null;
    private static boolean Loaded = false;

    public static boolean isLoaded() {
        return Loaded;
    }

    public static void setLoaded(boolean Loaded) {
        Soubor.Loaded = Loaded;
    }
    /*TO DO - po testování změnit name na null
     * Pak také musim změnit metodu main() a nevolatmetodu nacti()
     * Kdyý bude name null a já nebudu volat raadListFormFile, tak se mi chyba nevyhodí nikdy
     * protože přes file chooser dostane vždy správný name.
     */
    private static String name;

    private Soubor() {
    }

    public static File getInstance() {
        if (Singleton == null) {
            Singleton = new File(name);
            return Singleton;

        } else {
            return Singleton;
        }
    }

    /**
     * Slouží pro nastavení cesty souboru. Jedná se o statickou metodu, aby
     * mohla být volána přes třídu (nikoliv přes instanci třídy).
     *
     * @param name Obsahuje cestu k souboru
     */
    public static void setName(String name) {
        Soubor.name = name;
        Soubor.Singleton = null;
    }

    /**
     * Returnuje cestu k souboru. Jedná se o statickou metodu, aby mohla být
     * volána přes třídu (nikoliv přes instanci třídy).
     *
     * @return String s cestou k souboru
     */
    public static String getName() {
        return Soubor.name;
    }
}
