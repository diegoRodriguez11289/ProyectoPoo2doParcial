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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author user
 */
public class MenuPrincipalController  {


    @FXML
    private Button botonDueños;
    @FXML
    private Button botonConcurso;
    
    @FXML
    private Button botonMascotas;
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private void switchToAdministrarConcursos(ActionEvent event) throws IOException {
        
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("AdministrarConcursos.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
    }
    
    
    
   @FXML
    private void switchToAdministrarDueños(ActionEvent event) throws IOException {
        
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("AdministrarDueños.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
    
        
        
        
    }
    
    @FXML
    public void switchToAdministrarMascotas(ActionEvent event) throws IOException {
        
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("AdministrarMascotas.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        
        
        
    }
}
    
