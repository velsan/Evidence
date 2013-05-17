package Model.Database;

import View.Frame;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží pro načtení jmen tabulek z databáze do listModeu
 * ListOfTables
 *
 * @author Suchý Vojtěch
 */
public class LoadDBTables {

    private Connection connection;
    private final DefaultListModel listModel = ListOfTables.getInstance();
    private final JFrame frame = Frame.getInstance();
    private final String[] types = {"TABLE"};
    private DatabaseMetaData dbmd;
    private ResultSet resultSetTableName;

    /**
     *
     */
    public void loadTables() throws NullPointerException {
        try {
            connection = ConnectToDBServer.getConnection();
            //vyčištení listModelu
            listModel.clear();
            dbmd = connection.getMetaData();
            //metadata o DB - konkrétně názvy tabulek
            resultSetTableName = dbmd.getTables(null, null, null, types);
            while (resultSetTableName.next()) {
                String tableName = resultSetTableName.getString(3);
                listModel.addElement(tableName);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Error while accessing Database", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
}
