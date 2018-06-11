package MediaPlayer;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class VideoPlayerController implements Initializable {

    private MediaPlayer mediaPlayer;

    private Media media;

    private TranslateTransition tt;

    @FXML
    private AnchorPane moviePane;


    @FXML
    private MediaView mediaView;

    @FXML
    private AnchorPane movieControlsPane;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnPause;

    @FXML
    private Slider slider;

    @FXML
    private Slider volumeSlider;

    @FXML
    private VBox mediaControls;

    @FXML
    private Button btnEnterFS;

    @FXML
    private Button btnExitFS;

    @FXML
    void btnPauseClicked(ActionEvent event) {
        btnPause.setVisible(false);
        btnPause.setDisable(true);
        btnPlay.setVisible(true);
        btnPlay.setDisable(false);
        mediaPlayer.pause();
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        btnPlay.setVisible(false);
        btnPlay.setDisable(true);
        btnPause.setVisible(true);
        btnPause.setDisable(false);
        mediaPlayer.play();
    }

    @FXML
    private void btnEnterFSClicked(){
        btnEnterFS.setVisible(false);
        btnEnterFS.setDisable(true);
        btnExitFS.setVisible(true);
        btnExitFS.setDisable(false);
        Stage window = VideoPlayerMain.getStage();
        window.setFullScreen(true);
    }

    @FXML
    private void btnExitFSClicked(){
        btnExitFS.setVisible(false);
        btnExitFS.setDisable(true);
        btnEnterFS.setVisible(true);
        btnEnterFS.setDisable(false);
        Stage window = VideoPlayerMain.getStage();
        window.setFullScreen(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = new File("/Users/gauravpunjabi/Desktop/Coding/Projects/Storm-Operating-System/StormOperatingSystem/src/MediaPlayer/Colorblind.mp4").getAbsolutePath();
        btnPause.setVisible(false);
        btnPause.setDisable(true);
        btnExitFS.setVisible(false);
        btnExitFS.setDisable(true);
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        Duration duration = media.getDuration();
        double time = duration.toSeconds();
        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty() , "height"));

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                Duration time = mediaPlayer.getCurrentTime();
                Duration total = mediaPlayer.getTotalDuration();
                if(!slider.isValueChanging() && total.greaterThan(Duration.ZERO)){
                    slider.setValue(time.toMillis()/total.toMillis() * 100);
                }
            }
        });

        volumeSlider.setValue(mediaPlayer.getVolume()*100);
        volumeSlider.valueProperty().addListener(changeListener->{
            mediaPlayer.setVolume(volumeSlider.getValue()/100);
        });

        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                  mediaPlayer.seek(mediaPlayer.getTotalDuration().multiply(slider.getValue()/100));
            }
        });

        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                mediaPlayer.seek(mediaPlayer.getTotalDuration().multiply(slider.getValue()/100));
            }
        });

        mediaControls.setOnKeyPressed(keyEvent->{
            if(keyEvent.getCode() == KeyCode.ESCAPE){
                btnExitFS.setVisible(false);
                btnExitFS.setDisable(true);
                btnEnterFS.setVisible(true);
                btnEnterFS.setDisable(false);
            }
        });

        tt = new TranslateTransition();
        addAnimations();
    }

    private void addAnimations() {
        mediaView.setOnMouseClicked(mouseEvent->{
            if(mouseEvent.getClickCount()%2 != 0 /*Odd*/){
//                System.out.println("Clicked odd time");
//                animateDownwards();
                mediaControls.setVisible(false);
            } else if(mouseEvent.getClickCount()%2==0){
//                System.out.println("Clicked even time");
//                animateUpwards();
                mediaControls.setVisible(true);
            }
        });
    }

    private void animateDownwards() {
        System.out.println("animating downwards");
        tt.setNode(mediaControls);
        tt.setDuration(Duration.seconds(1));
        tt.setFromY(0);
        tt.setToY(100);
        tt.play();
        System.out.println("Playing");
    }

    private void animateUpwards() {
        tt.setNode(mediaControls);
        tt.setDuration(Duration.seconds(1));
        tt.setFromY(100);
        tt.setToY(0);

        tt.play();
    }
}
