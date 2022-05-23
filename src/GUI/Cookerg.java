package GUI;

import com.sun.javafx.scene.layout.region.BackgroundSizeConverter;
import functions.Customer;
import functions.Last;
import functions.Savexml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.security.acl.GroupImpl;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.BatchUpdateException;
import java.util.List;

public class Cookerg {
    Stage window;
    Scene scene;
    Loginform loginform;
    TableView<Last> table;
    Savexml savexml= new Savexml();
    List<Customer> customer;

    public Cookerg(Stage window) throws JAXBException {
        this.window = window;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }

    public void preparescene() throws JAXBException, FileNotFoundException {

        customer=savexml.loadcustomer();

        int numbofdishes=0;
        int numboftables=0;
        try {
            for(Customer c:customer){
                numbofdishes+= (c.getOrders().getGrilled_chicken()+
                        c.getOrders().getApple_pie()+
                        c.getOrders().getBeef_steak()+
                        c.getOrders().getFried_potatos()+
                        c.getOrders().getGreek_salade()+
                        c.getOrders().getMolten_cake()+
                        c.getOrders().getMushroom_soup());
                numboftables++;
            }
        }catch (Exception x){}


        Image image20 = new Image("file:Cooker.jpg");
        BackgroundImage background = new BackgroundImage(image20, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background1 = new Background(background);

        FileInputStream orderinput = new FileInputStream("orderstats.png");
        Image ordimage = new Image(orderinput);
        ImageView imagerorder = new ImageView(ordimage);
        imagerorder.setPreserveRatio(true);
        imagerorder.setFitHeight(30);

        FileInputStream input2 = new FileInputStream("logout button.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(30);


        TableColumn<Last,Integer> noftablecolm = new TableColumn<>("Table\nNumber");
        noftablecolm.setMinWidth(100);
        noftablecolm.setCellValueFactory(new PropertyValueFactory<>("numberoftable"));


        TableColumn<Last,Integer> grilledcolm = new TableColumn<>("Grilled\nChicken");
        grilledcolm.setMinWidth(100);
        grilledcolm.setCellValueFactory(new PropertyValueFactory<>("grilled_chicken"));

        TableColumn<Last,Integer> saladecolm = new TableColumn<>("Greek\nSalade");
        saladecolm.setMinWidth(100);
        saladecolm.setCellValueFactory(new PropertyValueFactory<>("greek_salade"));

        TableColumn<Last,Integer> friedcolm = new TableColumn<>("Fried\nPotatos");
        friedcolm.setMinWidth(100);
        friedcolm.setCellValueFactory(new PropertyValueFactory<>("fried_potatos"));

        TableColumn<Last,Integer> applecolm = new TableColumn<>("Apple Pie");
        applecolm.setMinWidth(100);
        applecolm.setCellValueFactory(new PropertyValueFactory<>("apple_pie"));

        TableColumn<Last,Integer> moltencolm = new TableColumn<>("Molten Cake");
        moltencolm.setMinWidth(100);
        moltencolm.setCellValueFactory(new PropertyValueFactory<>("molten_cake"));

        TableColumn<Last,Integer> mushroomcolm = new TableColumn<>("Mushroom\nSoup");
        mushroomcolm.setMinWidth(100);
        mushroomcolm.setCellValueFactory(new PropertyValueFactory<>("mushroom_soup"));

        TableColumn<Last,Integer> beefcolm = new TableColumn<>("Beef Steak");
        beefcolm.setMinWidth(100);
        beefcolm.setCellValueFactory(new PropertyValueFactory<>("beef_steak"));

        TableColumn<Last,String> ordercolm = new TableColumn<>("Orders");

        table = new TableView<>();
        try {
            table.setItems(getlast());
        }catch (Exception n){}

        ordercolm.getColumns().addAll(grilledcolm,beefcolm,mushroomcolm,saladecolm,friedcolm,applecolm,moltencolm);
        table.getColumns().addAll(noftablecolm,ordercolm);

        Label cooker = new Label("       COOKER");
        cooker.setStyle("-fx-font-weight: bold");
        cooker.setFont(new Font("Arial", 35));


        Label numberofdishs=new Label("Number of Dishes      :");
        numberofdishs.setFont(new Font("Arial", 22));
        numberofdishs.setStyle("-fx-background-color:white");

        Label totalnumbofdishs = new Label(String.valueOf(numbofdishes));
        totalnumbofdishs.setFont(new Font("Arial", 22));
        totalnumbofdishs.setStyle("-fx-background-color:white;-fx-border-color: black");

        Label numberoftables = new Label(("Total number of tables  :"));
        numberoftables.setFont(new Font("Arial", 22));
        numberoftables.setStyle("-fx-background-color:white");

        Label totalnumboftables = new Label(String.valueOf(numboftables));
        totalnumboftables.setFont(new Font("Arial", 22));
        totalnumboftables.setStyle("-fx-background-color:white;-fx-border-color: black");

        Button logout =new Button("Logout",imageView2);
        logout.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");
        Button view =new Button("View Orders",imagerorder);




        GridPane grid =new GridPane();

        grid.setBackground(background1);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.add(cooker,1,0);
        grid.add(numberoftables,0,1);
        grid.add(totalnumboftables,1,1);
        grid.add(numberofdishs,0,2);
        grid.add(totalnumbofdishs,1,2);
        grid.add(view,0,4);
        grid.add(new Label(""),0,3);
        grid.add(new Label(""),0,5);

        GridPane gridown=new GridPane();

        gridown.add(logout,0,0);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(grid,table,gridown);
        vbox.setSpacing(20);
         table.setVisible(false);
        scene = new Scene(vbox,800,600);

        view.setOnAction(event -> {
           table.setVisible(true);
        });

        logout.setOnAction(e -> {
            try {
                loginform.preparescene();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (JAXBException ex) {
                ex.printStackTrace();
            }
            window.setScene(loginform.getScene());
        });

    }
    public ObservableList<Last> getlast() throws JAXBException {


        List<Customer> customer =savexml.loadcustomer();

        ObservableList<Last> last = FXCollections.observableArrayList();
        for (Customer c : customer) {
            try {
                last.add(new Last(c.getName(), c.getNumberoftable(), c.getTotalpayment(), c.getOrders().getGrilled_chicken(), c.getOrders().getGreek_salade(), c.getOrders().getFried_potatos(), c.getOrders().getApple_pie(), c.getOrders().getMolten_cake(), c.getOrders().getMushroom_soup(), c.getOrders().getBeef_steak()));

            } catch (Exception O) {

            }
        }
        return last;
    }

}
