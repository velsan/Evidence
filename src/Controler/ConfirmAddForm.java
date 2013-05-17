package Controler;

import Model.AddButtonEdit;
import Model.AddItem;
import Model.ModifiedFileVariable;
import Model.WriteList;
import View.AddForm;
import View.UndoMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEditSupport;

/**
 * Třída obsluhuje událost vyvolanou tlačítkem "OK" u formuláře pro přidání
 * knihy
 *
 * @see View.AddForm
 * @author Suchý Vojtěch
 */
public class ConfirmAddForm implements ActionListener {

    private final AddItem addItem = new AddItem();
    private final WriteList vypis = new WriteList();
    private final static UndoableEditSupport editSupport = new UndoableEditSupport();
    private AddButtonEdit edit;
    private JDialog dialog;
    private AddForm addForm;

    public static void pridejListener(UndoableEditListener ues) {
        editSupport.addUndoableEditListener(ues);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //přidání položky do seznamu
        addItem.pridejDoSeznamu();
        vypis.vypis();
        addForm = AddForm.getInstance();
        dialog = addForm.getDialog();
        dialog.dispose();
        addForm.getAutorField().setText("");
        addForm.getNameField().setText("");
        addForm.getDateField().setText("");
        ModifiedFileVariable.FileWasModified();
        //Vytvoření nové UndoableEdit
        edit = new AddButtonEdit(AddItem.getKniha());
        //Zavolání listenerů
        editSupport.postEdit(edit);
        //Změna "Undo" tlačítka v menu "Edit"
        UndoMenuItem.getInstace().setEnabled(true);
    }
}
