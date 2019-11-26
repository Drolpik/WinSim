package Logowanie;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginInController implements Initializable 
{
    @FXML
    private TextField login;
    
    @FXML
    private TextField haslo;
    
    @FXML
    private Label lblStatus;
    
    //metoda do zmiany na scene glowna
    @FXML
    private void Login(ActionEvent event) throws IOException
    {
        if(login.getText().equals("user") && haslo.getText().equals("123"))
        {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/winsim/FXMLDocument.fxml"));
            Scene scenaLogowania = new Scene(tableViewParent);
            
            Stage noweOkno = (Stage)((Node)event.getSource()).getScene().getWindow();
            noweOkno.setScene(scenaLogowania);
            //okno.setFullScreen(true);
            noweOkno.show();
        }
        else
        {
            lblStatus.setText("Logowanie niepomyślne!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
