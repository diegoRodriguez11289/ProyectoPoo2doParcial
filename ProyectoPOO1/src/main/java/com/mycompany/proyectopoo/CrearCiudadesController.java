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
import modelo.Auspiciante;
import modelo.Ciudad;

/**
 *
 * @author user
 */
public class CrearCiudadesController implements Initializable {
    @FXML
    private Label lbTitulo;
    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox cmbProvincia;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Label lbCod;
    @FXML
    Button Bguardar;
    @FXML
    Button BotonGeditar;
    @FXML
    private TextField txtProvincia;
    @FXML
    private Label lbtxtprov;
    @FXML
    private Label lbcmbprov;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        cmbProvincia.getItems().setAll(Ciudad.cargarProvincias2(App.rutciudades));
        
    }
    
    
    public void llenarCampos(Ciudad e){
        
        
        txtNombre.setText(e.getNombre());
        
        cmbProvincia.setValue(e.getProvincia());
        txtCodigo.setEditable(false);
        txtCodigo.setText(e.getCodigo());
        Bguardar.setVisible(false);
        txtCodigo.setVisible(false);
        lbCod.setVisible(false);
        lbtxtprov.setVisible(false);
        txtProvincia.setVisible(false);
        lbTitulo.setText("Editar Ciudad");
    }
    
    
    public void llenarcampos2(){
      lbTitulo.setText("Agregar Ciudad");
      BotonGeditar.setVisible(false);
      txtCodigo.setVisible(false);
      lbCod.setVisible(false);
      lbcmbprov.setVisible(false);
      cmbProvincia.setVisible(false);
      
    }
    
    @FXML
    private void editarCiudad() {
        ArrayList<Ciudad> ciudades = Ciudad.cargarCiudades2(App.rutciudades);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < ciudades.size(); x++) {
            if (ciudades.get(x).getCodigo().equals(txtCodigo.getText())){
                ciudades.get(x).setNombre(txtNombre.getText());
                ciudades.get(x).setProvincia((String)cmbProvincia.getValue() );
            }

        }
        
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutciudades))){
            out.writeObject(ciudades);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cambios guardados exitosamente");

            alert.showAndWait();
            App.setRoot("Administrar ciudades");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

    }
    
    
    @FXML
    private void guardarCiudad() {
        ArrayList<Ciudad> ciudades = Ciudad.cargarCiudades2(App.rutciudades);//cargar la lista del archivo
        System.out.println("Guardando Dueno");
        Ciudad d= new Ciudad(txtNombre.getText(),txtProvincia.getText());
        String cod= d.generarCodigo(txtNombre.getText(),txtProvincia.getText() );
       Ciudad D= new Ciudad(txtNombre.getText(),txtProvincia.getText(),cod);
      
        ciudades.add(D);
        
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutciudades))){
            out.writeObject(ciudades);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva Ciudad agregada exitosamente");

            alert.showAndWait();
            App.setRoot("Administrar ciudades");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    
    }
    
    
  @FXML
  private void switchToAdministrar(ActionEvent event) throws IOException {
        App.setRoot("Administrar ciudades");
       
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
