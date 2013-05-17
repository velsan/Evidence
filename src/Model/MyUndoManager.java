package Model;

import javax.swing.undo.UndoManager;

/**
 * Tato třída reprezentuje instanci třídy UndoManager, jež slouží pro
 * správu objketů typu UndoableEdit. UndoManager je volán jako reakce na událost
 * tlačítek Undo s Redu v menu "Edit"
 * 
 * @see javax.swing.undo.UndoManager
 * @author Suchý Vojtěch
 */
public class MyUndoManager {

    private static UndoManager manager = null;

    private MyUndoManager() {
    }

    public static UndoManager getInstance() {
        if (manager == null) {
            manager = new UndoManager(); //jiný konstruktor ani neexistuje
            return manager;
        } else {
            return manager;
        }
    }
}
