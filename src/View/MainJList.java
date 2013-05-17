package View;

import Model.File.ListOfBooks;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Tato třída reprezentuje JList, který je použit při vypisování SeznamuKnih na
 * obrazovku
 *
 * @author Suchý Vojtěch
 */
public class MainJList {

    private static JList list = null;
    private static JScrollPane scrollPane = null;

    private MainJList() {
    }

    /**
     * Pro přidání do hlavního Frame je nutné přidat JScrollPane
     *
     * @return
     */
    public static JScrollPane getInstanceScrollPane() {
        if (list == null) {
            list = new JList(ListOfBooks.getInstance());
            list.setBackground(Color.decode("#E0EEE0"));
            scrollPane = new JScrollPane(list);
            return scrollPane;
        } else {
            return scrollPane;
        }
    }
 /**
  * Pro práci při zobrazvání, mázání ....položek je použit JList
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
