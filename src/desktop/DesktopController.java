/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;


import winsim.WinSim;




/**
 *
 * @author 
 */
public class DesktopController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button btn;
    
    @FXML
    public GridPane gp01;
            
   

    
    
    
    
    
    public Window w;
    
    //public void setw(Window w) {this.w = w;}
    
    /**
     * function which terminates the entire project
     */
    @FXML
    private void closeApp() {
        
        Platform.exit();
    }
    
    
    /**
     * function which loads the Calculator subapp
     * @throws IOException 
     */
   @FXML
  private void loadCalc() throws IOException {
      FXMLLoader calcLoader = new FXMLLoader(getClass().getResource("/calc/calc.fxml"));
        Parent calcRoot = (Parent) calcLoader.load();
        Stage calcStage = new Stage();
        calcStage.initStyle(StageStyle.UNDECORATED);
        calcStage.setScene(new Scene(calcRoot));
        
        calcStage.show();
        
        ((calc.CalcController) calcLoader.getController()).setStage(calcStage);
  }
  
  /**
     * function which loads the Media Player subapp
     * @throws IOException 
     */
   @FXML
  private void loadPlayer() throws IOException {
      FXMLLoader playerLoader = new FXMLLoader(getClass().getResource("/player/player.fxml"));
        Parent playerRoot = (Parent) playerLoader.load();
        Stage playerStage = new Stage();
        playerStage.initStyle(StageStyle.UNDECORATED);
        playerStage.setScene(new Scene(playerRoot));
        
        playerStage.show();
        
        ((player.PlayerController) playerLoader.getController()).setStage(playerStage);
  }
   
  /**
     * function which loads the Web Browser subapp
     * @throws IOException 
     */
   @FXML
           private void loadBrowser() throws IOException {
        FXMLLoader browserLoader = new FXMLLoader(getClass().getResource("/browser/browser.fxml"));
        Parent browserRoot = (Parent) browserLoader.load();
        Stage browserStage = new Stage();
        browserStage.initStyle(StageStyle.UNDECORATED);
        browserStage.setScene(new Scene(browserRoot));
        
        browserStage.show();
        
        ((browser.BrowserController) browserLoader.getController()).setStage(browserStage);
           }
           
           
           
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
