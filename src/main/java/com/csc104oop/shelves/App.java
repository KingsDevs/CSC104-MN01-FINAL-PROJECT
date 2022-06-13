package com.csc104oop.shelves;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static String getApplicationPath() throws IOException
    {
        String path = new File(".").getCanonicalPath();
        System.out.println(path);
        return path;
    }

    public static URL loadFxml(String fxmlName)
    {
        URL fileUrl = App.class.getResource(fxmlName + ".fxml");
        return fileUrl;
        
    }

    public static void main(String[] args) throws IOException
    {
        try {
            ConnectDb.getStatement();
            launch();
        } catch (SQLException e) {
            
        }
        
        
    }

}