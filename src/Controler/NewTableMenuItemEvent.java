package Controler;

import Model.Database.DBStatement;
import Model.Database.LoadListFromTable;
import Model.WriteList;
import View.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží jako reakce na událost při stisknutí tlačítka "New Table" v
 * menu "Database". Reakcí bude vytvoření nové tabulky v databázi k níž jsem
 * připojen
 *
 * @author Suchý Vojtěch
 */
public class NewTableMenuItemEvent implements ActionListener {

    private Statement statement;
    private String s;
    private final WriteList vypis = new WriteList();
    private final LoadListFromTable nacti = new LoadListFromTable();

    @Override
    public void actionPerformed(ActionEvent ae) {

        s = JOptionPane.showInputDialog(Frame.getInstance(), "Enter the name of the Table", "Create new Table", JOptionPane.PLAIN_MESSAGE);
        if (s == null) {
        } else if (!(s.equals(""))) {
                createTable();
        } else {
            JOptionPane.showMessageDialog(Frame.getInstance(), "You must enter the name!", "Error while creating Table!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metoda jež vytvoří novou tabulku
     */
    private void createTable() {
        try {
            DBStatement.setTableName(s);
            statement = DBStatement.getInstance();
            String createString = "create table " + s.toUpperCase() + "( Autor varchar(40), Name varchar(40), Date varchar(10) )";
            statement.execute(createString);
            JOptionPane.showMessageDialog(Frame.getInstance(), "Table " + s + " was created", "Creating Table was successful!", JOptionPane.INFORMATION_MESSAGE);

            //naplnění seznamu a jeho vypsání na obrazovku
            nacti.loadList();
            vypis.vypis();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while creating Table!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
}
