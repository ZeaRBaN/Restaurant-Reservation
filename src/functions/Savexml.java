package functions;

import XML.Restaurant;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Savexml {
    JAXBContext jax = JAXBContext.newInstance(Restaurant.class);
    Restaurant savedrestaurant = new Restaurant();

    public Savexml() throws JAXBException {
    }


    public  List<Customer> loadcustomer() throws JAXBException {
        Unmarshaller unmarshallcust = jax.createUnmarshaller();
        Restaurant r = (Restaurant) unmarshallcust.unmarshal(new File("restaurant.xml"));
        List<Customer> customer=r.getCustomer();
        return customer;
    }




    public void load(String name,int tablenumber, double totalpayment, int chicken, int mushroom, int salade, int molten, int apple, int potatos, int beef) throws JAXBException {

        Unmarshaller unmarshall = jax.createUnmarshaller();
        Restaurant r = (Restaurant) unmarshall.unmarshal(new File("restaurant.xml"));
        List<Customer> customer =new ArrayList<>();


        Marshaller marshaller = jax.createMarshaller();
        Customer customer1=new Customer();
        Orders orders=new Orders();
        customer1.setName(name);
        customer1.setNumberoftable(tablenumber);
        customer1.setTotalpayment(totalpayment);
        orders.setGrilled_chicken(chicken);
        orders.setMushroom_soup(mushroom);
        orders.setBeef_steak(beef);
        orders.setGreek_salade(salade);
        orders.setMolten_cake(molten);
        orders.setApple_pie(apple);
        orders.setFried_potatos(potatos);
        customer1.setOrders(orders);
        try{
            r.getCustomer().add(customer1);
        }catch (Exception c){
            customer.add(customer1);
            r.setCustomer(customer);
        }

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(r, new File("restaurant.xml"));

    }

//    public void save(String name,int tablenumber, double totalpayment, int chicken, int mushroom, int salade, int molten, int apple, int potatos, int beef) throws JAXBException {
//
//
//
//        Marshaller marshaller = jax.createMarshaller();
//        Restaurant savedrestaurant = new Restaurant();
//        Customer customer1=new Customer();
//        Orders orders=new Orders();
//       customer1.setName(name);
//        customer1.setNumberoftable(tablenumber);
//        customer1.setTotalpayment(totalpayment);
//        orders.setGrilled_chicken(chicken);
//        orders.setMushroom_soup(mushroom);
//        orders.setBeef_steak(beef);
//        orders.setGreek_salade(salade);
//        orders.setMolten_cake(molten);
//        orders.setApple_pie(apple);
//        orders.setFried_potatos(potatos);
//        customer1.setOrders(orders);
//        customer.add(customer1);
//        savedrestaurant.setCustomer(customer);
//        marshaller.marshal(savedrestaurant, new File("save.xml"));
//
//    }

}


