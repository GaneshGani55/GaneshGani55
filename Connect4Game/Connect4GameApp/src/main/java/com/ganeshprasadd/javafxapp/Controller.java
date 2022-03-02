// we create this class to write logical code

package com.ganeshprasadd.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // We need to give id to the control icons added in the pane or vbox and decalre them here with same id
    @FXML
    public Pane myPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


}
