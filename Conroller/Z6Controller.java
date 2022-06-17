package sample.Conroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Z6Controller implements Initializable {


    @FXML
    private Button Yes;

    @FXML
    private Button No;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("Z6. \n" +
                "Bliver den nuværende samlede import til DK importeret \n" +
                "fra prisområderne SE3 eller NO2?");
    }

    @FXML
    void Yes(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Z7.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }

    @FXML
    void No(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../V6.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }

}