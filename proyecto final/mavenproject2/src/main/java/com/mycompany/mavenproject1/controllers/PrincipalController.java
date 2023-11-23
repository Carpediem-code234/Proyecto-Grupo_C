/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1.controllers;

import com.mycompany.mavenproject1.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author camilo
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btncompra;
    @FXML
    private Button btnStock;
    @FXML
    private Button btnventa;
    
    @FXML
    private StackPane panelOpciones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    public void eventActionBtnRegistroP(ActionEvent event) throws IOException {
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("IngresarProducto"));
        this.panelOpciones.getChildren().add(pane);
       
    }

    @FXML
    public void eventActionBtnConsultaStock(ActionEvent event) throws IOException {
       this.panelOpciones.getChildren().clear();
       StackPane pane = new StackPane(App.loadFXML("InformeStock"));
       this.panelOpciones.getChildren().add(pane);
    }

    @FXML
    public void eventActionBtnRegistrarVenta(ActionEvent event) {
        System.out.println("venta");
    }
    
}
