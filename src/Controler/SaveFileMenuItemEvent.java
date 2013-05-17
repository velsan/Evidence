package Controler;

import Model.ModifiedFileVariable;
import Model.File.SaveFile;
import Model.File.Soubor;
import View.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Save" v menu "File"
 *
 * @author Suchý Vojtěch
 */
public class SaveFileMenuItemEvent implements ActionListener {

    private final SaveFile save = new SaveFile();

    @Override
    public void actionPerformed(ActionEvent ae) {
        save.saveFile();
        ModifiedFileVariable.FileWasSaved();
        JOptionPane.showMessageDialog(Frame.getInstance(), "File " + Soubor.getInstance().getName() + " was saved", "Saving was successful!", JOptionPane.INFORMATION_MESSAGE);
    }
}
