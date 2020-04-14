package browser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class BrowserController implements Initializable 
{

    @FXML
    private WebView webView;
    
    @FXML
    private TextField address;
    
    
    private WebEngine web_engine;
    /**
     * variable which storing name of the http link
     */
    private String http_link = "https://";
    /**
     * variable used to display the http link in the search area
     */
    private String address_link;
    
    @FXML
    private Label action_label;
    
    /**
     * variables storing cursor position on screen while moving the title bar
     */
    private double xOffset, yOffset;
    
    @FXML
    private Stage stage;
    
    @FXML
    public Rectangle tbar;
    
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
    
    /**
     * function which allows to load a home page
     * @param event 
     */
    @FXML
    private void load_homePage(ActionEvent event)
    {
        web_engine.load("https://www.google.com");
    }
    
    /**
     * function which allows to refresh a page
     * @param event 
     */
    @FXML
    private void refresh(ActionEvent event)
    {
        web_engine.reload();
    }
    
    /**
     * function which allows to load a page entered by the user
     * @param event 
     */
    @FXML
    private void go(ActionEvent event)
    {
        address_link = address.getText().toString();
        web_engine.load(http_link + address_link);
    }
    
    /**
     * function which allows to back the page 
     * @param event 
     */
    @FXML
    private void back(ActionEvent event)
    {
        web_engine.getHistory().go(-1);
    }
    
    /**
     * function which allows to forward the page
     * @param event 
     */
    @FXML
    private void forward(ActionEvent event)
    {
        web_engine.getHistory().go(1);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        web_engine = webView.getEngine();
        web_engine.load(http_link + "www.google.com");
        address.setText(web_engine.getLocation());
        
        web_engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event)
            {
                address.setText(web_engine.getLocation());
            }
        });
    }    
}
