package Model.File;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Tato třída reprezentuje FileFilter, který je použit u FileChooser Tento filtr
 * zobrazuje pouze soubory s koncovou ".evd"
 *
 * @see View.OpenFileChooser
 * @author Suchý Vojtěch
 */
public class MyFileFilter extends FileFilter {

    /**
     * Kontrola, zda má filtr zobrazit soubor z parametru
     *
     * @param file File the Filter is checking
     * @return True if file ends with ".xml"
     */
    @Override
    public boolean accept(File file) {
        String s = file.getName();
        return (s.endsWith(".xml"));
    }

    @Override
    public String getDescription() {
        String popis = "Filtr zobrazí pouze soubory s koncovku *.xml";
        return popis;
    }
}
