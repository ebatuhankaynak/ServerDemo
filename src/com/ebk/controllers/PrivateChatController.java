package com.ebk.controllers;

import com.ebk.Storage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * Created by E.Batuhan Kaynak on 13.6.2016.
 */
public class PrivateChatController {

    @FXML TabPane tabPane;

    public PrivateChatController(){
        Storage.setPrivateChatController(this);
    }

    public void updateTabPane(String participant){
        final Tab tab = new Tab(participant);
        try {
            tab.setContent((Node) FXMLLoader.load(this.getClass().getResource("../resources/Tab.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

        tabPane.getScene().getWindow().setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Storage.setPrivateChatController(null);
            }
        });
        tabPane.getScene().getWindow().requestFocus();
    }

    public void init(String participant){
        tabPane.getTabs().get(0).setText(participant);
    }
}
