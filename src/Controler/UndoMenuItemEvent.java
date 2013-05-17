package Controler;

import Model.MyUndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.undo.UndoManager;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Undo" v menu "Edit"
 *
 * @see View.UndoMenuItem
 * @author Suchý Vojtěch
 */
public class UndoMenuItemEvent implements ActionListener {

    UndoManager manager;

    @Override
    public void actionPerformed(ActionEvent ae) {
        manager = MyUndoManager.getInstance();
        if (manager.canUndo()) {
            manager.undo();
        }
    }
}
