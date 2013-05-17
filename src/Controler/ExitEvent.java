package Controler;

import Model.Database.ConnectToDBServer;
import Model.Database.DBStatement;
import Model.Database.SaveTable;
import Model.File.SaveFile;
import Model.File.Soubor;
import Model.ModifiedFileVariable;
import View.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Třída slouží jako reakce na událost tlačítka "Exit" v menu "File" či zavření
 * aplikace "křížkem"
 *
 * @see View.ExitMenuItem
 * @author Suchý Vojtěch
 */
public class ExitEvent implements WindowListener, ActionListener {

    @Override
    public void windowClosing(WindowEvent we) {
        if (ModifiedFileVariable.getInstance() == 1 && ModifiedFileVariable.isFile()) {
            int n = JOptionPane.showConfirmDialog(Frame.getInstance(), "Would you like to save file before exiting Evidence 2.0?", "File was moified!", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                SaveFile save = new SaveFile();
                save.saveFile();
                JOptionPane.showMessageDialog(Frame.getInstance(), "File " + Soubor.getInstance().getName() + " was saved", "Saving was successful!", JOptionPane.INFORMATION_MESSAGE);
                Frame.getInstance().dispose();
            }
        } else if (ModifiedFileVariable.getInstance() == 1 && ModifiedFileVariable.isDb()) {
            int c = JOptionPane.showConfirmDialog(Frame.getInstance(), "Would you like to save Table in Database before exiting Evidence 2.0?", "Table was moified!", JOptionPane.YES_NO_OPTION);
            if (c == 0) {
                SaveTable save = new SaveTable();
                save.save();
                JOptionPane.showMessageDialog(Frame.getInstance(), "Table " + DBStatement.getTableName() + " was saved", "Saving was successful!", JOptionPane.INFORMATION_MESSAGE);
                Frame.getInstance().dispose();
            }
        }
        try {
            if (ConnectToDBServer.isConnected()) {
                ConnectToDBServer.getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println("Chyba při uzavírání komunikace s DB");
        } finally {
            System.gc();
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ModifiedFileVariable.getInstance() == 1 && ModifiedFileVariable.isFile()) {
            int n = JOptionPane.showConfirmDialog(Frame.getInstance(), "Would you like to save file before exiting Evidence 2.0?", "File was moified!", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                SaveFile save = new SaveFile();
                save.saveFile();
                JOptionPane.showMessageDialog(Frame.getInstance(), "File " + Soubor.getInstance().getName() + " was saved", "Saving was successful!", JOptionPane.INFORMATION_MESSAGE);
                Frame.getInstance().dispose();
            }
        } else if (ModifiedFileVariable.getInstance() == 1 && ModifiedFileVariable.isDb()) {
            int c = JOptionPane.showConfirmDialog(Frame.getInstance(), "Would you like to save Table in Database before exiting Evidence 2.0?", "Table was moified!", JOptionPane.YES_NO_OPTION);
            if (c == 0) {
                SaveTable save = new SaveTable();
                save.save();
                JOptionPane.showMessageDialog(Frame.getInstance(), "Table " + DBStatement.getTableName() + " was saved", "Saving was successful!", JOptionPane.INFORMATION_MESSAGE);
                Frame.getInstance().dispose();
            }
        }
        try {
            if (ConnectToDBServer.isConnected()) {
                ConnectToDBServer.getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println("Chyba při uzavírání komunikace s DB");
        } finally {
            System.gc();
            System.exit(1);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
