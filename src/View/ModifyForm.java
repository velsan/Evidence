package View;

import Controler.ConfirmModifyForm;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * Tato třída reprezentuje formulář pomocí kterého se vyplňují údaje při změně
 * údajů knihy
 *
 * @see Controler.ConfirmModifyForm
 * @author Suchý Vojtěch
 */
public class ModifyForm {

    private ModifyForm() {
    }
    private static ModifyForm form = null;
    private static JFrame frame = Frame.getInstance();
    private static JButton OKbt = new JButton("OK");
    public final static JTextField tfAutor = new JTextField(15);
    public final static JTextField tfName = new JTextField(15);
    public final static JTextField tfDate = new JTextField(15);
    private final static JLabel lbAutor = new JLabel("Autor:");
    private final static JLabel lbName = new JLabel("Name:");
    private final static JLabel lbDate = new JLabel("Date:");
    public static JDialog dialog = new JDialog(frame, "Enter the data", true);

    public static ModifyForm getInstance() {
        if (form == null) {
            form = new ModifyForm();
            nastaveni();
            return form;
        } else {
            return form;
        }
    }

    private static void nastaveni() {
        OKbt.addActionListener(new ConfirmModifyForm());
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

    /**
     * Metoda pro získání Stringu z textového pole tfautor
     *
     * @return String obsahují jména autora knihy
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
