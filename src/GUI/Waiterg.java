package GUI;

import com.sun.corba.se.impl.logging.POASystemException;
import functions.Customer;
import functions.Last;
import functions.Savexml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Waiterg {
    Stage window;
    Scene scene;
    Loginform loginform;
    Savexml savexml= new Savexml();
    List<Customer> customer;
    TableView<Last> table;

    public Scene getScene() {
        return scene;
    }

    public Waiterg(Stage window) throws JAXBException {
        this.window = window;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }
    public void preparescene() throws FileNotFoundException, JAXBException {


        customer=savexml.loadcustomer();

        int reservnumb=0;
        try {
            for(Customer c:customer){
                reservnumb++;
            }
        }catch (Exception x){}





        GridPane grid =new GridPane();
        VBox vbox = new VBox();
        scene = new Scene(vbox,520,590);


        Image image20 = new Image("file:5817_preview.png");
        BackgroundImage background = new BackgroundImage(image20, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background1 = new Background(background);


        FileInputStream input2 = new FileInputStream("logout button.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(30);

        FileInputStream viewinput = new FileInputStream("reserved.png");
        Image view2 = new Image(viewinput);
        ImageView viewimage = new ImageView(view2);
        viewimage.setPreserveRatio(true);
        viewimage.setFitHeight(30);


        TableColumn<Last,String> namecolum = new TableColumn<>("Name");
        namecolum.setMinWidth(150);
        namecolum.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Last,Integer> noftablecolm = new TableColumn<>("Table\nNumber");
        noftablecolm.setMinWidth(100);
        noftablecolm.setCellValueFactory(new PropertyValueFactory<>("numberoftable"));



        table = new TableView<>();
        try {
            table.setItems(getlast());
        }catch (Exception n){}


        table.getColumns().addAll(namecolum,noftablecolm);
        table.setVisible(false);

        Label numbofres =new Label("Number of Reservations  :");
        numbofres.setFont(new Font("Arial", 22));

        Label reservationnumber= new Label(String.valueOf(reservnumb));
        reservationnumber.setFont(new Font("Arial", 22));

        Label welcome = new Label("Waiter");
        welcome.setStyle("-fx-font-weight: bold");
        welcome.setFont(new Font("Arial", 34));

        Button logout = new Button("Logout",imageView2);
        logout.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");
        Button view =new Button("View Reservations",viewimage);


        HBox hboxtable = new HBox();
        hboxtable.getChildren().add(table);
        hboxtable.setAlignment(Pos.CENTER);
        hboxtable.setVisible(false);

        HBox hbox = new HBox();
        hbox.getChildren().add(welcome);
        hbox.setAlignment(Pos.CENTER);


        grid.setHgap(10);
        grid.setVgap(20);
        grid.add(numbofres,0,0);
        grid.add(reservationnumber,1,0);
//        grid.add(table,1,2);
        grid.add(view,0,1);
//        grid.add(logout,0,3);
        vbox.getChildren().addAll(hbox,grid,hboxtable,logout);
        vbox.spacingProperty();
        vbox.setBackground(background1);

        view.setOnAction(event -> {
            table.setVisible(true);
            hboxtable.setVisible(true);

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
