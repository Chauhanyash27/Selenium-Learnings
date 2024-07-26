import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {

    public static void main(String[] args) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File("sitemap (2).xml");
            Document document = builder.parse(xmlFile);

            NodeList urlList = document.getElementsByTagName("url");
            for (int i = 0; i < urlList.getLength(); i++) {
                Element url = (Element) urlList.item(i);
                NodeList locList = url.getElementsByTagName("loc");
                Element locElement = (Element) locList.item(0);
                String locValue = locElement.getTextContent();
                // Use locValue
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
