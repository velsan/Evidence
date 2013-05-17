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
 * @see Controler.ConfirmModifyForm
 * @author Suchý Vojtěch
 */
public class ModifyButtonEdit implements UndoableEdit {

    private Kniha kniha;
    private ArrayList<Kniha> seznam;
    private int index;
    private final WriteList vypis = new WriteList();
    private String autor;
    private String name;
    private String date;
    private String autorModified;
    private String nameModified;
    private String dateModified;
    private UndoManager manager;

    /**
     * Do konstruktoru josu předány parametry, jež obsahují informace potřebné
     * pro implementraci metod undo() a redo()
     *
     * @param kniha
     * @param name
     * @param autor
     * @param date
     */
    public ModifyButtonEdit(Kniha kniha, String name, String autor, String date) {
        this.kniha = kniha;
        autorModified = this.kniha.getAutor();
        nameModified = this.kniha.getNazev();
        dateModified = this.kniha.getVydano();
        this.autor = autor;
        this.date = date;
        this.name = name;
    }

    /**
     * Tato metoda se zavolá, když uživatel zmáčkně v menu tlačítko "Undo" a v
     * UndoableManager je ve frontě tento Edit (tj. instance této třídy)
     */
    @Override
    public void undo() {
        seznam = SeznamKnih.getInstanceCopy();
        index = seznam.indexOf(kniha);
        if (index == -1) {
            return;
        } else {
            seznam.get(index).setAutor(autor);
            seznam.get(index).setNazev(name);
            seznam.get(index).setVydano(date);
            vypis.vypis();
        }
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
        index = seznam.indexOf(kniha);
        if (index == -1) {
        } else {
            seznam.get(index).setAutor(autorModified);
            seznam.get(index).setNazev(nameModified);
            seznam.get(index).setVydano(dateModified);
            vypis.vypis();
        }
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
        String s = "Rdo: Položka byla odebrána ze seznamu";
        return s;
    }
}
