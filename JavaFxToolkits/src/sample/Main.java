package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private double xoffset;
    private double yoffset;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setOnMousePressed(event -> {
            xoffset=event.getSceneX();
            yoffset=event.getSceneY();
        });
      root.setOnMouseDragged(e->{
          primaryStage.setX(e.getScreenX()-xoffset);
          primaryStage.setY(e.getScreenY()-yoffset);
      });
        primaryStage.setTitle("Stage 1");
        primaryStage.setScene(new Scene(root, 720, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
