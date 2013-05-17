package Controler;

import Model.Database.SaveTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Save Table" v menu
 * "Database"
 *
 * @author Suchý Vojtěch
 */
public class SaveTableMenuItemEvent implements ActionListener {

    SaveTable saveTable = new SaveTable();

    @Override
    public void actionPerformed(ActionEvent e) {
            saveTable.save();
    }
}
