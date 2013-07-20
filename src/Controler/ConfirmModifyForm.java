package Controler;

import Model.Kniha;
import Model.ModifiedFileVariable;
import Model.ModifyButtonEdit;
import Model.SeznamKnih;
import Model.WriteList;
import View.Frame;
import View.MainJList;
import View.ModifyForm;
import View.UndoMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEditSupport;

/**
 * Třída obsluhuje událost vyvolanou tlačítkem "OK" z formuláře pro změnu údajů
 * v knize
 *
 * @see View.ModifyForm
 * @author Suchý Vojtěch
 */
public class ConfirmModifyForm implements ActionListener {

    private final WriteList vypis = new WriteList();
    private Kniha kniha;
    private ModifyButtonEdit edit;
    private final static UndoableEditSupport editSupport = new UndoableEditSupport();
    private int index;
    private ArrayList<Kniha> seznam;
    private String autor;
    private String name;
    private String date;

    public static void pridejListener(UndoableEditListener uel) {
        editSupport.addUndoableEditListener(uel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //získání odkazů na instance pro další použití
        seznam = SeznamKnih.getInstanceCopy();
        kniha = seznam.get(MainJList.getInstance().getSelectedIndex());//pro použití u Edit
        autor = kniha.getAutor();
        name = kniha.getNazev();
        date = kniha.getVydano();

        //změna údajů knihy
        index = MainJList.getInstance().getSelectedIndex();
        seznam.get(index).setAutor(ModifyForm.tfAutor.getText());
        seznam.get(index).setNazev(ModifyForm.tfName.getText());
        //ověření vstupu pro datum 
        if ((ModifyForm.tfDate.getText().toString().matches("^\\d{0,4}?$"))) {
            seznam.get(index).setVydano((ModifyForm.tfDate.getText()));
        } else {
            JOptionPane.showMessageDialog(Frame.getInstance(), "Date must be 0-4 digit number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //aktualizace výstupu na obrazovce
        vypis.vypis();
        ModifyForm.dialog.dispose();
        ModifiedFileVariable.FileWasModified();

        /*vytvoření nové UndoableEdit
         * v kniha je uložena instance na již modifikovanou knihu (ta kniha
         * totiž odkazuje pouze na místo v paměti --> když se to místo změní, tak v knize už je 
         * automaticky něco jiného
         */
        edit = new ModifyButtonEdit(kniha, name, autor, date);
        //zavolání listenerů
        editSupport.postEdit(edit);
        //změna "Undo" tlačítka v menu "Edit"
        UndoMenuItem.getInstace().setEnabled(true);
    }
}
