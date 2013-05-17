package Model;

/**
 * Provedeli se se SenamemKnih nějaké změna, bude hodnota proměnné index
 * nastavena na 1. Budeli SeznamKnih uložen do souboru, index se nastaví na
 * 0. Účelem třídy je nabídnout možnost uložit provedené změny před ukončením
 * programu
 *
 * @author Suchý Vojtěch
 */
public class ModifiedFileVariable {

    private static int index = 0;
    private static boolean db;
    private static boolean file;

    private ModifiedFileVariable() {
    }
/*getInstance musí vracet podle toho, jestli se pracuje se souborem nebo s databází
 * když se volá openFile nebo openDB, tak se nastaví proměnná pro práci
 * 
 * spíš udělám druhou proměnnou boolean a ty budu nstavovat podle s čim se pracuje
 * a pak
 */
    public static int getInstance() {
        return index;
    }

    /**
     * Tato metoda je volána ze třídy, kde dojde k uložení souboru. Proměnná
     * index je poté nastavena na nulu (čímž se indikuje, že v souboru
     * nejsou žádné změny)
     */
    public static void FileWasSaved() {
        index = 0;
    }

    /**
     * Tato metoda je volána ze tříd, kde dochází k nějakým modifikacím se
     * SeznamKnih. Proměnná index je poté nastavena na 1 (čímž se indikuje,
     * že SeznamKnih se změnil a soubor je třeba uložit)
     */
    public static void FileWasModified() {
        index = 1;
    }

    public static boolean isDb() {
        return db;
    }

    public static void setDb(boolean db) {
        ModifiedFileVariable.db = db;
    }

    public static boolean isFile() {
        return file;
    }

    public static void setFile(boolean file) {
        ModifiedFileVariable.file = file;
    }
    
    
}
