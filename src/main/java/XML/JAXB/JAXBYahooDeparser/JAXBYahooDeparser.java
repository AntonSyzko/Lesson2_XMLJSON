package XML.JAXB.JAXBYahooDeparser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ыг on 19.01.2016.
 */
public class JAXBYahooDeparser {

    public static void main(String[] args) {

        try {
           perform();
          //  PrintResultsToConsole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static  void PrintResultsToConsole(){


    }

    private static void  perform() throws IOException {
        String fileDest = "C:\\Users\\Ыг\\Desktop\\JAVA\\Random\\src\\main\\java\\XML\\JAXB\\JAXBYahooDeparser\\deparserYahoo.xml";
        String yahooRes = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
        String res = performRequest(yahooRes);

        PrintWriter pr = new PrintWriter(fileDest);
        try{
            pr.write(res);

        }finally {
            pr.close();
        }

        Query qry = new Query();

        try{
            File f = new File(fileDest);
            JAXBContext context = JAXBContext.newInstance(Query.class);
           Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marsh.marshal(qry, f);
//            marsh.marshal(qry,System.out);

            Unmarshaller unmarsh = context.createUnmarshaller();

            Query gotQry = (Query) unmarsh.unmarshal(f);
            for(Rate r : gotQry.results.rates){
                System.out.println( "     currency    " + r.getName() + "  rate  " + "    on day    " + r.getDate() + "  at time    " + r.getTime() + "    is  " +
                        r.getRate() + "   ask      " + r.getAsk()  + "   bid     " + r.getBid());
            }

            System.out.println();
            System.out.println(gotQry.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


     private static String performRequest(String urlStr) throws IOException {

         StringBuilder sb = new StringBuilder();
         URL url = new URL(urlStr);
         HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

         try{
             BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
             char[] buff = new char[1000000];
             int passer = 0;

             do{
                 if((passer = br.read(buff))>0){
                     sb.append(buff,0,passer);
                 }

             }while (passer>0);
         }finally {
             httpCon.disconnect();
         }


         return sb.toString();
     }

    }
