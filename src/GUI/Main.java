package GUI;

import XML.Restaurant;
import XML.TableXML;
import XML.UserXML;
import functions.Athen;
import inhertance.*;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) throws JAXBException {
        launch(args); }

    @Override
    public void start(Stage primaryStage) throws JAXBException, FileNotFoundException {

//-------------------------------------------------------------------------------------------------------------------------------------------
        JAXBContext jax = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshall = jax.createUnmarshaller();
        Restaurant r = (Restaurant) unmarshall.unmarshal(new File("restaurant.xml"));
        List<UserXML> userxml = r.getUsersxml().getUser();
        List<TableXML> table=r.getTablesxml().getTable();
        List<User> user=new ArrayList<>();
        for (UserXML u : userxml){
            switch (u.getRole()){
                case"Manager":
                    Manager m = new Manager(u.getName(),u.getUsername(),u.getPassword());
                    user.add(m);
                    break;
                case"Client":
                    Client c = new Client(u.getName(),u.getUsername(),u.getPassword());
                    user.add(c);
                    break;
                case"Waiter":
                    Waiter w = new Waiter(u.getName(),u.getUsername(),u.getPassword());
                    user.add(w);
                    break;
                case"Cooker":
                    Cooker k = new Cooker(u.getName(),u.getUsername(),u.getPassword());
                    user.add(k);
                    break;
            }
        }




//-------------------------------------------------------------------------------------------------------------------------------------------

        Loginform loginform= new Loginform(primaryStage);
        Clientg clientg =new Clientg(primaryStage);
        Managerg managerg=new Managerg(primaryStage);
        Waiterg waiterg= new Waiterg(primaryStage);
        Cookerg cookerg= new Cookerg(primaryStage);


        loginform.setUser(user);

        loginform.setClientg(clientg);
        clientg.setLoginform(loginform);

        loginform.setManagerg(managerg);
        managerg.setLoginform(loginform);

        loginform.setWaiterg(waiterg);
        waiterg.setLoginform(loginform);

        loginform.setCookerg(cookerg);
        cookerg.setLoginform(loginform);

        loginform.preparescene();



        primaryStage.setScene(loginform.getScene());
        primaryStage.show();
    }
}
