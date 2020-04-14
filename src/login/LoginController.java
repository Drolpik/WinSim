/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import winsim.WinSim;
import desktop.DesktopController;


/**
 * FXML Controller class
 *
 * @author 
 */

public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    //@FXML
    
   /**
     * variables storing cursor position on screen while moving the title bar
     */
    private double xOffset, yOffset;

  
    
    @FXML
    private Button exit_btn;
    
    @FXML
    private Button log;
    
    @FXML
    private TextField login;
    
    @FXML
    private PasswordField pwd;
    
    //@FXML
    public Rectangle tbar;
    
    
    private Stage stage;
    
    /**
     * function needed to pass the Stage object to the controller from the main project file
     * @param stage 
     */
    public void setStage(Stage stage)
    {
        this.stage=stage;
    }
    
    /**
     * function handling the click event on the title bar
     * @param event 
     */
   @FXML
    private void clicked(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
    
   /**
    * function handling the drag event on the title bar
    * this function moves the window around with the mouse cursor
    * @param event 
    */
        @FXML
        private void dragged(MouseEvent event) {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }
    
        /**
         * function which closes the current app window
         * @throws InterruptedException 
         */
        @FXML
    private void closeApp() throws InterruptedException {
        Stage stage = (Stage) tbar.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    
    
    
    private DesktopController c1;
    
   /**
    * function which allows to log in
    * @param event
    * @throws Exception 
    */
   @FXML
   private void log_in(ActionEvent event) throws Exception {
       //if(login.getText().equals("user") && pwd.getText().equals("123")) {
       if(!login.getText().isEmpty())
           ((Node)(event.getSource())).getScene().getWindow().hide();
           //c1.show();
           
           
       //}
   }
            


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
