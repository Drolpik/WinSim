/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winsim;

import java.awt.geom.Rectangle2D;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 
 */
public class WinSim extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        
        
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getBounds();
       

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        //stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.setScene(new Scene(root1));  
        
        
        stage1.setX(bounds.getMinX());
        stage1.setY(bounds.getMinY());
        stage1.setWidth(bounds.getWidth());
        stage1.setHeight(bounds.getHeight());
        
        
        stage1.show();   
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
