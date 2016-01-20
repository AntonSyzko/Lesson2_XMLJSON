package XML.JAXB.JAXBYahooDeparser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by Ыг on 19.01.2016.
 */
@XmlRootElement(name="query")
public class Query {

    private String yahoo;
    private String count;
    private String created;
    private String lang;
     Results results;

    public Query() {
    }

    public Query(String yahoo, String count, String created, String lang, Results results) {
        this.yahoo = yahoo;
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

    public String getYahoo() {
        return yahoo;
    }

   @XmlElement(name="yahoo",namespace="http://www.yahooapis.com/v1/base.rng")
    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    public String getCount() {
        return count;
    }
    @XmlElement(name="count",namespace="http://www.yahooapis.com/v1/base.rng")
    public void setCount(String count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }
    @XmlElement(name="created",namespace="http://www.yahooapis.com/v1/base.rng")
    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }
    @XmlElement(name="lang",namespace="http://www.yahooapis.com/v1/base.rng")
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }
    @XmlElement(name="results")
    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Query{" +
                "yahoo='" + yahoo + '\'' +
                ", count='" + count + '\'' +
                ", created='" + created + '\'' +
                ", lang='" + lang + '\'' +
                ", results=" + results +
                '}';
    }
}
