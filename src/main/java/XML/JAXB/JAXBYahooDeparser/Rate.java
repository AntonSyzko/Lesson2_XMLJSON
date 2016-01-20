package XML.JAXB.JAXBYahooDeparser;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


/**
 * Created by Ыг on 19.01.2016.
 */
@XmlRootElement(name="rate")
public class Rate {
    private String id;

    private String Name;

    private double Rate;

    private String Date;

    private String Time;
    private String Ask;

    private String Bid;


    public Rate(String id, String name, double rate, String date, String time, String ask, String bid) {
        this.id = id;
        Name = name;
        Rate = rate;
        Date = date;
        Time = time;
        Ask = ask;
        Bid = bid;
    }

    public Rate() {
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Rate=" + Rate +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Ask='" + Ask + '\'' +
                ", Bid='" + Bid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    @XmlElement(name="id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    @XmlElement(name="Name")
    public void setName(String name) {
        Name = name;
    }

    public double getRate() {
        return Rate;
    }
    @XmlElement(name="Rate")
    public void setRate(double rate) {
        Rate = rate;
    }

    public String getDate() {
        return Date;
    }
    @XmlElement(name="Date")
    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }
    @XmlElement(name="Time")
    public void setTime(String time) {
        Time = time;
    }

    public String getAsk() {
        return Ask;
    }
    @XmlElement(name="Ask")
    public void setAsk(String ask) {
        Ask = ask;
    }

    public String getBid() {
        return Bid;
    }
    @XmlElement(name="Bid")
    public void setBid(String bid) {
        Bid = bid;
    }
}
