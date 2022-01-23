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
import javafx.collections.ObservableList;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.DueñoDeMascota;
import modelo.Mascota;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrarMascotasController implements Initializable {
    
    @FXML
    private TableView<Mascota> tvMascotas;
    @FXML
    private TableColumn colCod;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TableColumn colDueno;
    @FXML
    private TableColumn colOp;
    
    private ObservableList<Mascota> mascota;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        //mascota = FXCollections.observableArrayList();    

        this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.colDueno.setCellValueFactory(new PropertyValueFactory<>("duenoNombre"));
        //agregarOpciones();
        //mascota.addAll(Mascota.cargarMascotas(App.rutMascotas));
        //tvMascotas.setItems(mascota);
        tvMascotas.getItems().setAll(Mascota.cargarMascotas(App.rutmascotascsv));
        
        
        //tvDueños.getItems().setAll(Administrar.crearListaDueños());

        // TODO
    }   
    
@FXML
private void agregarOpciones() {

        Callback<TableColumn<Mascota, Void>, TableCell<Mascota, Void>> cellFactory = new Callback<TableColumn<Mascota, Void>, TableCell<Mascota, Void>>() {
            @Override
            public TableCell<Mascota, Void> call(final TableColumn<Mascota, Void> param) {
                TableCell<Mascota, Void> cell = new TableCell<Mascota, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            Mascota due = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->editarMascota(due));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e ->eliminarMascota(due));
                            
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

        private void editarMascota(Mascota e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EditarMascotas.fxml"));
            

            

            VBox root = (VBox) fxmlLoader.load();
            EditarMascotaController ct = fxmlLoader.getController();
            
            ct.llenarCombo(DueñoDeMascota.cargarDuenos(App.rutDuenoscsv));
            ct.llenarCampos(e);
            
            
            
            

            
            
            App.changeRoot(root);
            System.out.println("hola");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void eliminarMascota(Mascota e) {
        tvMascotas.getItems().removeAll(e);
        ArrayList<Mascota> mascotas = Mascota.cargarMascotas(App.rutmascotascsv);//cargar la lista del archivo
        System.out.println("Guardando sus cambios");
        for (int x = 0; x < mascotas.size(); x++) {
            if (mascotas.get(x).getCodigo().equals(e.getCodigo())){
                mascotas.remove(x);
                
            }
               
        }
        
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutMascotas))){
            out.writeObject(mascotas);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Mascota eliminada de la base de datos");

            alert.showAndWait();
            App.setRoot("AdministrarMascotas");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 

        
    }
    
    
  
    
   @FXML
   private void switchToSecondary() throws IOException{
    App.setRoot("secondary");
   }
    
    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("MenuPrincipal");
        /*
        Parent menuParent =  FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene menu = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
        */
    }
    @FXML
    private void switchToAgregarMascota(ActionEvent event) throws IOException {
        App.setRoot("AgregarMascota");
        /*
        Parent menuParent =  FXMLLoader.load(getClass().getResource("AgregarMascota.fxml"));
        Scene menu = new Scene(menuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menu);
        window.show();
        */
    }
    
    
    
    
    
    
}
