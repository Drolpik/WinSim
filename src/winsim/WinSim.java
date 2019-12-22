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
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/desktop/desktop.fxml"));
        
        Scene scene = new Scene(root);
        
        
        
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getBounds();
        javafx.geometry.Rectangle2D bounds2 = screen.getVisualBounds();
        
        
       

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        
        //double xB = stage.getScene().getWindow().getX();
        //double yB = stage.getScene().getWindow().getY();
        
        //Window window = stage.getScene().getWindow();
        
        //stage.setFullScreen(true);
        
        //stage.setFullScreenExitHint(null);
        //stage.setFullScreenExitKeyCombination(KeyCombination.);

        stage.setScene(scene);
        stage.show();
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        //stage1.setFullScreen(true);
        //stage1.setFullScreenExitHint("HEHEHEHEHE");
        
        //FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/start/start.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/calc/calc.fxml"));

        Parent root2 = (Parent) fxmlLoader2.load();
        Stage stage2 = new Stage();
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(new Scene(root2));
        
        stage2.show();

        
        //stage2.setY((double) bounds.getHeight() - stage2.getHeight() - 37.);
        stage2.setX(200);
        stage2.setY(200);
        
                
        ((login.LoginController) fxmlLoader.getController()).setStage(stage1);
        //private Rectangle tb = login.LoginController.tbar;
        
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.setScene(new Scene(root1));
        
        
        //System.out.println("bounds: "+bounds.getHeight());
        //System.out.println("stage: "+stage2.getHeight());
        
        /*stage1.setX(bounds.getMinX());
        stage1.setY(bounds.getMinY());
        stage1.setWidth(bounds.getWidth());
        stage1.setHeight(bounds.getHeight());*/
        
        //stage1.setFocused(false);
        
        stage1.show();
        
        Window w1;
        w1 = (Window) stage1.getScene().getWindow();
        
        //FXMLLoader l1 = new FXMLLoader(getClass().getResource("/winsim/FXMLDocument.fxml"));
       // ((winsim.FXMLDocumentController) l1.getController()).setw(w1);

        
        
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
