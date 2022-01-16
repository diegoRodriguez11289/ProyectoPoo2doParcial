module com.mycompany.proyectopoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectopoo to javafx.fxml;
    opens modelo to javafx.base;
    exports com.mycompany.proyectopoo;
}
