package Model.Database;

import View.DBConnectionForm;
import View.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Tato třídaje singleton a slouží pro vytvoření spojení s databázovýmm
 * serverem. V program tedy může být připojen pouze k jedné databázi současně.
 * Když se takto porpvé k databázi připojuji, zadám údaje potřebné k připjení za
 * využití třídy DBConnectionForm
 *
 * @see View.DBConnectionForm
 * @author Suchý Vojtěch
 */
public class ConnectToDBServer {

    private static Connection connection = null;
    private static final JFrame frame = Frame.getInstance();
    private static DBConnectionForm form = DBConnectionForm.getInstance();
    private static JDialog formular;

    /**
     *
     * @return Objekt třída Connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            formular = form.getDialog();
            formular.setVisible(true);
            connect(form.getAddress(), form.getUser(), form.getPassword());
            return connection;
        } else {
            return connection;
        }
    }

    /**
     * Metoda pro ověření existence spojení s databází
     *
     * @return False pokud připojení k databázi neexistuje. True pokud existuje
     */
    public static boolean isConnected() {
        if (connection == null) {
            return false;
        } else {
            try {
                return connection.isValid(0);
            } catch (SQLException ex) {
                System.out.println("Chyba při volání connection.isValid(0) ve tříde ConnectToDBServer");
            } finally {
                return false;
            }
        }
    }

    /**
     * Tato metoda slouží k připojení k databázi
     *
     * @param url String s adresou databáze
     * @param user String obsahující username
     * @param password String obsahující password
     */
    private static void connect(String url, String user, String password) {
        try {
            //naloadování ovladače - tím že vytvořím jeho instanci, resp. tím že jej zavolám
            Class.forName("com.mysql.jdbc.Driver");
            // vytvoření spojení s DB; 
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Can NOT connect to Database Server!", "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, "Database Driver was NOT found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
