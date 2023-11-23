/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1.controllers;

import com.mycompany.mavenproject1.App;
import com.mycompany.mavenproject1.logica.Login;
import com.mycompany.mavenproject1.utility.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author camilo
 */
public class LoginController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button bntlogin;

//    @FXML
//    public void clickLogin(ActionEvent e)throws IOException{
//        String u = this.txtUsername.getText();
//        String p = this.txtPassword.getText();
//        
//        try{
//            try {
//                Login.validarLogin(u, p);
//            } catch (Exception ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            App.newStage("principal", true, 1300, 700);
//            
//        }catch(IllegalStateException ie){
//            Utility.notificarMensaje("Login no valido", "Sus credenciales de ingreso no son validas, intenete nuevamente", Alert.AlertType.NONE);
//        }
//            
//    }

    @FXML
    public void clickLogin(ActionEvent e) throws IOException {

        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();

        try {
            Login.validarLogin(username, password);
            App.newStage("principal", true, 854, 560);

        } catch (IllegalStateException ie) {

            Utility.notificarMensaje("Validacion campos vacios", ie.getMessage(), Alert.AlertType.ERROR);
//            this.txtUsername.setText(null);
//            this.txtPassword.setText(null);
//            this.txtUsername.requestFocus();
        } catch (Exception ie) {
            Utility.notificarMensaje("Validacion de login", ie.getMessage(), Alert.AlertType.ERROR);
//            this.txtUsername.setText(null);
//            this.txtPassword.setText(null);
//            this.txtUsername.requestFocus();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    @FXML
//    private void switchToLogin() throws IOException {
//        App.setRoot("login");
//    } 
}
