package Controler;

import Model.Database.DBStatement;
import Model.Database.ListOfTables;
import Model.Database.LoadListFromTable;
import Model.ModifiedFileVariable;
import Model.WriteList;
import View.OpenTableJList;
import View.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Open Table" při zobraení
 * okna pro výběr tabulky z databáze (toto okno se zobrazí jako reakce na
 * stisknutí tlačítko "OpenTable" v menu "Database")
 *
 * @see View.Database.OpenTableJList
 * @see View.Database.OpenTableMenuItem
 * @author Suchý Vojtěch
 */
public class ConfirmOpenTableBtEvent implements ActionListener {

    private final JList list = OpenTableJList.getInstance();
    private final DefaultListModel listModel = ListOfTables.getInstance();
    private final LoadListFromTable loadList = new LoadListFromTable();
    private final WriteList write = new WriteList();

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "NO item selected!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String s = (String) listModel.get(index);
            //nastavení jména vybrané tabulky
            DBStatement.setTableName(s);
            OpenTableJList.getFrame().dispose();
            System.gc();
            loadList.loadList();
            write.vypis();
            ModifiedFileVariable.setFile(false);
            ModifiedFileVariable.setDb(true);
            ModifiedFileVariable.FileWasSaved();
        }
    }
}
