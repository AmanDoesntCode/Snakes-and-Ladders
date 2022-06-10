module com.example.snakesladders {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakesladders to javafx.fxml;
    exports com.example.snakesladders;
}