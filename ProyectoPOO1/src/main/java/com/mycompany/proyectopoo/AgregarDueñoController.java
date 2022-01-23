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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Ciudad;
import modelo.DueñoDeMascota;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AgregarDueñoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label lbTitulo;
    @FXML
    TextField txtNombre;
    @FXML
    TextField txtApellidos;
    @FXML
    TextField txtDireccion;
    @FXML
    TextField txtTelefono;
    @FXML
    TextField txtEmail;
    @FXML
    ComboBox cmbCiudad;
    @FXML
    TextField txtCod;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbCiudad.getItems().setAll(Ciudad.cargarCiudades2(App.rutciudades));
    }    
    
    @FXML
    private void switchToAdministrar(ActionEvent event) throws IOException {
        App.setRoot("AdministrarDuenos");
        /*
        Parent menuParent =  FXMLLoader.load(getClass().getResource("AdministrarDuenos.fxml"));
        Scene menu = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
        */
    }
    
    @FXML
    private void guardarDueno() {
        ArrayList<DueñoDeMascota> dueños = DueñoDeMascota.cargarDuenos2(App.rutDuenos);//cargar la lista del archivo
        System.out.println("Guardando Dueno");
        DueñoDeMascota d= new DueñoDeMascota(txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText(),
                (Ciudad)cmbCiudad.getValue(),txtEmail.getText(),txtApellidos.getText());
        String cod= d.generarCodigo(txtNombre.getText(), txtTelefono.getText(), txtEmail.getText(), txtApellidos.getText());
        DueñoDeMascota D= new DueñoDeMascota(txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText(),
                (Ciudad)cmbCiudad.getValue(),txtEmail.getText(),txtApellidos.getText(),cod);
      
        dueños.add(D);
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutDuenos))){
            out.writeObject(dueños);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo Dueño agregada exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarDuenos");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    
    }
    
    
    
    
    
    
    
}
