package xml_parser;

import manipulation_handler.TranslationPOJO;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class XmlFileBuilder {

    public static void buildXml(TranslationPOJO translationPOJO, List<String> keys) {

        try {




            List<HashMap<String, String>> allLanguages = translationPOJO.getAllLanguages();

            for (int iterator = 0; iterator < 2; iterator++) {
                DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();

                Element root = document.createElement("resources");
                document.appendChild(root);

                for (String key : keys) {
                    if(!key.equals("")) {
                        try {
                            Element employee = document.createElement("string");
                            employee.setAttribute("name", key.substring(1, key.length()-1));
                            employee.appendChild(document.createTextNode(allLanguages.get(iterator).get(key).substring(1, allLanguages.get(iterator).get(key).length() - 1)));
                            root.appendChild(employee);
                        }
                        catch (StringIndexOutOfBoundsException e){
                            System.out.println(allLanguages.get(iterator).get(key));
                            e.printStackTrace();
                        }
                    }
                }


                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File("C:\\Users\\laurentiu.pirvan\\IdeaProjects\\TranslateConverter\\strings" + iterator + ".xml"));

                transformer.transform(domSource, streamResult);

            }



            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

}
