package Controler;

import Model.MyUndoManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Tato třda slouží jako posluchač události když nastane UndoableEdit. Je
 * zarigistrována jako posluchač u instance třídy UndoableEditSupport
 *
 * @see Controler.ConfirmModifyForm
 * @author Suchý Vojtěch
 */
public class UndoModifyEventListener implements UndoableEditListener {

    UndoManager manager;

    /**
     * Reakcí na událost je zavolání UndoableManager a přidání příslušného editu
     * do jeho fronty
     *
     * @param uee
     */
    @Override
    public void undoableEditHappened(UndoableEditEvent uee) {
        manager = MyUndoManager.getInstance();
        manager.addEdit(uee.getEdit());
    }
}
