package Controler;

import Model.Database.LoadDBTables;
import View.OpenTableJList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tato třída slouží jako reakce na událost při stisknutí tlačítka "Open Table"
 * v menu "Database"
 *
 * @author Suchý Vojtěch
 */
public class OpenTableMenuItemEvent implements ActionListener {

    //private final ;
    private final LoadDBTables loadTable = new LoadDBTables();

    @Override
    public void actionPerformed(ActionEvent e) {

            try {
                //načte tabulky do listModel
            loadTable.loadTables();
            OpenTableJList.createWindow();
            } catch (NullPointerException ex) {
                
            }
            
       
    }
}
