package Model;

import View.RedoMenuItem;
import View.UndoMenuItem;
import java.util.ArrayList;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Tato třída reprezentuje funkci v programu Evidence 2.0, jež je
 * Undoable/Redoable
 *
 * @see Controler.DeleteBtEvent
 * @author Suchý Vojtěch
 */
public class DeleteButtonEdit implements UndoableEdit {

    private ArrayList<Kniha> seznam;
    private final WriteList vypis = new WriteList();
    private Kniha kniha;
    private int index;
    private UndoManager manager;

    /**
     * Do konstruktoru se předají parametry, aby mohly být provedeny metody
     * undo() a redo()
     *
     * @param kniha Vymazaná kniha
     * @param index Místo v seznamu, kde byla kniha vymazána
     */
    public DeleteButtonEdit(Kniha kniha, int index) {
        this.kniha = kniha;
        this.index = index;
    }

    /**
     * Tato metoda se zavolá, když uživatel zmáčkně v menu tlačítko "Undo" a v
     * UndoableManager je ve frontě tento Edit (tj. instance této třídy)
     */
    @Override
    public void undo() {
        seznam = SeznamKnih.getInstanceCopy();
        seznam.add(index, kniha);
        vypis.vypis();
        RedoMenuItem.getInstace().setEnabled(true);
        manager = MyUndoManager.getInstance();
        if (!(manager.canUndo())) {
            UndoMenuItem.getInstace().setEnabled(false);
        }
    }

    /**
     * Tato metoda se zavolá, když uživatel zmáčkně v menu tlačítko "Redo" a v
     * UndoableManager je ve frontě tento Edit (tj. instance této třídy)
     */
    @Override
    public void redo() throws CannotRedoException {
        seznam = SeznamKnih.getInstanceCopy();
        seznam.remove(kniha);
        vypis.vypis();
        manager = MyUndoManager.getInstance();
        if (!(manager.canRedo())) {
            RedoMenuItem.getInstace().setEnabled(false);
        }
    }

    @Override
    public boolean canRedo() {
        return true;
    }

    @Override
    public void die() {
    }

    /**
     * If addEdit returns true the new edit is assumed to have been incorporated
     * into the current edit and the new edit will not be added to the list of
     * current edits
     *
     * @param ue
     * @return
     */
    @Override
    public boolean addEdit(UndoableEdit ue) {
        return false;
    }

    @Override
    public boolean replaceEdit(UndoableEdit ue) {
        return false;
    }

    @Override
    public boolean isSignificant() {
        return true;
    }

    @Override
    public String getPresentationName() {
        String s = "";
        return s;
    }

    @Override
    public String getUndoPresentationName() {
        String s = "Undo: Položka byla odebrána ze seznamu";
        return s;
    }

    @Override
    public String getRedoPresentationName() {
        String s = "Redo: Položka byla odebrána ze seznamu";
        return s;
    }

    @Override
    public boolean canUndo() {
        return true;
    }
}
