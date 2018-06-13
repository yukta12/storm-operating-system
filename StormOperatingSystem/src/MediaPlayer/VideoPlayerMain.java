package MediaPlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class VideoPlayerMain extends Application {
    private static Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("VideoPlayer.fxml"));
        window.setTitle("Dashboard");
        window.setScene(new Scene(root, 1920, 1080));
        window.show();
    }

    public static Stage getStage(){
        return window;
    }
}
