package utils;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLReader {

    public static String getXMLData(String dataFor)
    {
        String nodeValue = null;
        try{
            File file = new File(PropReader.readConfig ("xml-data"));
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(file);
            nodeValue =  document.getElementsByTagName(dataFor).item(0).getTextContent();
        }
        catch(Exception e)
        {
            throw new RuntimeException (e);
        }

        return nodeValue;
    }


}
