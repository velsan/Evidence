
package Test;

import java.io.IOException;

/**
 *
 * @author Suchý Vojtěch
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Soubor soubor = new Soubor();
        soubor.vytvor();
        soubor.zapis();
        soubor.cti();
    }
}
