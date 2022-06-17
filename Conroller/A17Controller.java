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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class A17Controller implements Initializable {


    @FXML
    private Button Yes;

    @FXML
    private Button No;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("A17.\n" +
                "Er den totale reguleringsvolumen i Norden positiv?");
    }

    @FXML
    void Yes(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../F10.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }

    @FXML
    void No(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../F9.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }
}
