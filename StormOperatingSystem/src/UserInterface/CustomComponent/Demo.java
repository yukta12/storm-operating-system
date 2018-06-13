package UserInterface.CustomComponent;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Demo extends Application{
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Just for testing !!");
        movieButton mb = new movieButton("resources/images/1.jpg" , "Mozzila" , 20);
        movieButton mb2 = new movieButton("resources/images/2.jpg" , "Chrome", 5);
        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(30 , 30 , 30 ,30));
        hbox.getChildren().addAll(mb , mb2);
        Scene scene = new Scene(hbox , 640 , 480);
        window.setScene(scene);
        window.show();
    }
}
