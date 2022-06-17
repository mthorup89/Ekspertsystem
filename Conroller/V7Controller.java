package sample.Conroller;

import javafx.fxml.FXML;
import dbConnector.dbConnection;
import javafx.event.ActionEvent;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class V7Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("V7.\n" +
                "Hvis den totale reguleringsvolumen i Norden ikke er negativ så er der ingen indikation på at reguleringsprisen i DK vil ændres.\n" +
                "\n" +
                "Et køb involverer medium risiko.\n" +
                "\n" +
                "Et salg involverer medium risiko.");
    }
    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Z8.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
}