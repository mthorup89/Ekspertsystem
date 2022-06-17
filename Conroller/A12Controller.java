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

public class A12Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Integer UMMEurope = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HREuropeHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                UMMEurope = Integer.parseInt(rs.getString("HREuropeHighUMMValue"));
            }

            textarea.appendText("A12. Hvis den indmeldte UMM er i Nordeuropa, og beskriver en defekt på over "+ UMMEurope +" værdi kan det være en fundamental som øge produktionsomkostningerne og derved udligne eller opregulere prisen.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../F4.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A10.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}