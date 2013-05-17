package Model;

import View.RedoMenuItem;
import View.UndoMenuItem;
import java.util.ArrayList;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Tato třída reprezentuje funkci v programu Evidence 2.0, jež je
 * Undoable/Redoable
 *
 * @see Controler.ConfirmAddForm
 * @author Suchý Vojtěch
 */
public class AddButtonEdit implements UndoableEdit {

    private Kniha kniha;
    private ArrayList<Kniha> seznam;
    private final WriteList vypis = new WriteList();
    private UndoManager manager;

    /**
     * Do konstruktoru je předána kniha, která byla do SeznamuKnih přidána ve
     * formuláři pro přidání
     *
     * @param kniha přidaná kniha
     */
    public AddButtonEdit(Kniha kniha) {
        this.kniha = kniha;
    }

    /**
     * Tato metoda se zavolá, když uživatel zmáčkně v menu tlačítko "Undo" a v
     * UndoableManager je ve frontě tento Edit (tj. instance této třídy)
     */
    @Override
    public void undo() {
        seznam = SeznamKnih.getInstanceCopy();
        seznam.remove(kniha);
        vypis.vypis();
        RedoMenuItem.getInstace().setEnabled(true);
        manager = MyUndoManager.getInstance();
        if (!(manager.canUndo())) {
            UndoMenuItem.getInstace().setEnabled(false);
        }
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    /**
     * Tato metoda se zavolá, když uživatel zmáčkně v menu tlačítko "Redo" a v
     * UndoableManager je ve frontě tento Edit (tj. instance této třídy)
     */
    @Override
    public void redo() {
        seznam = SeznamKnih.getInstanceCopy();
        seznam.add(kniha);
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
        String s = "Redo: Položka byla navrácena do seznamu";
        return s;
    }
}
