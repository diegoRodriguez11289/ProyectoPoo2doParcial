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

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.DueñoDeMascota;
import modelo.Administrar;
import modelo.Ciudad;
/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrarDueñosController implements Initializable {


    @FXML
    private Button rdueños;
    @FXML
    private TableView<DueñoDeMascota> tvDueños;
    @FXML
    private TableColumn<DueñoDeMascota, String> colCod;
    @FXML
    private TableColumn<DueñoDeMascota, String> colNombre;
    @FXML
    private TableColumn<DueñoDeMascota, String> colApellidos;
    @FXML
    private TableColumn<DueñoDeMascota, String> colDireccion;
    @FXML
    private TableColumn<DueñoDeMascota, String> colTelefono;
    @FXML
    private TableColumn<DueñoDeMascota, String> colCiudad;
    @FXML
    private TableColumn<DueñoDeMascota, Void> colOp;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCod.setCellValueFactory(new PropertyValueFactory<>("ci"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        agregarOpciones();
        
        
        //tvDueños.getItems().setAll(Administrar.crearListaDueños());
        tvDueños.getItems().setAll(DueñoDeMascota.cargarDuenos2(App.rutDuenos));
    }    
    
    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
        /*
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        */
    }
    @FXML
    private void switchToAgregarDueño(ActionEvent event) throws IOException {
        App.setRoot("AgregarDueno");
        /*
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("AgregarDueno.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        */
    }
    /*
    private void switchToEditarDueño(ActionEvent event) throws IOException {
        Parent menuDueñosParent =  FXMLLoader.load(getClass().getResource("EditarDueño.fxml"));
        Scene menuDueño = new Scene(menuDueñosParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuDueño);
        window.show();
        
    }
    */
    
    private void agregarOpciones() {

        Callback<TableColumn<DueñoDeMascota, Void>, TableCell<DueñoDeMascota, Void>> cellFactory = new Callback<TableColumn<DueñoDeMascota, Void>, TableCell<DueñoDeMascota, Void>>() {
            @Override
            public TableCell<DueñoDeMascota, Void> call(final TableColumn<DueñoDeMascota, Void> param) {
                TableCell<DueñoDeMascota, Void> cell = new TableCell<DueñoDeMascota, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            DueñoDeMascota due = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->editardueno(due));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e ->eliminarDueno(due));
                            
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
    
        private void editardueno(DueñoDeMascota e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EditarDueno.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            EditarDueñoController ct = fxmlLoader.getController();
            
            ct.llenarCombo(Ciudad.cargarCiudades(App.rutciudades));
            ct.llenarCampos(e);
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void eliminarDueno(DueñoDeMascota e) {
        tvDueños.getItems().removeAll(e);
        ArrayList<DueñoDeMascota> dueños = DueñoDeMascota.cargarDuenos2(App.rutDuenos);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < dueños.size(); x++) {
            if (dueños.get(x).getCi().equals(e.getCi())){
                dueños.remove(x);
                
            }
               
        }
        
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutDuenos))){
            out.writeObject(dueños);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Dueño eliminado dela base de datos");

            alert.showAndWait();
            App.setRoot("AdministrarDuenos");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
