package Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

/**
 *
 * @author velsan
 */
public class MyDokument implements DocumentListener, UndoableEdit {

    JTextField field = MyField.getField();
    Document doc = field.getDocument();

    MyDokument() {
        
        doc.addDocumentListener(this);
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        try {
            Document pridano = de.getDocument();
            String s = pridano.getText(0, pridano.getLength());
            
            System.out.println("Přidáno: " +s);
        }  catch (BadLocationException ex) {
            Logger.getLogger(MyDokument.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        System.out.println("Smazáno");
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void undo() throws CannotUndoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean canUndo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void redo() throws CannotRedoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean canRedo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addEdit(UndoableEdit ue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean replaceEdit(UndoableEdit ue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSignificant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getPresentationName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUndoPresentationName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRedoPresentationName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
