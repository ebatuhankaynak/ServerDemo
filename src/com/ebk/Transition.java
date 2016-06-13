package com.ebk;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by E.Batuhan Kaynak on 4.6.2016.
 */
public class Transition {

    public void changeScene(MouseEvent mouseEvent, String fxml){
        Button button = (Button) mouseEvent.getSource();

        Stage stage = (Stage) button.getScene().getWindow();

        String source = "resources/" + fxml + ".fxml";

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(MouseEvent mouseEvent, String fxml, int height, int width){
        Button button = (Button) mouseEvent.getSource();

        Stage stage = (Stage) button.getScene().getWindow();

        String source = "resources/" + fxml + ".fxml";

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, height, width);
        stage.setScene(scene);
        stage.show();
    }

    public void openInNewStage(String fxml){
        String source = "resources/" + fxml + ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(source));

        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
