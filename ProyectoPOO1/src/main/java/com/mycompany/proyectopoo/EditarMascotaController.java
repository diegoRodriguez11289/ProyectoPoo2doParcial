/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Mascota;
import modelo.DueñoDeMascota;
/**
 * FXML Controller class
 *
 * @author user
 */
public class EditarMascotaController implements Initializable {


    @FXML
    private Label lbTitulo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRaza;
    @FXML
    private TextField txtNacimiento;
    @FXML
    private TextField txtTipo;
    @FXML
    private ComboBox cmbDueno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void llenarCombo(ArrayList<DueñoDeMascota> mascotas) {
        cmbDueno.getItems().setAll(mascotas);
    }
    
    @FXML
    private void switchToAdministrar(ActionEvent event)throws IOException {
        App.setRoot("AdministrarMascotas");
    }
    
    public void llenarCampos(Mascota e){
        lbTitulo.setText("Editar Mascota");
        txtNombre.setText(e.getNombre());
        txtRaza.setText(e.getRaza());
        cmbDueno.setValue(e.getDueno());

        
        
    }
    
    @FXML
    private void editarMascota() {
        ArrayList<Mascota> mascotas = Mascota.cargarMascotas2(App.rutMascotas);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < mascotas.size(); x++) {
            if (mascotas.get(x).getRaza().equals(txtRaza.getText())){
                mascotas.get(x).setNombre(txtNombre.getText());
                //Ciudad c= new Ciudad(cmbCiudad.getValue);
                mascotas.get(x).setDueno((DueñoDeMascota)cmbDueno.getValue() );
            }

        }
        
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutMascotas))){
            out.writeObject(mascotas);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cambios guardados exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarMascotas");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

    }
    
    
    
    
    

   
    
    
    
    

}
