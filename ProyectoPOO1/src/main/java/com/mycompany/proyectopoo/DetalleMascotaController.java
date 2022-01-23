/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import modelo.Mascota;

/**
 *
 * @author Johnny Mejia
 */
public class DetalleMascotaController implements Initializable {
    
    @FXML
    private TextArea txtNombre;
    @FXML
    private TextArea txtNacimiento;
    @FXML
    private TextArea txtRaza;
    @FXML
    private TextArea txtDueno;
    @FXML
    private ImageView spacePhoto;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {

    }   
    
     @FXML
    private void switchToAdministrar(ActionEvent event)throws IOException {
        App.setRoot("AdministrarMascotas");
    }
    
    @FXML
    public void llenarCampos(Mascota e){
        txtNombre.setText(e.getNombre());
        txtRaza.setText(e.getRaza());
        txtNacimiento.setText(e.getNacimiento());
        txtDueno.setText(e.getDuenoNombre());
    }
       
}
