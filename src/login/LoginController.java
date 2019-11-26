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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import winsim.FXMLDocumentController;


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
    
  
    
    @FXML
    private Button exit_btn;
    
    @FXML
    private Button log;
    
    @FXML
    private TextField login;
    
    @FXML
    private PasswordField pwd;
    
    private FXMLDocumentController c1;
    
   
   @FXML
   private void log_in(ActionEvent event) throws Exception {
       if(login.getText().equals("user") && pwd.getText().equals("123")) {
           ((Node)(event.getSource())).getScene().getWindow().hide();
           c1.show();
       }
   }
            
    @FXML
    private void changeClass(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       //label.setText("Clicked");
       //btn.getStyleClass().add("pressed");
       Button b = (Button)event.getSource();
       b.getStyleClass().add("pressed");
       //btn.setStyle("-fx-padding: 2 0 0 2;");
       
       
    }
    
    @FXML
    private void changeBack(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       //label.setText("WOW");
       //btn.getStyleClass().remove(1);
       //btn.getStyleClass().removeAll(new ArrayList<>("pressed"));
       
       Button b = (Button)event.getSource();
       
       b.getStyleClass().removeAll("pressed");
       b.getStyleClass().removeAll("default");
       
    }
    
    @FXML
    private void closeApp() {
        Platform.exit();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
