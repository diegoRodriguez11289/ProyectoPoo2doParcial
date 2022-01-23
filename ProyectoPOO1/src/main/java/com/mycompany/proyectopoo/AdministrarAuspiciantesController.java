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
import modelo.DueñoDeMascota;

/**
 *
 * @author user
 */
public class AdministrarAuspiciantesController implements Initializable {
    
    @FXML
    private TableView<Auspiciante> tvAuspiciante;
    @FXML
    private TableColumn<Auspiciante, String> colCod;
    @FXML
    private TableColumn<Auspiciante, String> colNombre;
    @FXML
    private TableColumn<Auspiciante, String> colWebPage;
    @FXML
    private TableColumn<Auspiciante, String> colDireccion;
    @FXML
    private TableColumn<Auspiciante, String> colTelefono;
    @FXML
    private TableColumn<Auspiciante, String> colCiudad;
    @FXML
    private TableColumn<Auspiciante, Void> colOp;
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //To change body of generated methods, choose Tools | Templates.
        colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colWebPage.setCellValueFactory(new PropertyValueFactory<>("webpage"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        agregarOpciones();
        tvAuspiciante.getItems().setAll(Auspiciante.cargarAuspiciantes2(App.rutAuspiciantes));
        //tvAuspiciante.getItems().get(0)
    }
    
    @FXML
    private void switchToMenuPincipal(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
    }
    
    private void agregarOpciones() {

        Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>> cellFactory = new Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>>() {
            @Override
            public TableCell<Auspiciante, Void> call(final TableColumn<Auspiciante, Void> param) {
                TableCell<Auspiciante, Void> cell = new TableCell<Auspiciante, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            Auspiciante au = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->editarauspiciante(au));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e ->eliminarAuspiciante(au));
                            
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
    private void switchToAgregarAuspiciantes(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EditarAuspiciante.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            EditarAuspicianteController ct = fxmlLoader.getController();
            
            //ct.llenarCombo(Ciudad.cargarCiudades(App.rutciudades));
            ct.llenarcampos2();
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
    
    private void editarauspiciante(Auspiciante e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EditarAuspiciante.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            EditarAuspicianteController ct = fxmlLoader.getController();
            
            
            ct.llenarCampos(e);
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void eliminarAuspiciante(Auspiciante e) {
                    //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Eliminar datos");
            alert.setContentText("¿Esta seguro de eliminar este Auspiciante ?");

            Optional <ButtonType> action = alert.showAndWait();
            if (action.get()== ButtonType.OK){
                tvAuspiciante.getItems().removeAll(e);
                ArrayList<Auspiciante> auspiciantes = Auspiciante.cargarAuspiciantes2(App.rutAuspiciantes);//cargar la lista del archivo
                System.out.println("Guardando sus cambios");
                for (int x = 0; x < auspiciantes.size(); x++) {
                    if (auspiciantes.get(x).getCodigo().equals(e.getCodigo())){
                     auspiciantes.remove(x);
                     System.out.println("se elimino");
                
                    }
               
                }
        
               try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutAuspiciantes))){
               out.writeObject(auspiciantes);
               out.flush();
               App.setRoot("AdministrarAuspiciantes");

               } catch (IOException ex) {
                 System.out.println("IOException:" + ex.getMessage());
               } 
            
            
            }
        

        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
