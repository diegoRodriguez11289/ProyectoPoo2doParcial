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
 * @author DELL
 */
public class AdministrarConcursosController implements Initializable {

    @FXML
    private Button crearConcursoButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
        /*
        Parent menuParent =  FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene menu = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
        */
        
    }
    
    @FXML
    private void switchToCrearConcursos(ActionEvent event) throws IOException {
        App.setRoot("CrearConcursos");
        /*
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("CrearConcursos.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        */
        
    }
    
}
