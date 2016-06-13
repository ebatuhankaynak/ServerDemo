package com.ebk.controllers;

import com.ebk.Storage;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Created by E.Batuhan Kaynak on 13.6.2016.
 */
public class PrivateChatController {

    //private static PrivateChatController instance = null;

    @FXML TabPane tabPane;

    public PrivateChatController(){
        Storage.setPrivateChatController(this);
    }

    public void updateTabPane(String participant){
        final Tab tab = new Tab(participant);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    public void init(String participant){
        tabPane.getTabs().get(0).setText(participant);
    }
}
