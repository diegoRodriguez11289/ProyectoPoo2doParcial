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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import modelo.Auspiciante;
import modelo.Ciudad;
/**
 *
 * @author user
 */




public class AdministrarCiudadesController implements Initializable {
    @FXML
    private TableView<Ciudad> tvCiudad;
    @FXML
    private TableColumn<Ciudad, String> colCod;
    @FXML
    private TableColumn<Ciudad, String> colNombre;
    @FXML
    private TableColumn<Ciudad, String> colProvincia;
    @FXML
    private TableColumn<Ciudad, Void> colOp;
    
    
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colProvincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
        agregarOpciones();
        
        tvCiudad.getItems().setAll(Ciudad.cargarCiudades2(App.rutciudades));
        
    }
    
    
    
    @FXML
    private void switchToMenuPincipal(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
    
    
    private void agregarOpciones() {

        Callback<TableColumn<Ciudad, Void>, TableCell<Ciudad, Void>> cellFactory = new Callback<TableColumn<Ciudad, Void>, TableCell<Ciudad, Void>>() {
            @Override
            public TableCell<Ciudad, Void> call(final TableColumn<Ciudad, Void> param) {
                TableCell<Ciudad, Void> cell = new TableCell<Ciudad, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            Ciudad au = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->editarciudad(au));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e ->eliminarCiudad(au));
                            
                            //se agregan botones al hbox
                            hbOpciones.getChildren().addAll(btnEd,btnEl);
                            //se ubica hbox en la celda
                            setGraphic(hbOpciones);
                        }
                    }
                };
                return cell;
            }
        };

        colOp.setCellFactory(cellFactory);

    }
    
    @FXML
    private void switchToAgregarCiudades(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearCiudades.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            CrearCiudadesController ct = fxmlLoader.getController();
            
            //ct.llenarCombo(Ciudad.cargarCiudades(App.rutciudades));
            ct.llenarcampos2();
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
    
    
        private void editarciudad(Ciudad e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearCiudades.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            CrearCiudadesController ct = fxmlLoader.getController();
            
            
            ct.llenarCampos(e);
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void eliminarCiudad(Ciudad e) {
                    //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Eliminar datos");
            alert.setContentText("¿Esta seguro de eliminar esta ciudad ?");

            Optional <ButtonType> action = alert.showAndWait();
            if (action.get()== ButtonType.OK){
                tvCiudad.getItems().removeAll(e);
                ArrayList<Ciudad> ciudades = Ciudad.cargarCiudades2(App.rutciudades);//cargar la lista del archivo
                System.out.println("Guardando sus cambios");
                for (int x = 0; x < ciudades.size(); x++) {
                    if (ciudades.get(x).getCodigo().equals(e.getCodigo())){
                     ciudades.remove(x);
                     System.out.println("se elimino");
                
                    }
               
                }
        
               try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutciudades))){
               out.writeObject(ciudades);
               out.flush();
               App.setRoot("Administrar ciudades");

               } catch (IOException ex) {
                 System.out.println("IOException:" + ex.getMessage());
               } 
            
            
            }
        

        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        
        
        
        
        
        
    
}
