module com.example.concurrencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.concurrencia to javafx.fxml;
    exports com.example.concurrencia;
}