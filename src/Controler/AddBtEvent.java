package Controler;

import View.AddForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 * Třída obsluhuje událost vyvolanou tlačítkem Add
 *
 * @see View.AddButton
 * @author Suchý Vojtěch
 */
public class AddBtEvent implements ActionListener {

    private AddForm formular;
    private JDialog dialog;

    @Override
    public void actionPerformed(ActionEvent ae) {
        formular = AddForm.getInstance();
        dialog = formular.getDialog();
        dialog.setVisible(true);
    }
}
