package Model.Database;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží pro uložení SeznamuKnih do tabulky v databázi. Nejdříve je
 * tabulka vymazána a poté se začnou přidávat položky ze SenamuKnih.
 *
 * @author Suchý Vojtěch
 */
public class SaveTable {

    private Statement statement;
    private String tableName;
    private String clearTableSQL;
    private String addRecordSQL;
    private ArrayList<Kniha> seznam;

    public void save() {
        try {
            seznam = SeznamKnih.getInstanceCopy();
            statement = DBStatement.getInstance();
            tableName = DBStatement.getTableName();
            clearTableSQL = "TRUNCATE TABLE " + tableName;
            statement.execute(clearTableSQL);

            for (Iterator<Kniha> it = seznam.iterator(); it.hasNext();) {
                Kniha kniha = it.next();
                addRecordSQL = "INSERT INTO " + tableName + " (Autor, Name, Date) VALUES ('" + kniha.getAutor()
                        + "', '" + kniha.getNazev() + "', '" + kniha.getVydano() + "' )";
                statement.execute(addRecordSQL);
            }

        } catch (SQLException ex) {
            //pokud je připojení aktivní
            if (ConnectToDBServer.isConnected()) {
                JOptionPane.showMessageDialog(Frame.getInstance(), "Error while saving Table!", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            // pokud uživatel není připojen k databázi
            else {
                JOptionPane.showMessageDialog(Frame.getInstance(), "No Table is open!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException ex) {
            // TO DO
        }
    }
}
