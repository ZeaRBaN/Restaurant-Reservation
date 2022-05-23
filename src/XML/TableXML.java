package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableXML implements Comparable<TableXML> {


    @XmlElement(name = "number")
    private int number;

    @XmlElement(name = "number_of_seats")
    private int number_of_seats;

    @XmlElement(name = "smoking")
    private boolean smoking;




    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberofseats() {
        return number_of_seats;
    }

    public void setNumberofseats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    @Override
    public int compareTo(TableXML tableXML) {
        return this.getNumberofseats()-tableXML.getNumberofseats();
    }
}
