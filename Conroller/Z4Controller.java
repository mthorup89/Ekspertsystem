package sample.Conroller;

import dbConnector.dbConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Z4Controller implements Initializable {


    @FXML
    private TextField LRZ4Value;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            textarea.appendText("Z4.\n" +
                    "Hvad er det nuværende totale niveau af\n" +
                    "import og eksport til eller fra DK? ");

    }

    @FXML
    void LRZ4Submit(ActionEvent event) throws IOException {

        String UserValue = LRZ4Value.getText();

        if ((Integer.parseInt(UserValue) < 0)) {
            Parent root = FXMLLoader.load(getClass().getResource("../V4.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } else if ((Integer.parseInt(UserValue) > 750 )) {
            Parent root = FXMLLoader.load(getClass().getResource("../Z5.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("../V5.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        }

    }

    }
