package calc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CalcController implements Initializable {
    
    @FXML
    private Label action_label;
    @FXML
    private Label solution;
    
    @FXML
    private Stage stage;
    
    private double xOffset;
    private double yOffset;
    
    private float number1 = 0;
    private float number2 = 0;
    private String operator = "";
    
    @FXML
    private void number_click(ActionEvent event) 
    {
        String value = ((Button)event.getSource()).getText();
        String old_value = solution.getText(); 
        solution.setText(old_value + value);
    }
    
    @FXML
    private void operator_click(ActionEvent event)
    {
        String value = ((Button)event.getSource()).getText();
        String old_value = solution.getText();
        long value_number = Long.parseLong(old_value);
        this.number1 = value_number;
        solution.setText("");
        action_label.setText(old_value + value);
        this.operator = value;
    }
    
    @FXML
    private void clear_click(ActionEvent event)
    {
        action_label.setText("");
        solution.setText("");
        this.number1 = 0;
        this.number1 = 0;
    }
    
    @FXML
    private void equal_click(ActionEvent event)
    {
        switch(operator)
        {
            case "+":
                String value_plus = solution.getText();
                this.number2 = Long.parseLong(value_plus);
                float result_plus = this.number1 + this.number2;
                solution.setText(String.valueOf(result_plus));
                String old_value_plus = action_label.getText();
                action_label.setText(old_value_plus + value_plus);
                break;
                
            case "-":
                String value_minus = solution.getText();
                this.number2 = Long.parseLong(value_minus);
                float result_minus = this.number1 - this.number2;
                solution.setText(String.valueOf(result_minus));
                String old_value_minus = action_label.getText();
                action_label.setText(old_value_minus + value_minus);
                break;
                
             case "/":
                 /*if(this.number2 == 0)
                 {
                     System.out.println("Error, division by zero!");
                     solution.setText("0");
                 }*/
                String value_dash = solution.getText();
                this.number2 = Long.parseLong(value_dash);
                float result_dash = this.number1 / this.number2;
                solution.setText(String.valueOf(result_dash));
                String old_value_dash = action_label.getText();
                action_label.setText(old_value_dash + value_dash);
                     break;
                
            case "*":
                String value_multi = solution.getText();
                this.number2 = Long.parseLong(value_multi);
                float result_multi = this.number1 * this.number2;
                solution.setText(String.valueOf(result_multi));
                String old_value_multi = action_label.getText();
                action_label.setText(old_value_multi + value_multi);
                break;
        }
    }
    
    
    
    public void setStage(Stage stage)
    {
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
        
        @FXML
    private void closeApp() throws InterruptedException {
        Stage stage = (Stage) action_label.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
