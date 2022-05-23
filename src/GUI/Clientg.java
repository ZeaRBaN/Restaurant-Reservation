package GUI;

import XML.DishXML;
import XML.Restaurant;
import XML.TableXML;
import XML.TablesXML;
import functions.Customer;
import functions.Savexml;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clientg {
    Stage window;
    Scene scene;
    Loginform loginform;
    String nameofclient;


    private double chicken;
    double chikenp = 0, mushroomp = 0, beefp = 0, saladep = 0, potatosp = 0, applep = 0, moltenp = 0, total = 0;
    int trace;


    public void setNameofclient(String nameofclient) {
        this.nameofclient = nameofclient;
    }

    public Clientg(Stage window) {
        this.window = window;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }

    public void preparescene() throws JAXBException, FileNotFoundException {

        JAXBContext jax = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshall = jax.createUnmarshaller();
        Restaurant r = (Restaurant) unmarshall.unmarshal(new File("restaurant.xml"));
        List<TableXML> table = r.getTablesxml().getTable();
        List<DishXML> dish = r.getDishesxml().getDish();
        List<Customer> customer =r.getCustomer();
        Savexml savexml = new Savexml();

//SCENE 1 --------------------------------------------------------------------------------------------------------------

        FileInputStream input2 = new FileInputStream("logout button.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(30);

        FileInputStream input3 = new FileInputStream("logout button.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setPreserveRatio(true);
        imageView3.setFitHeight(30);

        FileInputStream backinput = new FileInputStream("backbutton.png");
        Image backimage = new Image(backinput);
        ImageView backview = new ImageView(backimage);
        backview.setPreserveRatio(true);
        backview.setFitHeight(25);

        FileInputStream checkoutinput = new FileInputStream("shipping-and-delivery.png");
        Image checkimage = new Image(checkoutinput);
        ImageView checkout = new ImageView(checkimage);
        checkout.setPreserveRatio(true);
        checkout.setFitHeight(25);

        FileInputStream orderinput = new FileInputStream("order.png");
        Image ordimage = new Image(orderinput);
        ImageView imagerorder = new ImageView(ordimage);
        imagerorder.setPreserveRatio(true);
        imagerorder.setFitHeight(30);

        FileInputStream searchinput = new FileInputStream("search.png");
        Image searimage = new Image(searchinput);
        ImageView imagesearch = new ImageView(searimage);
        imagesearch.setPreserveRatio(true);
        imagesearch.setFitHeight(30);

        FileInputStream doneinput = new FileInputStream("tick.png");
        Image donimage = new Image(doneinput);
        ImageView imagedone = new ImageView(donimage);
        imagedone.setPreserveRatio(true);
        imagedone.setFitHeight(30);

        Button logout = new Button("Log out",imageView2);
        logout.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");
        Button search = new Button("Search",imagesearch);
        Button order = new Button("Order",imagerorder);

        Label numbofsts = new Label("Enter Number of Seats ");
        numbofsts.setFont(new Font("Arial", 22));
        numbofsts.setStyle("-fx-background-color:white");
        Label choose = new Label("Smoking or NonSmoking");
        choose.setFont(new Font("Arial", 22));
        choose.setStyle("-fx-background-color:white");
        Label found = new Label();

        ComboBox<String> smoke = new ComboBox<>();
        smoke.getItems().addAll("SMOKING", "NONSMOKING");
        smoke.setPromptText("SMOKE OR NON");

        GridPane grid = new GridPane();


        TextField seatnum = new TextField();


        search.setOnAction(e -> {
                    int seatnumb = vald(seatnum.getText());
                    boolean smokingg;
                    try {
                        smokingg = smoke.getValue().equals("SMOKING");
                    } catch (Exception i) {
                        Alertbox.display("CHOOSE SMOKING OR NON");
                    }
                    smokingg = smoke.getValue().equals("SMOKING");

                    int notfound=0;
                    Collections.sort(table);
                    for (TableXML t : table) {
                        int foundbad = 0;
                        if (smokingg == t.isSmoking() && seatnumb <= t.getNumberofseats()) {
                            try{
                            for (Customer c : customer) {
                                if (t.getNumber() == c.getNumberoftable())
                                    foundbad = 1;
                            }
                            }catch(Exception c){}
                            if (foundbad == 0) {
                                found.setText("Table " + t.getNumber() + " is found ");
                                found.setFont(new Font("Arial", 18));

                                trace = t.getNumber();
                                try {
                                    grid.add(order, 2, 30);
                                } catch (Exception m) {
                                }
                                notfound=1;
                                break;
                            }else System.out.println("not thise one");

                        }
                    }
                    if(notfound==0)
                        found.setText("No Table Found");
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

        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(numbofsts, 0, 0);
        grid.add(choose, 0, 1);
        grid.add(seatnum, 1, 0);
        grid.add(smoke, 1, 1);
        grid.add(search, 1, 5);
        grid.add(found, 1, 2);
        grid.add(logout, 0, 30);

        Image image20 = new Image("file:315581.png");
        BackgroundImage background = new BackgroundImage(image20, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background1 = new Background(background);
        grid.setBackground(background1);



        scene = new Scene(grid, 540, 308);

//SCENE 1 --------------------------------------------------------------------------------------------------------------
//SCENE 2---------------------------------------------------------------------------------------------------------------

        Button back = new Button("BACK",backview);
//        back.setStyle("-fx-background-color:#FFFFFF");
        Button done = new Button("DONE",imagedone);
        Button logout2 = new Button("Log out",imageView3);
        logout2.setStyle("-fx-background-color: #7CAFC2; -fx-background-radius: 4; ");
        Button add = new Button("CHECK OUT",checkout);


        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);

        Spinner<Integer> grilled = new Spinner<>(valueFactory);
        Spinner<Integer> mushroom = new Spinner<>(valueFactory2);
        Spinner<Integer> beef = new Spinner<>(valueFactory3);
        Spinner<Integer> salade = new Spinner<>(valueFactory4);
        Spinner<Integer> potatos = new Spinner<>(valueFactory5);
        Spinner<Integer> molten = new Spinner<>(valueFactory6);
        Spinner<Integer> apple = new Spinner<>(valueFactory7);


        Label price = new Label("TOTAL PRICE :");
        price.setFont(new Font("Arial", 24));

        Label print = new Label();

        Label mushrom = new Label("Mushroom Soup");
        mushrom.setFont(new Font("Arial", 18));


        Label bef = new Label("Beef Steak");
        bef.setFont(new Font("Arial", 18));

        Label salde = new Label("Greek Salade");
        salde.setFont(new Font("Arial", 18));


        Label potats = new Label("Fried Potatos");
        potats.setFont(new Font("Arial", 18));


        Label moltn = new Label("Molten Cake");
        moltn.setFont(new Font("Arial", 18));


        Label aple = new Label("Apple Pie");
        aple.setFont(new Font("Arial", 18));


        Label griled = new Label("Grilled Chicken");
        griled.setFont(new Font("Arial", 18));


        Label type = new Label("Type OF Dish");
        type.setFont(new Font("Arial", 24));


        Label quantaty = new Label("Quantity");
        quantaty.setFont(new Font("Arial", 24));


        Label pricep = new Label("Price");

        pricep.setFont(new Font("Arial", 24));

        Label pchicken = new Label();
        Label pmushroom = new Label();
        Label pbeef = new Label();
        Label psalade = new Label();
        Label pmolten = new Label();
        Label ppotatos = new Label();
        Label papple = new Label();

        GridPane grid2 = new GridPane();
        Scene scene2 = new Scene(grid2, 520, 470);

        Image image2nd = new Image("file:shoka2.jpg");
        BackgroundImage background2 = new BackgroundImage(image2nd, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background12 = new Background(background2);
        grid2.setBackground(background12);

        grid2.setVgap(10);
        grid2.setHgap(20);
        grid2.add(type, 0, 0);
        grid2.add(quantaty, 1, 0);
        grid2.add(pricep, 2, 0);
        grid2.add(griled, 0, 1);
        grid2.add(grilled, 1, 1);
        grid2.add(pchicken, 2, 1);
        grid2.add(mushrom, 0, 2);
        grid2.add(mushroom, 1, 2);
        grid2.add(pmushroom, 2, 2);
        grid2.add(bef, 0, 3);
        grid2.add(beef, 1, 3);
        grid2.add(pbeef, 2, 3);
        grid2.add(salde, 0, 4);
        grid2.add(salade, 1, 4);
        grid2.add(psalade, 2, 4);
        grid2.add(potats, 0, 5);
        grid2.add(potatos, 1, 5);
        grid2.add(ppotatos, 2, 5);
        grid2.add(moltn, 0, 6);
        grid2.add(molten, 1, 6);
        grid2.add(pmolten, 2, 6);
        grid2.add(aple, 0, 7);
        grid2.add(apple, 1, 7);
        grid2.add(papple, 2, 7);
        grid2.add(price, 0, 8);
        grid2.add(print, 1, 8);
        grid2.add(add, 1, 9);
        grid2.add(logout2, 0, 12);
       grid2.add(back,1,12);


        back.setOnAction(event -> window.setScene(scene));


        order.setOnAction(e -> {
            window.setScene(scene2);
        });

        logout2.setOnAction(e -> {

            try {
                loginform.preparescene();
            } catch (FileNotFoundException | JAXBException ex) {
                ex.printStackTrace();
            }
            window.setScene(loginform.getScene());

        });


        add.setOnAction(event -> {
            for (DishXML d : dish) {
                if (d.getName().equals("Grilled Chicken")) {
                    chikenp = d.getPrice() * grilled.getValue() * 1.15;
                }
                if (d.getName().equals("Mushroom Soup")) {
                    mushroomp = d.getPrice() * mushroom.getValue() * 1.15;
                }
                if (d.getName().equals("Beef Steak")) {
                    beefp = d.getPrice() * beef.getValue() * 1.15;
                }
                if (d.getName().equals("Greek Salade")) {
                    saladep = d.getPrice() * salade.getValue() * 1.1;
                }
                if (d.getName().equals("Fried Potatos")) {
                    potatosp = d.getPrice() * potatos.getValue() * 1.1;
                }
                if (d.getName().equals("Apple Pie")) {
                    applep = d.getPrice() * apple.getValue() * 1.2;
                }
                if (d.getName().equals("Molten Cake")) {
                    moltenp = d.getPrice() * molten.getValue() * 1.2;
                }
            }


            total = chikenp + mushroomp + beefp + saladep + potatosp + applep + moltenp;
            pchicken.setText(String.valueOf(chikenp)+" $");
            pchicken.setStyle("-fx-border-color: black;");

            pmushroom.setText(String.valueOf(mushroomp)+" $");
            pmushroom.setStyle("-fx-border-color: black;");

            pbeef.setText(String.valueOf(beefp)+" $");
            pbeef.setStyle("-fx-border-color: black;");

            psalade.setText(String.valueOf(saladep)+" $");
            psalade.setStyle("-fx-border-color: black;");

            ppotatos.setText(String.valueOf(potatosp)+" $");
            ppotatos.setStyle("-fx-border-color: black;");

            papple.setText(String.valueOf(applep)+" $");
            papple.setStyle("-fx-border-color: black;");

            pmolten.setText(String.valueOf(moltenp)+" $");
            pmolten.setStyle("-fx-border-color: black;");

            print.setText("\t" + String.valueOf(total) +"$");

            print.setFont(new Font("Arial", 24));

            try {
                grid2.add(done, 2, 12);
            }catch(Exception f){

            }

        });
        done.setOnAction(event -> {
            done.setDisable(true);

          try {
              savexml.load(nameofclient,trace,total,grilled.getValue(),mushroom.getValue(),salade.getValue(),molten.getValue(),apple.getValue(),potatos.getValue(),beef.getValue());
          } catch (JAXBException e) {
              e.printStackTrace();
          }


        });


    }

    //textfieldvalidation
    private int vald(String str) {
        try {
            int numb = Integer.parseInt(str);
            return numb;
        } catch (NumberFormatException e) {
            Alertbox.display("Enter Numbers only");
            return -1;
        }

    }

    public Scene getScene() {
        return scene;
    }
}