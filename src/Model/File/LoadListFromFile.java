package Model.File;

import Model.Kniha;
import Model.SeznamKnih;
import View.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Třída LoadListFromFile načte data ze souboru na disku a uloží je jako obejkty
 * třídy Kniha do ArrayListu.
 *
 * @author Suchý Vojtěch
 */
public class LoadListFromFile {

    private File file;
    private ArrayList<Kniha> seznam;
    private Document doc;
    private Kniha kniha;

    public LoadListFromFile() {
    }

    /**
     * Tato metoda načte data ze souboru (to jest objektu třídy Soubor) a
     * uložení do seznamu knih (to jest objektu třídy SeznamKnih).
     *
     */
    public void naplnSeznam() {
        seznam = SeznamKnih.getInstance();
        seznam.clear();
        file = Soubor.getInstance();
        //pokud je soubor prázdný, není třeba parsovat
        if (file.length() != 0) {
            try {
                //Create a DocumentBuilderFacotry
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true);
                factory.setValidating(true);
                factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

                factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "schema.xsd");
                //Create a DocumentBuilder
                DocumentBuilder docBuilder = factory.newDocumentBuilder();
                docBuilder.setErrorHandler(new SAXErrorHandler());
                //Parse an XML document
                doc = docBuilder.parse((file));

                Element root = doc.getDocumentElement();
                if (root.hasChildNodes()) {
                    //zde jsou ulozeny nodes <book>
                    NodeList nodeList = root.getChildNodes();
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        //zde je uložena i-tá kniha
                        Node node = nodeList.item(i);
                        if (node.hasChildNodes()) {
                            kniha = new Kniha();
                            NodeList tmpNodeList = node.getChildNodes();
                            kniha.setNazev(tmpNodeList.item(1).getTextContent());
                            kniha.setAutor(tmpNodeList.item(3).getTextContent());
                            kniha.setVydano(tmpNodeList.item(5).getTextContent());
                            seznam.add(kniha);
                        }
                    }
                }
                SeznamKnih.changeCopy();
            } catch (SAXException ex) {
                Logger.getLogger(LoadListFromFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(LoadListFromFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Frame.getInstance(), "Program will be terminated!", "Error while reading file!", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        SeznamKnih.changeCopy();
    }
}
