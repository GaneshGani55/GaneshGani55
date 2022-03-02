module com.ganeshprasadd.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ganeshprasadd.javafxapp to javafx.fxml;
    exports com.ganeshprasadd.javafxapp;
}