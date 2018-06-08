package UserInterface.CustomComponent;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * This class is a custom component which has an imageview , a label and 2 buttons on it which will be
 * displayed by the so called iPhone hover effect
 */
public class movieButton extends VBox{
    private ImageView imageView;
    private Button download;
    private Button play;
    private VBox vb;
    private String imagePath;
    private StackPane stackPane;
    private TranslateTransition  tt;
    private boolean isDownloaded;
    private String movieName;

    /**
     * @param imagePath This takes the imagePath(Relative path) and adds it to the component
     * @param movieName This takes the movieName for the label below it
     */
    public movieButton(String imagePath , String movieName) {
        this.movieName = movieName;
        this.imagePath = imagePath;
        makeTheComponent();
    }

    /**
     * @param imagePath This takes the imagePath(Relative path) and adds it to the component
     * @param vboxSpacing This sets the spacing between the label and the image
     * @param movieName This takes the movieName for the label below it
     */
    public movieButton(String imagePath ,  String movieName , int vboxSpacing) {
        this.movieName = movieName;
        this.imagePath = imagePath;
        this.setSpacing(vboxSpacing);
        makeTheComponent();
    }

    /**
     * This function adds the component to the class it inherits (VBOX)
     */
    private void makeTheComponent(){
        stackPane = new StackPane();
        imageView = new ImageView(new Image(imagePath));
        vb = new VBox();
        download = new Button("Download");
        play = new Button("Play");
        vb.getChildren().addAll(download , play);
        stackPane.getChildren().addAll(imageView , vb);
        download.setVisible(false);
        play.setStyle("-fx-translate-y : 60");
        play.setVisible(false);
        Label label = new Label(movieName);
        label.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().addAll(stackPane , label);
        tt = new TranslateTransition();
        addHoverEffect();

    }

    /**
     * This method adds hover effect by using onMouseEntered and onMouseExited
     */
    private void addHoverEffect() {
        stackPane.setOnMouseExited(mouseEvent -> {
            play.setVisible(false);
            removeEffect(imageView);
            play.setStyle("-fx-translate-y : 0");
        });

        stackPane.setOnMouseEntered(mouseEvent -> {
            addEffect(imageView);
            addTranslateTransitionUpwards();
        });
    }

    /**
     * This method adds gaussian blur to the image parameter
     * @param imageView The imageView to be given the blur effect
     */
    private void addEffect(ImageView imageView){
        GaussianBlur effect = new GaussianBlur(20);
        imageView.setEffect(effect);
    }

    /**
     * This method removes gaussian blur to the image parameter
     * @param imageView The imageView to be given the blur effect
     */
    private void removeEffect(ImageView imageView){
        GaussianBlur effect = new GaussianBlur(0);
        imageView.setEffect(effect);
    }

    /**
     * This method adds the animation effect on button
     */
    private void addTranslateTransitionUpwards(){
        play.setVisible(true);
        tt.setNode(play);
        tt.setDuration(Duration.seconds(0.225));
        tt.setFromY(70);
        tt.setToY(0);
        tt.play();
    }
}
