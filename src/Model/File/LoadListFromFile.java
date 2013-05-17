package Model.File;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 * Třída LoadListFromFile načte data ze souboru na disku a uloží je jako obejkty
 * třídy Kniha do ArrayListu.
 *
 * @author Suchý Vojtěch
 */
public class LoadListFromFile {

    private File file;
    private ArrayList<Kniha> seznam;
    private BufferedReader br = null;

    public LoadListFromFile() {
    }

    /**
     * Tato metoda načte data ze souboru (to jest objektu třídy
     * Soubor) a uložení do seznamu knih (to jest objektu třídy SeznamKnih). Soubor je
     * čten po řádcích, které jsou rozděleny na příslušné tokeny a následně
     * přiděleny příslušným atributům instance třídy Kniha.
     *
     */
    public void naplnSeznam() {
        try {
            seznam = SeznamKnih.getInstance();
            seznam.clear();
            file = Soubor.getInstance();
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                Kniha kniha = new Kniha();
                StringTokenizer st = new StringTokenizer(line, "\t");
                kniha.setNazev(st.nextToken());
                kniha.setAutor(st.nextToken());
                kniha.setVydano(st.nextToken());
                seznam.add(kniha);
            }
            br.close();
            SeznamKnih.changeCopy();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while reading file!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } 
    }
}

