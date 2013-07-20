package Controler;

import Model.File.LoadListFromFile;
import Model.File.Soubor;
import Model.ModifiedFileVariable;
import Model.WriteList;
import View.Frame;
import View.OpenFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží jako reakce na události tlačítka "Open" v menu "File"
 *
 * @author Suchý Vojtěch
 */
public class OpenFileMenuItemEvent implements ActionListener {

    private final JFileChooser chooser = OpenFileChooser.getInstance();
    private final WriteList vypis = new WriteList();
    private final LoadListFromFile nacti = new LoadListFromFile();

    @Override
    public void actionPerformed(ActionEvent ae) {
        int value = chooser.showOpenDialog(null);

        if (value == JFileChooser.APPROVE_OPTION) {
            String s = chooser.getSelectedFile().getAbsolutePath();
            String jmeno = chooser.getSelectedFile().getName();
            if (jmeno.endsWith(".xml")) {
                Soubor.setName(s);
                nacti.naplnSeznam();
                vypis.vypis();
                ModifiedFileVariable.setFile(true);
                ModifiedFileVariable.setDb(false);
                ModifiedFileVariable.FileWasSaved();
                Soubor.setLoaded(true);
            } else {
                JOptionPane.showMessageDialog(Frame.getInstance(), " File format must be *.xml", "Error while opening file!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
