package Model.File;

import View.Frame;
import javax.swing.JOptionPane;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Suchý Votjěch
 */
public class SAXErrorHandler  implements ErrorHandler
{

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        JOptionPane.showMessageDialog(Frame.getInstance(), exception.getMessage(), "Warning!", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        JOptionPane.showMessageDialog(Frame.getInstance(), exception.getMessage(), "Error while parsing XML file!", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        JOptionPane.showMessageDialog(Frame.getInstance(), exception.getMessage(), "Fatal error while parsing XML file!", JOptionPane.ERROR_MESSAGE);
    }
    
}
