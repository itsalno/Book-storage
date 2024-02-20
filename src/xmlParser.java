import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class xmlParser {
    public void ParseXML() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("src/books.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("book");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Make: " + eElement.getAttribute("make"));
                System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Writer: " + eElement.getElementsByTagName("writer").item(0).getTextContent());
                System.out.println("Pages: " + eElement.getElementsByTagName("pages").item(0).getTextContent());
            }
        }
    }
}
