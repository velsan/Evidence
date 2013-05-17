package Controler;

import Model.MyUndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.undo.UndoManager;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Redo" v menu "Edit"
 *
 * @author Suchý Vojtěch
 */
public class RedoMenuItemEvent implements ActionListener {

    private UndoManager manager;
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        manager = MyUndoManager.getInstance();
        if (manager.canRedo()) {
            manager.redo();
        } 
    }
}
