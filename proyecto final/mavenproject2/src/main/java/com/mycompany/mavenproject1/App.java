package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void newStage(String fxml, boolean modo, int w, int h) throws IOException{
        
        Window window = scene.getWindow();
        Stage actual = (Stage)window;
        
        if(modo){
            actual.hide();
        }
        
        Parent rootNode = loadFXML(fxml);
        scene = new Scene(rootNode);
        
        Stage nueva = new Stage();
        nueva.setScene(scene);
        nueva.setWidth(w);
        nueva.setHeight(h);
        nueva.centerOnScreen();
        nueva.setTitle("SIPCF - Software Inventariado Proctos Canasta Familiar V1");
        nueva.setFullScreen(true);
        nueva.show();

    }
    
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }

}