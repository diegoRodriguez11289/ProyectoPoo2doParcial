package com.mycompany.proyectopoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static String rutciudades = "com/mycompany/proyectopoo/files/ciudades.csv";
    public static String rutDuenoscsv = "com/mycompany/proyectopoo/files/duenosP4.csv";
    public static String rutDuenos = "Archivos/Duenos.ser";
    public static String rutAuspiciantes = "Archivos/Auspiciantes.ser";
    public static String rutAuspiciantescsv = "com/mycompany/proyectopoo/files/auspiciantes.csv";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MenuPrincipal"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    
    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static FXMLLoader loadFXMLLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/mycompany/proyectopoo/" + fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
    }
    
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }
    
    
    

}