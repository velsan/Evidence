package Controler;

import Model.DocumentSearchField;
import View.ButtonGroupSeradit;
import View.ButtonPanel;
import View.ExitMenuItem;
import View.Frame;
import View.MainJList;
import View.MenuBar;
import View.MenuDatabase;
import View.MenuEdit;
import View.MenuFile;
import View.NewFileMenuItem;
import View.NewTableMenuItem;
import View.OpenMenuItem;
import View.OpenTableMenuItem;
import View.RedoMenuItem;
import View.SaveDBMenuItem;
import View.SaveFileMenuItem;
import View.SortPanel;
import View.UndoMenuItem;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.text.Document;

/**
 * Třída slouží pro sestavení GUI a nastavení listenerů příslušným instancím
 *
 * @author Suchý Vojtěch
 */
public class ProcessFrame {

    private JFrame frame = Frame.getInstance();
    private JPanel panelRadio = SortPanel.getInstance(); //instance panelu s Radio Buttons
    private JPanel panelButton = ButtonPanel.getInstance();//instance panelu s Buttony "Add", "Delete" a "Modify"
    private ButtonGroup BtGroup = ButtonGroupSeradit.getInstance();
    //private DefaultListModel BookList = ListOfBooks.getInstance(); //je jedno kde vytvořím instanci
    //private DefaultListModel TableList = ListOfTables.getInstance(); //je jedno kde vytvořím instanci
    private JList list = MainJList.getInstance();
    private JMenuBar bar = MenuBar.getInstance();
    private JMenu menuFile = MenuFile.getInstance();
    private JMenu menuEdit = MenuEdit.getInstance();
    private JMenu menuDatabase = MenuDatabase.getInstance();
    private DeleteBtEvent deleteEvent = new DeleteBtEvent();

    public ProcessFrame() {

        //zpáruje klávasu "Delete" s akcí "doDelete"
        list.getInputMap().put(KeyStroke.getKeyStroke("DELETE"), "doDelete");
        //zpáruje akci "doDelete" s událostí ze třídy DeleteBtEvent (jež dědí od třídy AbstratAction)
        list.getActionMap().put("doDelete", deleteEvent);

        frame.add(panelRadio, BorderLayout.NORTH);
        frame.add(panelButton, BorderLayout.SOUTH);
        JScrollPane scrollList = MainJList.getInstanceScrollPane();
        frame.add(scrollList, BorderLayout.CENTER);

        //Přidání UndoableEditListener
        DeleteBtEvent.prijedEditListener(new UndoDeleteEditListener());
        ConfirmAddForm.pridejListener(new UndoAddEditListener());
        ConfirmModifyForm.pridejListener(new UndoModifyEventListener());

        //Přidání listeneru k JTextField - použito při fulltextovém vyhledávání
        Document doc = DocumentSearchField.getInstance();
        doc.addDocumentListener(new SearchFieldEvent());

        menuFile.add(NewFileMenuItem.getInstance());
        menuFile.add(OpenMenuItem.getInstance());
        menuFile.add(SaveFileMenuItem.getInstance());
        menuFile.add(ExitMenuItem.getInstance());

        menuEdit.add(UndoMenuItem.getInstace());
        menuEdit.add(RedoMenuItem.getInstace());

        menuDatabase.add(NewTableMenuItem.getInstance());
        menuDatabase.add(OpenTableMenuItem.getInstance());
        menuDatabase.add(SaveDBMenuItem.getInstance());

        bar.add(menuFile);
        bar.add(menuDatabase);
        bar.add(menuEdit);
        frame.setJMenuBar(bar);

        frame.addWindowListener(new ExitEvent());

        System.gc();
    }
}
