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

public class A1Controller implements Initializable {

    @FXML
    private TextArea textarea;

    @FXML
    private Button EtNext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            Integer AVGWind = null;
            Integer OverAVGWind = null;
            Integer AVGSun = null;

            dbConnection ConnectionClass = new dbConnection();
            Connection connection = ConnectionClass.getConnection();

            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT HRAverageWindValue, HROverAverageWindValue, HRAverageSunValue FROM highrenewables");
                ResultSet rs;
                rs = stmt.executeQuery();
                while (rs.next()) {
                    AVGWind = Integer.parseInt(rs.getString("HRAverageWindValue"));
                    OverAVGWind = Integer.parseInt(rs.getString("HROverAverageWindValue"));
                    AVGSun = Integer.parseInt(rs.getString("HRAverageSunValue"));

                }
                textarea.appendText("A1. Den indtastede vind værdi er højere end den gennemsnitlige værdi for vind som er " + AVGWind + "  plus Trading desk's egen variable værdi for over gennemsnitsværdi som er " + OverAVGWind + ".\nDen indtastede sol værdi er ligeledes ikke mindre end Average sun value som er " + AVGSun + " minus Trading desk's egen variable værdi for under gennemsnitsværdi.\n Der er derfor tale om en et højt renewables scenarie.");



            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }

    @FXML
    void EtNext(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A2.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }


}

