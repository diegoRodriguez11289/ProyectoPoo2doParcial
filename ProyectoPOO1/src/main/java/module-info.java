module com.mycompany.proyectopoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectopoo to javafx.fxml;
    exports com.mycompany.proyectopoo;
}
