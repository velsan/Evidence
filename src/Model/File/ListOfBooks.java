package Model.File;

import javax.swing.DefaultListModel;

/**
 * Tato třída reprezentuje instanci třídy DefaultListModel, jež umí
 * spravovat data, která se v JList vypisují na obrazovce.
 * 
 * Třída je vytvořena podle návrhového vzoru Singleton
 * 
 * @see javax.swing.DefaultListModel
 * @author Suchý Vojtěch
 */
public class ListOfBooks {

    private static DefaultListModel listModel = null;

    private ListOfBooks() {
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
