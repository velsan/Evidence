package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Tato třída slouží jako formulář pro získání údajů o připojení k databázi.
 * K vyvolání tohoto formuláře dojde při volání metody getConnection() ve třídě ConnectToDBServer
 * 
 * @see Model.Database.ConnectToDBServer
 * @author Suchý Vojtěch
 */
public class DBConnectionForm {

    private static DBConnectionForm form;
    private static String password;
    private static String user;
    private static String address;
    private static JFrame frame = Frame.getInstance();
    private static JDialog dialog;
    private static JPasswordField passwordField;
    private static JTextField urlField;
    private static JTextField userField;
    private static JLabel userLabel;
    private static JLabel urlLabel;
    private static JLabel passwordLabel;
    private static JButton okBt;
    
    private DBConnectionForm() {}

    public static DBConnectionForm getInstance() {
        if (form == null) {
            form = new DBConnectionForm();
            nastaveni();
            return form;
        } else {
            return form;
        }
    }

    private static void nastaveni() {
        dialog = new JDialog(frame, "Enter the data", true);
        urlLabel = new JLabel("Enter the address of the Database");
        urlField = new JTextField("jdbc:mysql://localhost/Evidence");
        userLabel = new JLabel("Enter the username", 10);
        userField = new JTextField("velsan");
        passwordLabel = new JLabel("Enter the password", 10);
        passwordField = new JPasswordField("velsan");
        okBt = new JButton ("OK");
        okBt.addActionListener(new OkBtEvent());
        
        dialog.setLayout(new FlowLayout());
        dialog.setSize(230, 200);
        dialog.setLocation(frame.getLocation());
        
        dialog.add(urlLabel);
        dialog.add(urlField);
        dialog.add(userLabel);
        dialog.add(userField);
        dialog.add(passwordLabel);
        dialog.add(passwordField);
        dialog.add(okBt);
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public String getAddress() {
        return address;
    }
    
    public JDialog getDialog () {
        return dialog;
    }

    static class OkBtEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            address = urlField.getText();
            user = userField.getText();
            password = passwordField.getText();
            dialog.dispose();
        }
    }
}
