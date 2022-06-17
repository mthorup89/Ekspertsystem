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

public class Z1Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Integer LRAVGWind = null;
        Integer LRUnderAVGWind = null;
        Integer LRAVGSun = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT LRAverageWindValue, LRUnderAverageWindValue, LRAverageSunValue FROM lowrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                LRAVGWind = Integer.parseInt(rs.getString("LRAverageWindValue"));
                LRUnderAVGWind = Integer.parseInt(rs.getString("LRUnderAverageWindValue"));
                LRAVGSun = Integer.parseInt(rs.getString("LRAverageSunValue"));

            }
            textarea.appendText("Z1.\n" +
                    "Den indtastede værdi for vind er mindre end den gennemsnitlige værdi for vind som er:" +LRAVGWind+ " minus Trading desk's egen vaiable værdi for vind under gennemsnittet som er:" + LRUnderAVGWind + ".\n" +
                    "Den indtastede sol værdi er ligeledes ikke højere end den gennemsnitlige værdi for sol som er:"+LRAVGSun+" plus Trading desk's egen variable værdi for sol over gennemsnittet som er 1000.\n" +
                    "Der er derfor tale om et lavt renewables scenarie.");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Z2.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
