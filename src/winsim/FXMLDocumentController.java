/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winsim;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button btn;
    
    @FXML
    private GridPane gp;
            
    @FXML
    private void changeClass(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       label.setText("Clicked");
       //btn.getStyleClass().add("pressed");
       Button b = (Button)event.getSource();
       b.getStyleClass().add("pressed");
       //btn.setStyle("-fx-padding: 2 0 0 2;");
       
       
    }
    
    @FXML
    private void changeBack(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       label.setText("WOW");
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
