package GUI;

import XML.Restaurant;
import functions.Customer;
import functions.Last;
import functions.Savexml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Managerg {
    Stage window;
    Scene scene;
    Loginform loginform;
    TableView<Last> table;
    Savexml savexml= new Savexml();
   List<Customer> customer;


    public Managerg(Stage window) throws JAXBException {
        this.window = window;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }
    public void preparescene() throws JAXBException, FileNotFoundException {

        FileInputStream input = new FileInputStream("logout button.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(30);

        FileInputStream info = new FileInputStream("stats.png");
        Image infoimage = new Image(info);
        ImageView imageinformation = new ImageView(infoimage);
        imageinformation.setPreserveRatio(true);
        imageinformation.setFitHeight(30);


        FileInputStream backinput = new FileInputStream("backbutton.png");
        Image backimage = new Image(backinput);
        ImageView backview = new ImageView(backimage);
        backview.setPreserveRatio(true);
        backview.setFitHeight(25);

        customer=savexml.loadcustomer();

        int reservnumb=0;
        double totalearned=0;
       try {
           for(Customer c:customer){
               totalearned+=c.getTotalpayment();
               reservnumb++;
           }
       }catch (Exception x){}



//----------------------------------------------------------------------------------------------------------------------
    GridPane grid2 =new GridPane();
    GridPane grid =  new GridPane();


        Image image20 = new Image("file:manager.jpg");
        BackgroundImage background = new BackgroundImage(image20, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background1 = new Background(background);





    Button view = new Button("View more Information",imageinformation);
    Button logout = new Button("Logout",imageView);
    logout.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");

    Label welcome = new Label("Welcome Manager");
    welcome.setStyle("-fx-font-weight: bold;");
    welcome.setFont(new Font("Arial", 30));


    Label totalmoney =new Label("Total Money earned         :");
    totalmoney.setFont(new Font("Arial", 22));

    Label money=new Label(String.valueOf(totalearned)+" $");
    money.setFont(new Font("Arial", 22));

    Label numbofres =new Label("Number of Reservations  :");
    numbofres.setFont(new Font("Arial", 22));

    Label reservationnumber= new Label(String.valueOf(reservnumb));
    reservationnumber.setFont(new Font("Arial", 22));

    grid.setVgap(10);
    grid.setHgap(20);
//    grid.add(welcome,1,0);
    grid.add(numbofres,0,3);
    grid.add(totalmoney,0,4);
    grid.add(reservationnumber,1,3);
    grid.add(money,1,4);
    grid.add(view,0,10);
    grid.add(logout,0,20);


        HBox hbox = new HBox();
        hbox.getChildren().add(welcome);
        hbox.setAlignment(Pos.CENTER);

        VBox vBox2 =new VBox();
        vBox2.getChildren().addAll(hbox,grid);
        vBox2.setBackground(background1);
        scene = new Scene(vBox2,500,370);

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
//----------------------------------------------------------------------------------------------------------------------
        Button logout2 = new Button("Logout",imageView);
        logout2.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");
        logout2.setOnAction(e -> {
            try {
                loginform.preparescene();
            } catch (FileNotFoundException | JAXBException ex) {
                ex.printStackTrace();
            }
            window.setScene(loginform.getScene());
        });



        TableColumn<Last,String> namecolum = new TableColumn<>("Name");
        namecolum.setMinWidth(150);
        namecolum.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Last,Integer> noftablecolm = new TableColumn<>("Table\nNumber");
        noftablecolm.setMinWidth(100);
        noftablecolm.setCellValueFactory(new PropertyValueFactory<>("numberoftable"));

        TableColumn<Last,Double> totalpaycolm = new TableColumn<>("Total\npayment");
        totalpaycolm.setMinWidth(100);
        totalpaycolm.setCellValueFactory(new PropertyValueFactory<>("totalpayment"));

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
        table.getColumns().addAll(namecolum,totalpaycolm,noftablecolm,ordercolm);

        Button back = new Button("Back",backview);


        Label totalmoney2 =new Label("Total Money earned:");
        totalmoney2.setFont(new Font("Arial", 22));
        totalmoney2.setStyle("-fx-font-weight: bold");

        Label money2 =new Label(String.valueOf(totalearned)+" $");
        money2.setFont(new Font("Arial", 22));
        money2.setStyle("-fx-border-color: black");

//        grid2.add(table,0,0);
        grid2.setVgap(10);
        grid2.setHgap(20);
        grid2.add(logout2,0,0);
        grid2.add(back,1,0);
        grid2.add(totalmoney2,4,0);
        grid2.add(money2,5,0);



        VBox vbox = new VBox();
        vbox.getChildren().addAll(table,grid2);
        Scene scene2 = new Scene(vbox,1053,400);
        back.setOnAction(event -> {
            window.setScene(scene);
        });

        view.setOnAction(event -> {
            window.setScene(scene2);
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

    private Customer getCustomer(Customer customer) {
        return customer;
    }
}
