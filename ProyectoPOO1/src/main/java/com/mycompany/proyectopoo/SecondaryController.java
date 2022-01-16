package com.mycompany.proyectopoo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        try {
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        }catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo leer el archivo FXML.");
            a.show();
        
        }
    }
}