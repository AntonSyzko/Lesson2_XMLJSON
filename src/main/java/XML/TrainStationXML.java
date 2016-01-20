package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ыг on 20.01.2016.
 * Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
 отправляются сегодня с 15:00 до 19:00.
 */
public class TrainStationXML {


    public static void main(String[] args) {

        getTrains();
    }


    public static void getTrains(){
        try{
            File file = new File("C:\\Users\\Ыг\\Desktop\\JAVA\\Random\\src\\main\\java\\XML\\Trains.xml");
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
            Document doc = dbuilder.parse(file);
            Element root = doc.getDocumentElement();

            NodeList listOftags = root.getChildNodes();

            for(int i = 0; i<listOftags.getLength();i++){
                Node node =  listOftags.item(i);

              //  System.out.println(node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){
                      Element elem = (Element) node;

                   String time1 = elem.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue();
                   String[] subs = time1.split(":");
                    for(int j = 0;j<subs.length; j ++){
                        int reslow = Integer.parseInt(subs[0]);
                        if(reslow >=15 && reslow<=19){
                            System.out.println("  Train " + elem.getElementsByTagName("from").item(0).getChildNodes().item(0).getNodeValue() +
                                    "  " + elem.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue() +
                                    "  leaves  " + elem.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue() + "\r\n");


                        }

                    }

//                    System.out.println("  Train " + elem.getElementsByTagName("from").item(0).getChildNodes().item(0).getNodeValue() +
//                            "  " + elem.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue() +
//                            "  leaves  " + elem.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue() + "\r\n");
//

                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
