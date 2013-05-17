package Controler;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import View.MainJList;
import View.ModifyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Třída slouží jako reakce na událost tlačítka "Modify"
 *
 * @author Suchý Vojtěch
 */
public class ModifyBtEvent implements ActionListener {

    private final JList list = MainJList.getInstance();
    private ArrayList<Kniha> seznam;

    @Override
    public void actionPerformed(ActionEvent ae) {

        int index = list.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(Frame.getInstance(), "NO item selected!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            seznam = SeznamKnih.getInstanceCopy();
            Kniha kniha = seznam.get(index);

            //nastavení JTextField u formuláře
            View.ModifyForm.tfAutor.setText(kniha.getAutor());
            View.ModifyForm.tfName.setText(kniha.getNazev());
            View.ModifyForm.tfDate.setText(kniha.getVydano());

            //zobrazení formuláře
            ModifyForm form = ModifyForm.getInstance();
            form.dialog.setVisible(true);
        }
    }
}
