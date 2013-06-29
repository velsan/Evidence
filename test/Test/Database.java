package Test;

import Model.Database.LoadDBTables;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author velsan
 */
public class Database {

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSetTableName;
    private static ResultSet resultSetColumnName;
    private static ResultSet resultSet;
    private static DatabaseMetaData dbmd;
    private static final String[] types = {"TABLE"};
    private static ResultSetMetaData resultSetMeta;

    public static void main(String[] args) {
        connectToDB();
        loadTables();
    }

    private static void connectToDB() {
        try {
            //naloadování ovladače - tím že vytvořím jeho instanci, resp. tím že jej zavolám
            Class.forName("com.mysql.jdbc.Driver");
            // vytvoření spojení s DB
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/evidence", "velsan", "velsan");
            //proměnná pro dotazování DB
            statement = (Statement) connect.createStatement();
            //konkrétní dotaz na DB
            resultSet = statement.executeQuery("select * from EVIDENCE.CESKA_LITERATURA");
            resultSetMeta = resultSet.getMetaData();
            /*while (resultSet.next()) {
             String s = resultSet.getString("Autor");
             }*/
        } catch (SQLException ex) {
            System.out.println("Chyba při připojování k DB");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Nenalezen ovladač");
        }
    }

    public static void loadTables() {
        try {
            dbmd = connect.getMetaData();
            //resultSet = dbmd.getTables(null, null, null, types);
            resultSetTableName = dbmd.getTables(null, null, null, types);

            while (resultSetTableName.next()) {
                String tableName = resultSetTableName.getString(3);
                System.out.println("Is loadable for: " + tableName);
                isLoadableTable(tableName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDBTables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void isLoadableTable(String tableName) {
        try {

            System.out.println(resultSetMeta.getColumnName(1));
            System.out.println(resultSetMeta.getColumnName(2));
            System.out.println(resultSetMeta.getColumnName(3));
        } catch (SQLException ex) {
            System.out.println("Chyba v isLoadableTable");
        }


    }
}
