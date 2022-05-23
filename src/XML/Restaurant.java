package XML;

import functions.Customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {

    @XmlElement(name = "users")
    private UsersXML usersxml = null;

    @XmlElement(name = "tables")
    private TablesXML tablesxml = null;

    @XmlElement(name = "dishes")
    private DishesXML dishesxml = null;

    @XmlElement(name ="customer")
    private List<Customer> customer=null;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public UsersXML getUsersxml() {
        return usersxml;
    }

    public void setUsersxml(UsersXML usersxml) {
        this.usersxml = usersxml;
    }

    public TablesXML getTablesxml() {
        return tablesxml;
    }

    public void setTablesxml(TablesXML tablesxml) {
        this.tablesxml = tablesxml;
    }

    public DishesXML getDishesxml() {
        return dishesxml;
    }

    public void setDishesxml(DishesXML dishesxml) {
        this.dishesxml = dishesxml;
    }
}