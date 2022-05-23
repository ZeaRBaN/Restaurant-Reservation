package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alertbox {
    public  static Object display(String massg){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR");
        window.setMinWidth(300);

        Label label= new Label(massg);

        Button button= new Button("OK");
        button.setOnAction(e -> window.close());

        VBox layout= new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();

        return null;
    }
}
