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

public class ExpertEnterHRController implements Initializable {

    @FXML
    private Button ExpertCalculate;

    @FXML
    private Button ExpertEnterValue;

    @FXML
    private TextField HRAvgWindValue;

    @FXML
    private TextField HRCurrentAVGSunValue;

    @FXML
    private TextField HRCurrentAVGWindValue;

    @FXML
    private TextField HRCurrentDKUMMValue;

    @FXML
    private TextField HRCurrentEUUMMValue;

    @FXML
    private TextField HRCurrentOverAVGWindValue;

    @FXML
    private TextField HRDKUMMValue;

    @FXML
    private TextField HREUUMMValue;

    @FXML
    private Button HREnterAVGSun;

    @FXML
    private Button HREnterAvgWind;

    @FXML
    private Button HREnterDKUMM;

    @FXML
    private Button HREnterEUUMM;

    @FXML
    private Button HREnterOverAVGWind;

    @FXML
    private TextField HROverAvgWindValue;

    @FXML
    private TextField HRSunValue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRAverageWindValue, HROverAverageWindValue, HRAverageSunValue, HRDKHighUMMValue, HREuropeHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentAVGWindValue.setText(rs.getString("HRAverageWindValue"));
                HRCurrentOverAVGWindValue.setText(rs.getString("HROverAverageWindValue"));
                HRCurrentAVGSunValue.setText(rs.getString("HRAverageSunValue"));
                HRCurrentDKUMMValue.setText(rs.getString("HRDKHighUMMValue"));
                HRCurrentEUUMMValue.setText(rs.getString("HREuropeHighUMMValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clearFields() {
        HRAvgWindValue.clear();
        HROverAvgWindValue.clear();
        HRSunValue.clear();
        HRDKUMMValue.clear();
        HREUUMMValue.clear();
    }

    @FXML
    void HRActionEnterAvgWind(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE highrenewables SET HRAverageWindValue= '"+HRAvgWindValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        clearFields();
        updateAVGWindField();
    }

    public void updateAVGWindField() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();


        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRAverageWindValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentAVGWindValue.setText(rs.getString("HRAverageWindValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void HRActionEnterOverAVGWind(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE highrenewables SET HROverAverageWindValue ='"+HROverAvgWindValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateOverAVGWind();
    }

    public void updateOverAVGWind() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();


        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HROverAverageWindValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentOverAVGWindValue.setText(rs.getString("HROverAverageWindValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void HRActionEnterAVGSun(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE highrenewables SET HRAverageSunValue ='"+HRSunValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateAVGSun();
    }

    public void updateAVGSun() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRAverageSunValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentAVGSunValue.setText(rs.getString("HRAverageSunValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void HRActionEnterDKUMM(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE highrenewables SET HRDKHighUMMValue ='"+HRDKUMMValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateUMMDKField();
    }

    public void updateUMMDKField() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRDKHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentDKUMMValue.setText(rs.getString("HRDKHighUMMValue"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void HRActionEnterEUUMM(ActionEvent event) throws IOException, SQLException {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        String sql = "UPDATE highrenewables SET HREuropeHighUMMValue ='"+HREUUMMValue.getText()+"' WHERE ID=0";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        clearFields();
        updateUMMEUField();
    }

    public void updateUMMEUField() {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HREuropeHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                HRCurrentEUUMMValue.setText(rs.getString("HREuropeHighUMMValue"));
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
