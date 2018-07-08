package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void buttonnext(ActionEvent actionEvent) {
        try {
            Stage stage =new Stage();
            FXMLLoader fxmlLoader=new FXMLLoader();
            Pane root=fxmlLoader.load(getClass().getResource("Sfxml.fxml").openStream());
            stage.setScene(new Scene(root,600,600));
            stage.setTitle("second stage");
            stage.initStyle(StageStyle.TRANSPARENT);
            Sfxml sfxml=fxmlLoader.getController();
            sfxml.initData(stage);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
