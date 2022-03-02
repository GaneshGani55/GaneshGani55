package com.ganeshprasadd.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

//        MenuBar menuBar = createMenu();
////        rootNode.getChildren().addAll(menuBar);//just adds menu bar within the vbox
//        rootNode.getChildren().add(0,menuBar);//adds menu bar to the vbox at 0th index i.e., at the top

        Scene scene = new Scene(rootNode, 300, 275);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    private MenuBar  createMenu(){
        //File Menu
        Menu fileMenu = new Menu("File");
            // with in the fileMenu
        MenuItem newMenuItem = new MenuItem("New");
                //Click event for newMenuItem
        //when File is clicked this method is executed, Lamda Expression
        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));//when File is clicked this method is executed

//        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {//when File is clicked this method is executed, with out lamda
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("New Menu Item Clicked");
//            }
//        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();//Separates the two menu items by a line

        MenuItem quitMenuItem = new MenuItem("Quit");
        //when quitMenu is clicked
        quitMenuItem.setOnAction(actionEvent -> {//this is lamda expression
            Platform.exit();//Shutdowns the current application
            System.exit(0);//shutdown the current virtual machine
        });

//        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Platform.exit();//Shutdowns the current application
//                System.exit(0);//shutdown the current virtual machine
//            }
//        });

                // add these to fileMenu
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);


        //Help Menu
        Menu helpMenu = new Menu("Help");
           // with in the helpMenu
        MenuItem aboutApp = new MenuItem("About");
        
        aboutApp.setOnAction(actionEvent -> {
            aboutApp();// executes this method when about is clicked
        });

        helpMenu.getItems().addAll(aboutApp);

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        //Alert Dialog--> whenever a menu or any thing is clicked, This code is used to display alert dialog
        Alert alertDialog= new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Dekstop Applicatio");
        alertDialog.setHeaderText("Learning Java Fx");
        alertDialog.setContentText("I am just a beginner but soon i will be a pro");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);//adding buttons to alert
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);//adding buttons to alert Dialog

//        alertDialog.show();  //This method only shows alert Dialog

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();//showAndWait method returns which button clicked

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes btn clicked");
            // we can write our own code, like what should happen when yes btn is clicked
        }
        if (clickedBtn.isPresent() && clickedBtn.get() == noBtn){
            System.out.println("No btn Clicked!");
        }
    }
}
