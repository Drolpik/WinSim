package player;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayerController implements Initializable 
{
    /**
     * variable which stores the path name
     */
    private String filePath;
    /**
     * variable which stores the file name
     */
    private String f_name;
    /**
     * variable that stores the value of the counter
     */
    private int counter = 0;
    
    @FXML
    private MediaView media_view;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Label file_name;
    @FXML
    private Slider time_slider;
    
    private MediaPlayer media_player;
    private Media media;
    
    @FXML
    private Stage stage;
    
    @FXML
    private Label action_label;

    
    @FXML
    public Rectangle tbar;
    
    /**
     * variables storing cursor position on screen while moving the title bar
     */
    private double xOffset, yOffset;
    
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
     * function which plays current video or music
     * @param event 
     */
    @FXML
    private void play(ActionEvent event)
    {
        try
        {
            media_player.play();
            media_player.setRate(1);
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while playing the file");
        }
    }
    
    /**
     * function which pauses current video or music
     * @param event 
     */
    @FXML
    private void pause(ActionEvent event)
    {
        try
        {
            media_player.pause();
        }
        catch(Exception e)
        {
           System.out.println("Error, something went wrong while pausing the file"); 
        }
    }
    
    /**
     * function which fast (rate 1.5) current video or music
     * @param event 
     */
    @FXML
    private void fast(ActionEvent event)
    {
        try
        {
            media_player.setRate(1.5);
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while speeding up the file");
        }
    }
    
    /**
     * function which fast (rate 2) current video or music
     * @param event 
     */
    @FXML
    private void faster(ActionEvent event)
    {
        try
        {
            media_player.setRate(2);
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while speeding up the file");
        }
    }
    
    /**
     * function which slows (rate 0.7) current video or music
     * @param event 
     */
    @FXML
    private void slow(ActionEvent event)
    {
        try
        {
            media_player.setRate(0.7);
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while slowing the file");
        }
    }
    
    /**
     * function which slows (rate 0.5) current video or music
     * @param event 
     */
    @FXML
    private void slower(ActionEvent event)
    {
        try
        {
            media_player.setRate(0.5);
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while slowing the file");
        }
    }
    
    /**
     * function which stops current video or music
     * @param event 
     */
    @FXML
    private void stop(ActionEvent event)
    {
        try
        {
            media_player.seek(media_player.getStartTime());
            media_player.stop();
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while starting the file");
        }
    }
    
    /**
     * function which allows to open video or music
     * @param event 
     */
    @FXML
    private void open_movie(ActionEvent event)
    {
        try
        {
            this.counter += 1;
            if(counter >= 2)
                media_player.pause();

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");     
            fileChooser.getExtensionFilters().addAll(
             new ExtensionFilter("mp4 files", "*.mp4"),
             new ExtensionFilter("mp3 files", "*.mp3"));

            File file = fileChooser.showOpenDialog(null);
            filePath = file.toURI().toString();

            if(filePath != null)
            {
                media = new Media(filePath);
                media_player = new MediaPlayer(media);
                media_view.setMediaPlayer(media_player);
                f_name = file.getName();
                file_name.setText(f_name);

                DoubleProperty width = media_view.fitWidthProperty();
                DoubleProperty height = media_view.fitHeightProperty();
                width.bind(Bindings.selectDouble(media_view.sceneProperty(), "width"));
                height.bind(Bindings.selectDouble(media_view.sceneProperty(), "height"));

                volumeSlider.setValue(media_player.getVolume() * 100);
                volumeSlider.valueProperty().addListener(new InvalidationListener()  //powiadomienie gdy wartosc slidera sie zmienia
                {
                    @Override
                    public void invalidated(Observable observable)
                    {
                        media_player.setVolume(volumeSlider.getValue() / 100);
                    }
                });

                media_player.currentTimeProperty().addListener(new ChangeListener<Duration>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue)
                    {    
                        time_slider.setValue(newValue.toSeconds());
                    }
                });

                time_slider.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        media_player.seek(Duration.seconds(time_slider.getValue()));
                    }
                });  


                media_player.play();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error, something went wrong while opening the file...");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }  
}