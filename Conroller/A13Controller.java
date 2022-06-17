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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A13Controller implements Initializable {

    @FXML
    private TextField HRA13Value;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("A13.\n" +
                "Hvad er det nuværende totale niveau af\n" +
                "import og eksport fra DK? ");
    }

    @FXML
    void HRA13Submit(ActionEvent event) throws IOException {

        String UserValue = HRA13Value.getText();

        if ((Integer.parseInt(UserValue) > 500)) {
            Parent root = FXMLLoader.load(getClass().getResource("../F6.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } else if ((Integer.parseInt(UserValue) < -250)) {
            Parent root = FXMLLoader.load(getClass().getResource("../F7.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("../A14.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        }

    }
}