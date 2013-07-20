package Model.File;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Tato třída slouží jako reakce na událost tlačítka "Save" v menu "File". 
 *
 * @author Suchý Vojtěch
 */
public class SaveFile {

    private File file;
    private ArrayList<Kniha> seznam;
    private DocumentBuilderFactory factory;
    private Document doc;
    private DocumentBuilder docBuidler;
    private TransformerFactory ts;
    private Transformer transformer;
    private Kniha kniha;

    public void saveFile() {

        try {
            seznam = SeznamKnih.getInstanceCopy();
            factory = DocumentBuilderFactory.newInstance();
            docBuidler = factory.newDocumentBuilder();
            doc = docBuidler.newDocument();
            //vytvoření kořenového elementu
            Element root = doc.createElement("root");
            doc.appendChild(root);

            for (Iterator<Kniha> it = seznam.iterator(); it.hasNext();) {
                kniha = it.next();
                Element book = doc.createElement("book");
                Element name = doc.createElement("name");
                Element autor = doc.createElement("autor");
                Element date = doc.createElement("date");
                name.appendChild(doc.createTextNode(kniha.getNazev()));
                autor.appendChild(doc.createTextNode(kniha.getAutor()));
                date.appendChild(doc.createTextNode(kniha.getVydano()));
                book.appendChild(name);
                book.appendChild(autor);
                book.appendChild(date);
                root.appendChild(book);
            }
            //zapsání do souboru
            write();

        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), " File "+file.getName()+" was NOT saved", "Error while saving file!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Write content to XML file
     */
    private void write() {
        try {
            ts = TransformerFactory.newInstance();
            transformer = ts.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            file = Soubor.getInstance();
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(Frame.getInstance(), " File "+file.getName()+" was NOT saved", "Error while saving file!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
