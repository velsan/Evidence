package View;

import javax.swing.JFileChooser;

/**
 * Tato třída reprezentuje instanci JFileChooser. K vyvolání instance této třídy
 * dojde při kliknutí na talčítko "Open" v menu "File"
 *
 * @author Suchý Vojtěch
 */
public class OpenFileChooser {
    
    private OpenFileChooser() {}

    private static JFileChooser chooser = null;

    public static JFileChooser getInstance() {
        if (chooser == null) {
            //výchizí složka pro vyhledávání
            chooser = new JFileChooser("C:\\Users\\velsan\\Documents\\NetBeansProjects\\Evidence 2.0");
            nastav();
            return chooser;
        } else {
            return chooser;
        }
    }
    
    private static void nastav() {
        chooser.setFileFilter(new Model.File.MyFileFilter());
        chooser.setDialogTitle("Choose a file");
    }
}
