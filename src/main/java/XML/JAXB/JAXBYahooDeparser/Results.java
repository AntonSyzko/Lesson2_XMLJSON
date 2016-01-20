package XML.JAXB.JAXBYahooDeparser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ыг on 19.01.2016.
 */
@XmlRootElement(name="results")
public class Results {
    @XmlElement(name="rate")
    protected List<Rate> rates = new ArrayList<Rate>();

    public void addRate(Rate r){
        rates.add(r);
    }

    public Results() {
    }

    public Results(List<Rate> list) {

        this.rates = list;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(rates.toArray());
    }

    public List<Rate> getRates() {
        return rates;
    }
// no setter !!!!!! do not do it
}
