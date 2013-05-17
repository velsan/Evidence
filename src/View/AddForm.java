package View;

import Controler.ConfirmAddForm;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * Tato třída slouží pro vytvoření formuláře, pomocí kterého se vyplní data při
 * vložení nové knihy
 *
 * @author Suchý Vojtěch
 */
public class AddForm {

    private AddForm() {
    }
    private static AddForm form = null;
    private static JFrame frame = Frame.getInstance();
    private static JButton OKbt = new JButton("OK");
    private final static JTextField tfAutor = new JTextField(15);
    private final static JTextField tfName = new JTextField(15);
    private final static JTextField tfDate = new JTextField(15);
    private final static JLabel lbAutor = new JLabel("Autor:");
    private final static JLabel lbName = new JLabel("Name:");
    private final static JLabel lbDate = new JLabel("Date:");
    private static JDialog dialog;

    public static AddForm getInstance() {
        if (form == null) {
            form = new AddForm();
            nastaveni();
            return form;
        } else {
            return form;
        }
    }

    private static void nastaveni() {
        dialog = new JDialog(frame, "Enter the data", true);
        OKbt.addActionListener(new ConfirmAddForm());
        dialog.add(lbName);
        dialog.add(tfName);
        dialog.add(lbAutor);
        dialog.add(tfAutor);
        dialog.add(lbDate);
        dialog.add(tfDate);
        dialog.add(new JSeparator());
        dialog.add(OKbt);

        dialog.setLayout(new FlowLayout());
        dialog.setSize(200, 250);
        dialog.setLocation(frame.getLocation());
    }

    public JDialog getDialog() {
        return dialog;
    }

    public JTextField getAutorField() {
        return tfAutor;
    }

    public JTextField getNameField() {
        return tfName;
    }

    public JTextField getDateField() {
        return tfDate;
    }

    /**
     * Metoda pro získání Stringu z textového pole tfautor
     *
     * @return String obsahující autora knihy
     */
    public String getAutor() {
        return tfAutor.getText();

    }

    /**
     * Metoda pro získání Stringu z textového pole tfnazev
     *
     * @return String obsahují název
     */
    public String getName() {
        return tfName.getText();
    }

    /**
     * Metoda pro získání Stringu z textového pole tfdatum
     *
     * @return String obsahující datum
     */
    public String getDate() {
        return tfDate.getText();
    }
}
