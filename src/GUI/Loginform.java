package GUI;

import functions.Athen;
import inhertance.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Loginform {
Stage window;
Scene smain;
Clientg clientg;
Managerg managerg;
Cookerg cookerg;
Waiterg waiterg;
List<User> user;
Athen athen=new Athen();



    public void setCookerg(Cookerg cookerg) {
        this.cookerg = cookerg;
    }


    public void setWaiterg(Waiterg waiterg) {
        this.waiterg = waiterg;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Loginform(Stage window) {
        this.window = window;
    }

    public void setManagerg(Managerg managerg) {
        this.managerg = managerg;
    }

    public void setClientg(Clientg clientg) {
        this.clientg = clientg;
    }

    public void preparescene() throws FileNotFoundException, JAXBException {

        clientg.preparescene();
        managerg.preparescene();
        cookerg.preparescene();
        waiterg.preparescene();



        FileInputStream input = new FileInputStream("login-button-pngrepo-com.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(30);







        GridPane gmain =new GridPane();
        smain =new Scene(gmain,300,200);
       gmain.setStyle("-fx-background-color: #383838");

        window.setTitle("Login");


        Button signin = new Button("Sign in",imageView);
        signin.setMnemonicParsing(true);
        signin.setStyle("-fx-background-color: #AB4564; -fx-background-radius: 4; ");



        Label username = new Label("USERNAME");
        username.setStyle("-fx-text-fill: aliceblue");
        Label password =new Label("PASSWORD");
        password.setStyle("-fx-text-fill: aliceblue");

        TextField tusername = new TextField();
        PasswordField tpassword = new PasswordField();



        gmain.setHgap(5);
        gmain.setVgap(5);
        gmain.add(username,0,0);
        gmain.add(password,0,1);
        gmain.add(tusername,1,0);
        gmain.add(tpassword,1,1);
        gmain.add(signin,1,2);




        signin.setOnAction(e -> {
            athen.setUser(user);
            switch (athen.check(tusername.getText(),tpassword.getText())){
                case"Manager":
                    window.setTitle("Manager Dashboard");
                    window.setScene(managerg.getScene());
                    break;
                case"Client":
                    window.setTitle("Client Dashboard");
                    clientg.setNameofclient(athen.getNameofclient());
                    window.setScene(clientg.getScene());
                    break;
                case"Waiter":
                    window.setTitle("Waiter DashBoard");
                    window.setScene(waiterg.getScene());
                    break;
                case"Cooker":
                 window.setTitle("Cooker DashBoard");
                 window.setScene(cookerg.getScene());
                    break;
            }
        });

    }

    public Scene getScene() {
        return smain;
    }
}
