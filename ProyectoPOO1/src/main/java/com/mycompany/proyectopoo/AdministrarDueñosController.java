/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrarDueñosController implements Initializable {


    @FXML
    private Button rdueños;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        
    }
    @FXML
    private void switchToAgregarDueño(ActionEvent event) throws IOException {
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("AgregarDueño.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        
    }

}
