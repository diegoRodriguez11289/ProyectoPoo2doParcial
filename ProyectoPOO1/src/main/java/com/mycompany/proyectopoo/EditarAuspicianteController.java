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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.DueñoDeMascota;
import modelo.Auspiciante;
import modelo.Ciudad;

/**
 *
 * @author user
 */



public class EditarAuspicianteController implements Initializable{
    @FXML
    private Label lbTitulo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtWebpage;
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
    @FXML
    Button Bguardar;
    @FXML
    Button BotonGeditar;
    @FXML
    Label lbCod;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbCiudad.getItems().setAll(Ciudad.cargarCiudades2(App.rutciudades));
    }
    
    @FXML
    private void switchToAdministrar(ActionEvent event) throws IOException {
        App.setRoot("AdministrarAuspiciantes");
       
    }
    
    
    
    
    
        public void llenarCampos(Auspiciante e){
        
        txtWebpage.setText(e.getWebpage());
        txtNombre.setText(e.getNombre());
        txtEmail.setText(e.getEmail());
        txtTelefono.setText(e.getTelefono());
        txtDireccion.setText(e.getDireccion());
        cmbCiudad.setValue(e.getCiudad());
        txtCod.setEditable(false);
        txtCod.setText(e.getCodigo());
        Bguardar.setVisible(false);
        txtCod.setVisible(false);
        lbCod.setVisible(false);
        
    }
        
    public void llenarcampos2(){
      lbTitulo.setText("Agregar Auspiciante");
      BotonGeditar.setVisible(false);
      txtCod.setVisible(false);
      lbCod.setVisible(false);
    }
    
    @FXML
    private void editarAuspiciante() {
        ArrayList<Auspiciante> auspiciantes = Auspiciante.cargarAuspiciantes2(App.rutAuspiciantes);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < auspiciantes.size(); x++) {
            if (auspiciantes.get(x).getCodigo().equals(txtCod.getText())){
                auspiciantes.get(x).setWebpage(txtWebpage.getText());
                auspiciantes.get(x).setDireccion(txtDireccion.getText());
                auspiciantes.get(x).setEmail(txtEmail.getText());
                auspiciantes.get(x).setNombre(txtNombre.getText());
                auspiciantes.get(x).setTelefono(txtTelefono.getText());
                auspiciantes.get(x).setCiudad((Ciudad)cmbCiudad.getValue() );
            }

        }
        
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutAuspiciantes))){
            out.writeObject(auspiciantes);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cambios guardados exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarAuspiciantes");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

    }
    
    @FXML
    private void guardarAuspiciante() {
        ArrayList<Auspiciante> auspiciantes = Auspiciante.cargarAuspiciantes2(App.rutAuspiciantes);//cargar la lista del archivo
        System.out.println("Guardando Dueno");
        Auspiciante d= new Auspiciante(txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText(),
                (Ciudad)cmbCiudad.getValue(),txtEmail.getText(),txtWebpage.getText());
        String cod= d.generarCodigo(txtNombre.getText(), txtTelefono.getText(), txtEmail.getText(), txtWebpage.getText());
       Auspiciante D= new Auspiciante(txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText(),
                (Ciudad)cmbCiudad.getValue(),txtEmail.getText(),txtWebpage.getText(),cod);
      
        auspiciantes.add(D);
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutAuspiciantes))){
            out.writeObject(auspiciantes);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo Auspiciante agregado exitosamente");

            alert.showAndWait();
            App.setRoot("AdministrarAuspiciantes");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
