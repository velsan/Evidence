package Model.Database;

import com.mysql.jdbc.Statement;
import java.sql.SQLException;

/**
 * Tato třída reprezentuje instanci třídy Statement, pomocí které posílám
 * příkazy do MySQL databáze
 *
 * @see com.mysql.jdbc.Statement
 * @author Suchý Vojtěch
 */
public class DBStatement {

    private static Statement statement = null;
    private static String tableName = null;

    private DBStatement() {
    }

    public static Statement getInstance() throws NullPointerException {
        if (statement == null) {
            try {
                statement = (Statement) ConnectToDBServer.getConnection().createStatement();
                return statement;
            } catch (SQLException ex) {
                System.out.println("Error while queriing DB");
                return null;
            }
        } else {
            return statement;
        }
    }

    /**
     *
     * @return String s názvem aktuálně používané tabulky
     */
    public static String getTableName() {
        return tableName;
    }

    /**
     *
     * @return String s názvem aktuálně používané tabulky ve formě
     * DATABASE.TABLE
     */
    public static String getDBTableName() {
        String s = "EVIDENCE." + tableName.toUpperCase();
        return s;
    }

    public static void setTableName(String tableName) {
        DBStatement.tableName = tableName;
    }
}
