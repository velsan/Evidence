package Model.Database;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Tato třída slouží pro načtení knih z databáze do SeznamuKnih
 *
 * @see Model.SeznamKnih
 * @author Suchý Vojtech
 */
public class LoadListFromTable {

    private Statement statement;
    private ResultSet resultSet;
    private String DBTableName;
    private ArrayList<Kniha> seznam;
    private ResultSetMetaData resultSetMeta;

    public void loadList() {
        try {
            seznam = SeznamKnih.getInstance();
            //vyčištění seznamu před tím, než načtu nové položky
            seznam.clear();
            statement = DBStatement.getInstance();
            DBTableName = DBStatement.getDBTableName();
            resultSet = statement.executeQuery("select * from " + DBTableName);
            resultSetMeta = resultSet.getMetaData();
            //kontrola, zda jde tabulka zpracovat
            if (isLoadable()) {
            while (resultSet.next()) {
                Kniha kniha = new Kniha();
                kniha.setAutor(resultSet.getString("Autor"));
                kniha.setNazev(resultSet.getString("Name"));
                kniha.setVydano(resultSet.getString("Date"));
                seznam.add(kniha);
            }
            SeznamKnih.changeCopy();} else {
                JOptionPane.showMessageDialog(Frame.getInstance(), "Can NOT process this table!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Error while querying Database!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isLoadable() throws SQLException {
        int numberOfColumns = resultSetMeta.getColumnCount();
        if (numberOfColumns != 3) {
            return false;
        } else if (resultSetMeta.getColumnName(1).equalsIgnoreCase("autor")
                && resultSetMeta.getColumnName(2).equalsIgnoreCase("name")
                && resultSetMeta.getColumnName(3).equalsIgnoreCase("date")) {
            return true;
        }
        return false;
    }
}
