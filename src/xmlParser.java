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
import java.util.ArrayList;
import java.util.List;

public class xmlParser {
    public List<Book> parseXML() throws ParserConfigurationException, IOException, SAXException {
        List<Book> books = new ArrayList<>();
        File xmlFile = new File("src/books.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("book");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                String writer = eElement.getElementsByTagName("writer").item(0).getTextContent();
                int pages = Integer.parseInt(eElement.getElementsByTagName("pages").item(0).getTextContent());
                int id=Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());

                books.add(new Book(id,title, writer, pages));
            }
        }
        return books;
    }
}

