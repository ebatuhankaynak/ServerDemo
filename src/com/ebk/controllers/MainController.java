package com.ebk.controllers;

import com.ebk.FXMLList;
import com.ebk.Storage;
import com.ebk.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Created by E.Batuhan Kaynak on 4.6.2016.
 */
public class MainController {

    @FXML TextField usernameTextField;

    public void onStartAdventureButtonClick(MouseEvent mouseEvent){
        String username = usernameTextField.getText();

        if (username.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Username!");
            alert.setHeaderText("Please enter a valid username");
            ButtonType okButton =  new ButtonType("Ok!");
            alert.getButtonTypes().setAll(okButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == okButton) {
            }
        }else{
            Storage.setUsername(username);
            new Transition().changeScene(mouseEvent, FXMLList.PUBLIC_CHAT, 900, 600);
        }

    }
}
