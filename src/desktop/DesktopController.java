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
            
   /* @FXML
    private void changeClass(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       label.setText("Clicked");
       //btn.getStyleClass().add("pressed");
       Button b = (Button)event.getSource();
       b.getStyleClass().add("pressed");
       //btn.setStyle("-fx-padding: 2 0 0 2;");
       
       
    }*/
    

    
    public void show() {
        gp01.setOpacity(1.);
    }
    
    public void rmfoc() {
        
        this.w.setFocused(true);
    }
    
    public Window w;
    
    public void setw(Window w) {this.w = w;}
    
    /*@FXML
    private void changeBack(Event event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
       label.setText("WOW");
       //btn.getStyleClass().remove(1);
       //btn.getStyleClass().removeAll(new ArrayList<>("pressed"));
       
       Button b = (Button)event.getSource();
       
       b.getStyleClass().removeAll("pressed");
       b.getStyleClass().removeAll("default");
       
    }*/
    
    @FXML
    private void closeApp() {
        
        Platform.exit();
    }
    @FXML
    private void showStartMenu(Event e) throws IOException {
        
        //stage2.toFront();
    }
    
   @FXML
   private void launchCalc() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/calc/calc.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage1 = new Stage();
    stage1.initStyle(StageStyle.UNDECORATED);
    stage1.setScene(new Scene(root1));  
    stage1.show();
   }
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
