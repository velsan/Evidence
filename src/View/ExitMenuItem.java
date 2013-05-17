
package View;

import Controler.ExitEvent;
import java.awt.Cursor;
import javax.swing.JMenuItem;

/**
 * Tato třída reprezentuje tlačítko "Exit" v menu "File"
 * 
 * @author Suchý Vojtěch
 */
public class ExitMenuItem {
    
    private ExitMenuItem () {}
    
    private static JMenuItem exitItem = null;
    
    public static JMenuItem getInstance () {
        if (exitItem == null) {
            exitItem = new JMenuItem("Exit");
            exitItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
            exitItem.addActionListener(new ExitEvent());
            return exitItem;
        } else {
            return exitItem;
        }
    }
}
