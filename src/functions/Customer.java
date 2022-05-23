package functions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name ="Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "numberoftable")
    private int numberoftable;

    @XmlElement(name = "totalpayment")
    private double totalpayment;

    @XmlElement(name = "orders")
    private  Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberoftable() {
        return numberoftable;
    }

    public void setNumberoftable(int numberoftable) {
        this.numberoftable = numberoftable;
    }

    public double getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(double totalpayment) {
        this.totalpayment = totalpayment;
    }
}
