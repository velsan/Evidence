package Model.Database;

import javax.swing.DefaultListModel;

/**
 * Tato třída používá instanci třídy DefaultListModel a reprezentuje seznam
 * tabulek, jež jsou načteny z databáze
 *
 * @author Suchý Vojtěch
 */
public class ListOfTables {
    
    private static DefaultListModel listModel = null;

    private ListOfTables() {
    }

    public static DefaultListModel getInstance() {
        if (listModel == null) {
            listModel = new DefaultListModel();
            return listModel;
        } else {
            return listModel;
        }
    }
}
