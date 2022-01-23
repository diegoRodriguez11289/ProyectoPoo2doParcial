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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import modelo.Ciudad;
import modelo.DueñoDeMascota;
/**
 * FXML Controller class
 *
 * @author user
 */
public class EditarDueñoController implements Initializable {


    @FXML
    private Label lbTitulo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox cmbCiudad;
    @FXML
    TextField txtCod;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void llenarCombo(ArrayList<Ciudad> ciudades) {
        cmbCiudad.getItems().setAll(ciudades);
    }
    
    @FXML
    private void switchToAdministrar(ActionEvent event)throws IOException {
        App.setRoot("AdministrarDuenos");
    }
    
    public void llenarCampos(DueñoDeMascota e){
        lbTitulo.setText("Editar Dueño");
        txtApellidos.setText(e.getApellidos());
        txtNombre.setText(e.getNombre());
        txtEmail.setText(e.getEmail());
        txtTelefono.setText(e.getTelefono());
        txtDireccion.setText(e.getDireccion());
        cmbCiudad.setValue(e.getCiudad());
        txtCod.setEditable(false);
        txtCod.setText(e.getCi());
        txtCod.setVisible(false);
        
    }
    
    @FXML
    private void editarDueno() {
        ArrayList<DueñoDeMascota> dueños = DueñoDeMascota.cargarDuenos2(App.rutDuenos);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < dueños.size(); x++) {
            if (dueños.get(x).getCi().equals(txtCod.getText())){
                dueños.get(x).setApellidos(txtApellidos.getText());
                dueños.get(x).setDireccion(txtDireccion.getText());
                dueños.get(x).setEmail(txtEmail.getText());
                dueños.get(x).setNombre(txtNombre.getText());
                dueños.get(x).setTelefono(txtTelefono.getText());
                //Ciudad c= new Ciudad(cmbCiudad.getValue);
                dueños.get(x).setCiudad((Ciudad)cmbCiudad.getValue() );
            }

        }
        
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutDuenos))){
            out.writeObject(dueños);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cambios guardados exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarDuenos");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

    }
    
    
    
    
    

   
    
    
    
    

}
