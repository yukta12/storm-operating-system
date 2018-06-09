package MediaPlayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class VideoPlayerController implements Initializable {

    private MediaPlayer mediaPlayer;

    private Media media;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnPause;

    @FXML
    private Slider slider;

    @FXML
    void btnPauseClicked(ActionEvent event) {
        btnPause.setVisible(false);
        btnPause.setDisable(true);
        btnPlay.setVisible(true);
        btnPlay.setDisable(false);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        btnPlay.setVisible(false);
        btnPlay.setDisable(true);
        btnPause.setVisible(true);
        btnPause.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = new File("src/MediaPlayer/colorblind.mp4").getAbsolutePath();
        System.out.println("Path is : " + path);
        media = new Media(new File(path).toURI().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaView.setMediaPlayer(mediaPlayer);
//        mediaPlayer.play();
    }
}
