package com.ebk.controllers;

import com.ebk.FXMLList;
import com.ebk.Storage;
import com.ebk.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 4.6.2016.
 */
public class PublicChatController implements Initializable{

    private ArrayList<String> participantList;
    //BufferedReader reader;
    //WSocket wsocket = new WSocket();

    //@FXML TextArea participantListArea;
    @FXML TextArea messageDisplayArea;
    @FXML TextArea messageTextArea;
    @FXML ListView<String> participantListArea;

    public PublicChatController(){
        participantList = new ArrayList<>();
        participantList.add(Storage.getUsername());
        participantList.add("Mahmut");

        //reader = new BufferedReader(new InputStreamReader());

        getParticipantsFromServer();

        //wsocket.through(new DiscardCommunication());

        Thread incomingMessageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String message;

            }
        });
    }

    public void updateParticipantsArea(){
        for (int i = 0; i < participantList.size(); i++){
            participantListArea.getItems().add(participantList.get(i));
        }
    }

    public boolean userInParticipantList(String username){
        for (String s : participantList){
            if (s.equals(username)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getParticipantsFromServer(){
        return null;
    }

    @FXML
    public void onSendButtonClick(MouseEvent mouseEvent){
        String message = messageTextArea.getText();
    }

    @FXML
    public void onListViewItemClick(MouseEvent mouseEvent){
        String participant = participantListArea.getSelectionModel().getSelectedItem();
        startPrivateChat(participant);
    }

    @FXML
    public void onPrivateChatButtonClick(MouseEvent mouseEvent){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Private Chat");
        textInputDialog.setHeaderText("");
        textInputDialog.setContentText("Please enter a username:");

        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()){
            String participant = result.toString().substring(9, result.toString().length() - 1);
            startPrivateChat(participant);
        }
    }

    public void startPrivateChat(String participant){
        if (userInParticipantList(participant)){
            if (Storage.getPrivateChatController() == null) {
                new Transition().openInNewStage(FXMLList.PRIVATE_CHAT);
                Storage.getPrivateChatController().init(participant);
            }else{
                Storage.getPrivateChatController().updateTabPane(participant);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Such Participant");
            alert.setHeaderText("We could not find a participant with that username :(");
            ButtonType okButton =  new ButtonType("Ok!");
            alert.getButtonTypes().setAll(okButton);

            Optional<ButtonType> result2 = alert.showAndWait();
            if (result2.get() == okButton) {
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateParticipantsArea();
    }
}
