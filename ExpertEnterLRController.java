package sample;

import dbConnector.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ExpertEnterLRController implements Initializable {

    @FXML
    private Button ExpertCalculate;

    @FXML
    private Button ExpertCalculate1;

    @FXML
    private Button ExpertEnterValue;

    @FXML
    private Button ExpertEnterValue1;

    @FXML
    private TextField LRAvgWindValue;

    @FXML
    private TextField LRCurrentAVGSunValue;

    @FXML
    private TextField LRCurrentAVGWindValue;

    @FXML
    private TextField LRCurrentUnderAVGWindValue;

    @FXML
    private Button LREnterAVGSun;

    @FXML
    private Button LREnterAvgWind;

    @FXML
    private Button LREnterOverAVGWind;

    @FXML
    private TextField LRSunValue;

    @FXML
    private TextField LRUnderAvgWindValue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT LRAverageWindValue, LRUnderAverageWindValue, LRAverageSunValue FROM lowrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                LRCurrentAVGWindValue.setText(rs.getString("LRAverageWindValue"));
                LRCurrentUnderAVGWindValue.setText(rs.getString("LRUnderAverageWindValue"));
                LRCurrentAVGSunValue.setText(rs.getString("LRAverageSunValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clearFields() {
        LRAvgWindValue.clear();
        LRUnderAvgWindValue.clear();
        LRSunValue.clear();
    }

    @FXML
    void LRActionEnterAvgWind(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE lowrenewables SET LRAverageWindValue= '"+LRAvgWindValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        clearFields();
        updateLRAVGWindField();
    }

    public void updateLRAVGWindField() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();


        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT LRAverageWindValue FROM lowrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                LRCurrentAVGWindValue.setText(rs.getString("LRAverageWindValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void LRActionEnterUnderAvgWind(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE lowrenewables SET LRUnderAverageWindValue ='"+LRUnderAvgWindValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateUnderAVGWind();
    }

    public void updateUnderAVGWind() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();


        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT LRUnderAverageWindValue FROM lowrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                LRCurrentUnderAVGWindValue.setText(rs.getString("LRUnderAverageWindValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void LRActionEnterAVGSun(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE lowrenewables SET LRAverageSunValue ='"+LRSunValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateLRAVGSun();
    }

    public void updateLRAVGSun() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT LRAverageSunValue FROM lowrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                LRCurrentAVGSunValue.setText(rs.getString("LRAverageSunValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    public void EnterHR(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ExpertEnterHR.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    @FXML
    public void CalculateHR(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserCalculateHR.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    @FXML
    public void CalculateLR(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserCalculateLR.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    @FXML
    public void EnterLR(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ExpertEnterLR.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
