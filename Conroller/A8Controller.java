package sample.Conroller;


import dbConnector.dbConnection;
import javafx.fxml.FXML;
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

public class A8Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Integer UMMDK = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRDKHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                UMMDK = Integer.parseInt(rs.getString("HRDKHighUMMValue"));
            }

        textarea.appendText("A8. Hvis den indmeldte UMM ikke er lokal, ikke er planlagt eller ikke har en defekt på over "+ UMMDK + ", så er det ikke fundamental som med høj sandsynlighed kan udligne eller opregulere prisen");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        }

    @FXML
    void Next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A10.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A7.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
