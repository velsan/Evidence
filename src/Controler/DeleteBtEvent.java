package Controler;

import Model.DeleteButtonEdit;
import Model.Kniha;
import Model.ModifiedFileVariable;
import Model.SeznamKnih;
import Model.WriteList;
import View.Frame;
import View.MainJList;
import View.UndoMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEditSupport;

/**
 * Třída obsluhuje událost vyvolanou tlačítkem "Delete"
 *
 * @see View.DeleteButton
 * @author Suchý Vojtěch
 */
public class DeleteBtEvent extends AbstractAction implements ActionListener {

    private final JList jlist = MainJList.getInstance();
    private final JFrame frame = Frame.getInstance();
    private final WriteList vypis = new WriteList();
    private ArrayList<Kniha> seznam;
    private DeleteButtonEdit edit;
    private final static UndoableEditSupport undoSupport = new UndoableEditSupport();

    public static void prijedEditListener(UndoableEditListener e) {
        undoSupport.addUndoableEditListener(e);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = jlist.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(frame, "NO item selected!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            seznam = SeznamKnih.getInstanceCopy();
            //vytvoření nové UndoableEdit
            edit = new DeleteButtonEdit(seznam.get(index), index);
            //zavolání listenerů
            undoSupport.postEdit(edit);
            //změna stavu "Undo" tlačítka v menu "Edit"
            UndoMenuItem.getInstace().setEnabled(true);

            //vymazání vybrané knihy ze seznamu
            seznam.remove(index);
            vypis.vypis();
            ModifiedFileVariable.FileWasModified();
        }
    }
}
