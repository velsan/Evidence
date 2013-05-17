package Model.File;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Save" v menu "File". Pro
 * zápis do souboru je použit PrintWriter a položky/knihy jsou zapisovány
 * způsobem, jenž je kompatibilní se čtením (soubor lze pak přečííst rozdělením
 * na tokeny)
 *
 * @author Suchý Vojtěch
 */
public class SaveFile {

    public void saveFile() {

        try {
            File file = Soubor.getInstance();
            ArrayList<Kniha> seznam = SeznamKnih.getInstanceCopy();

            PrintWriter pw = new PrintWriter(file);
            for (Iterator<Kniha> it = seznam.iterator(); it.hasNext();) {
                Kniha kniha = it.next();
                pw.print(kniha.getNazev());
                pw.print("\t");
                pw.print(kniha.getAutor());
                pw.print("\t");
                pw.print(kniha.getVydano());
                pw.println();
            }

            pw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while saving file!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
