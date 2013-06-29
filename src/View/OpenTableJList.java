package View;

import Controler.ConfirmOpenTableBtEvent;
import Model.Database.ListOfTables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Tato třída slouží pro reprezentaci JListu, jež bude sloužit obdobně jako
 * JFileChooser akorát pro tabulky v databázi
 *
 * @author Suchý Vojtěch
 */
public class OpenTableJList {

    private static JList list = null;
    private static JScrollPane scrollPane = null;
    private static JFrame frame;
    private static JButton bt;
    private static Image picture;
    private static Toolkit tool;

    private OpenTableJList() {
    }

    public static void createWindow() {
        inicializeButton();
        inicializeFrame();
        frame.add(getInstanceScrollPane(), BorderLayout.CENTER);
        frame.add(bt, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void inicializeButton() {
        if (bt == null) {
            bt = new JButton("Open Table");
            bt.addActionListener(new ConfirmOpenTableBtEvent());
        }
    }

    private static void setIcon() {
        tool = Toolkit.getDefaultToolkit();
        picture = tool.getImage("book.png");
        frame.setIconImage(picture);
    }

    private static void inicializeFrame() {
        if (frame == null) {
            frame = new JFrame();
            setIcon();
            frame.setLayout(new BorderLayout());
            frame.setSize(350,200);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocation(500, 150);
            frame.setBackground(Color.decode("#CDCD00"));
        }
    }
    
    public static JFrame getFrame () {
        return frame;
    }

    /**
     * Pro přidání do hlavního Frame je nutné přidat JScrollPane
     *
     * @return
     */
    public static JScrollPane getInstanceScrollPane() {
        if (list == null) {
            list = new JList(ListOfTables.getInstance());
            list.setBackground(Color.decode("#E0EEE0"));
            scrollPane = new JScrollPane(list);
            return scrollPane;
        } else {
            return scrollPane;
        }
    }

    /**
     * Pro práci při zobrazvání, mázání ....položek je použit JList
     *
     * @return
     */
    public static JList getInstance() {
        if (list == null) {
            getInstanceScrollPane();
            return list;
        } else {
            return list;
        }
    }
}
