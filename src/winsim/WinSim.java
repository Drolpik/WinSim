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
import javafx.scene.input.KeyCombination;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
//import login.LoginController;

import desktop.DesktopController;

/**
 *
 * @author 
 */
public class WinSim extends Application {

    
    
    
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Stage desktopStage = new Stage();
        desktopStage.initStyle(StageStyle.UNDECORATED);
        Parent dekstopRoot = FXMLLoader.load(getClass().getResource("/desktop/desktop.fxml"));
        
        Scene desktopScene = new Scene(dekstopRoot);
        
        
        
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getBounds();
        javafx.geometry.Rectangle2D bounds2 = screen.getVisualBounds();
        
        
       

        desktopStage.setX(bounds.getMinX());
        desktopStage.setY(bounds.getMinY());
        desktopStage.setWidth(bounds.getWidth());
        desktopStage.setHeight(bounds.getHeight());
        


        desktopStage.setScene(desktopScene);
        desktopStage.show();
        
        
  
        
        
        
        
        
        
        
        
        
      
      
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
