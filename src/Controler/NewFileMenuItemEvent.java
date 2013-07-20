package Controler;

import Model.File.LoadListFromFile;
import Model.File.Soubor;
import Model.WriteList;
import View.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Tato třída obsluhuje událost vyvolanou stisknutím tlačítka "New" z menu
 * "File"
 *
 * @author Suchý Vojtěch
 */
public class NewFileMenuItemEvent implements ActionListener {

    private File file;
    private String s;
    private final WriteList vypis = new WriteList();
    private final LoadListFromFile nacti = new LoadListFromFile();

    @Override
    public void actionPerformed(ActionEvent ae) {

        s = JOptionPane.showInputDialog(Frame.getInstance(), "Enter the name of the file", "Create new file", JOptionPane.PLAIN_MESSAGE);
        if (s == null) {
        } else if (!(s.equals(""))) {
            createFile();
        } else {
            JOptionPane.showMessageDialog(Frame.getInstance(), "You must enter the name!", "Error while creating file!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metoda jež vytvoří nový soubor ve working directory
     */
    private void createFile() {
        try {
            //Cesta do working directory
            file = new File(System.getProperty("user.dir") + "\\" + s + ".xml");
            file.createNewFile();
            JOptionPane.showMessageDialog(Frame.getInstance(), "File " + s + " was created", "Creating file was successful!", JOptionPane.INFORMATION_MESSAGE);

            //naplnění seznamu a jeho vypsání na obrazovku
            Soubor.setName(s + ".xml");
            nacti.naplnSeznam();
            vypis.vypis();
            Soubor.setLoaded(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "File "+s+".xml was NOT created", "Error while creating file!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
