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
 * @author Konrad
 */





public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    //@FXML
    
    private double xOffset = 0;
    private double yOffset = 0;

  
    
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
    
    //Stage stage = (Stage) tbar.getScene().getWindow();
    
    public void setStage(Stage stage){
this.stage=stage;
}
    
   @FXML
    private void clicked(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
            //login.setPromptText(String.valueOf(xOffset));
            //login.setPromptText(Double.toString(xOffset));
            //pwd.setPromptText(Double.toString(yOffset));
        }
    
   /* @FXML
    private void dragged(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
             login.setPromptText(Double.toString(xOffset));
            pwd.setPromptText(Double.toString(yOffset));
        }*/
   
        @FXML
        private void dragged(MouseEvent event) {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }
    
        
    
    
    private DesktopController c1;
    
   
   @FXML
   private void log_in(ActionEvent event) throws Exception {
       //if(login.getText().equals("user") && pwd.getText().equals("123")) {
       if(!login.getText().isEmpty())
           ((Node)(event.getSource())).getScene().getWindow().hide();
           //c1.show();
           
           
       //}
   }
            
   /* @FXML
    private void changeClass(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       //label.setText("Clicked");
       //btn.getStyleClass().add("pressed");
       Button b = (Button)event.getSource();
       b.getStyleClass().add("pressed");
       //btn.setStyle("-fx-padding: 2 0 0 2;");
       
       
    }*/
    
    /*@FXML
    private void changeBack(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       //label.setText("WOW");
       //btn.getStyleClass().remove(1);
       //btn.getStyleClass().removeAll(new ArrayList<>("pressed"));
       
       Button b = (Button)event.getSource();
       
       b.getStyleClass().removeAll("pressed");
       b.getStyleClass().removeAll("default");
       
    }*/
    
    @FXML
    private void closeApp() throws InterruptedException {
        Thread.sleep(1000);
        Platform.exit();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
