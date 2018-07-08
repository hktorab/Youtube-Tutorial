package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Sfxml {
    public TextArea textArea;

    public void okay(ActionEvent actionEvent) {
        System.out.println(textArea.getText());
    }

    public void exit(ActionEvent actionEvent) {
        stage.close();
        //  System.exit(1);
    }
    Stage stage;
    public void initData(Stage stage) {
        this.stage=stage;
    }
}
