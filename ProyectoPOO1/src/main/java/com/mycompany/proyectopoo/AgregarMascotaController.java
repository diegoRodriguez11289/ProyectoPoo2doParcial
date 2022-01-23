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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import modelo.Ciudad;
import modelo.DueñoDeMascota;
import modelo.Mascota;
import modelo.TipoAnimal;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AgregarMascotaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Label lbTitulo;
    @FXML
    TextField txtNombre;
    @FXML
    TextField txtRaza;
    @FXML
    TextField txtTipo;
    @FXML
    DatePicker txtNacimiento;
    @FXML
    ComboBox cmbDueno;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbDueno.getItems().setAll(DueñoDeMascota.cargarDuenos2(App.rutDuenos));
        // TODO
    }    
    
    @FXML
    private void switchToAdministrar(ActionEvent event) throws IOException {
        App.setRoot("AdministrarMascotas");
        /*
        Parent menuParent =  FXMLLoader.load(getClass().getResource("AdministrarMascotas.fxml"));
        Scene menu = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
        */
    }
    
    @FXML
    private void guardarMascota() {
        ArrayList<Mascota> mascotas = Mascota.cargarMascotas(App.rutmascotascsv);//cargar la lista del archivo
        System.out.println("Guardando Mascota");
         Mascota d= new Mascota(txtNombre.getText(),((DueñoDeMascota)cmbDueno.getValue()).getNombresApellidos(),txtRaza.getText(), TipoAnimal.valueOf(txtTipo.getText()));
         String cod = d.generarCodigo(txtNombre.getText(),TipoAnimal.valueOf(txtTipo.getText()),txtRaza.getText(),txtNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         Mascota d2= new Mascota(txtNombre.getText(),((DueñoDeMascota)cmbDueno.getValue()).getNombresApellidos(),txtRaza.getText(),txtNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), TipoAnimal.valueOf(txtTipo.getText()),cod);
        mascotas.add(d2);
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutMascotas))){
            out.writeObject(mascotas);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva Mascota agregada exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarMascotas");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    
    }
    
}
