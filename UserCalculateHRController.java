package sample;

import dbConnector.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Conroller.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Resultbased calucaltion use -> implements Initializable

public class UserCalculateHRController {

    @FXML
    private Button ExpertCalculate;

    @FXML
    private Button ExpertCalculate1;

    @FXML
    private Button ExpertEnterValue;

    @FXML
    private Button ExpertEnterValue1;

    /*
    @FXML
    private Button HRCalculateResultButton;

    @FXML
    private CheckBox HRResultActivations;

    @FXML
    private CheckBox HRResultExport;

    @FXML
    private CheckBox HRResultNordicVolumes;

    @FXML
    private CheckBox HRResultSpotprice;

    @FXML
    private CheckBox HRResultUMMDK;

    @FXML
    private CheckBox HRResultUMMEU;

    @FXML
    private TextField ResultUserSun;

    @FXML
    private TextField ResultUserWind;
    */

    @FXML
    private Button UserEnterValues;

    @FXML
    private TextField UserSun;

    @FXML
    private TextField UserWind;

    /*
    @FXML
    private Label label;

    @FXML
    private Label UMMDKLabel;

    @FXML
    private Label UMMEULabel;
    */

    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();


        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT HRDKHighUMMValue, HREuropeHighUMMValue FROM highrenewables");
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                UMMDKLabel.setText(rs.getString("HRDKHighUMMValue"));
                UMMEULabel.setText(rs.getString("HREuropeHighUMMValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    */

    public void UserWalkthroughHR(ActionEvent event) throws IOException, SQLException {


        String UserWindValue = UserWind.getText();
        String UserSunValue = UserSun.getText();
        String AVGWindValue = null;
        String OverAVGWindValue = null;
        String AVGSunValue = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt1 = connection.prepareStatement("SELECT HRAverageWindValue FROM highrenewables");
            ResultSet rs1;
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                AVGWindValue = (rs1.getString("HRAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt2 = connection.prepareStatement("SELECT HROverAverageWindValue FROM highrenewables");
            ResultSet rs2;
            rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                OverAVGWindValue = (rs2.getString("HROverAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt3 = connection.prepareStatement("SELECT HRAverageSunValue FROM highrenewables");
            ResultSet rs3;
            rs3 = stmt3.executeQuery();
            while (rs3.next()) {
                AVGSunValue = (rs3.getString("HRAverageSunValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Integer.parseInt(UserWindValue) < Integer.parseInt(AVGWindValue) + (Integer.parseInt(OverAVGWindValue))) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("F1.fxml"));
            Parent root = (Parent) loader.load();
            F1Controller controller = (F1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Not a high renewable scenario");
            stage.show();

        }

        else if (Integer.parseInt(UserWindValue) > (Integer.parseInt(AVGWindValue) + (Integer.parseInt(OverAVGWindValue))) & (Integer.parseInt(UserSunValue)) > (Integer.parseInt(AVGSunValue) - 1000)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("A1.fxml"));
            Parent root = (Parent) loader.load();
            A1Controller controller = (A1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("High renewable scenario");
            stage.show();


        /*else if (Integer.parseInt(UserWindValue) > (Integer.parseInt(AVGWindValue) + (Integer.parseInt(OverAVGWindValue))) & (Integer.parseInt(UserSunValue)) > (Integer.parseInt(AVGSunValue))) {
            //label.setText(UserWindValue+UserSunValue+"-"+AVGWindValue + "-" + OverAVGWindValue + "-" + AVGSunValue ); //Test
            FXMLLoader loader = new FXMLLoader(getClass().getResource("C1.fxml"));
            Parent root = (Parent) loader.load();
            C1Controller controller = (C1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("High renewable scenario");
            stage.show();
    }*/
            //else if ((Integer.parseInt(UserWindValue) > Integer.parseInt(AVGWindValue)) & (Integer.parseInt(UserWindValue) < Integer.parseInt(AVGWindValue + OverAVGWindValue))) {
            //label.setText(UserWindValue+UserSunValue+"-"+AVGWindValue + "-" + OverAVGWindValue + "-" + AVGSunValue); //Test



        }
    }

    // Resultbased calculation old model
    /*
    public void HRCalculateResult(ActionEvent event) throws IOException {

        String ResultUserWindValue = ResultUserWind.getText();
        String ResultUserSunValue = ResultUserSun.getText();
        String ResultAVGWindValue = null;
        String ResultOverAVGWindValue = null;
        String ResultAVGSunValue = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt1 = connection.prepareStatement("SELECT HRAverageWindValue FROM highrenewables");
            ResultSet rs1;
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                ResultAVGWindValue = (rs1.getString("HRAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt2 = connection.prepareStatement("SELECT HROverAverageWindValue FROM highrenewables");
            ResultSet rs2;
            rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                ResultOverAVGWindValue = (rs2.getString("HROverAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt3 = connection.prepareStatement("SELECT HRAverageSunValue FROM highrenewables");
            ResultSet rs3;
            rs3 = stmt3.executeQuery();
            while (rs3.next()) {
                ResultAVGSunValue = (rs3.getString("HRAverageSunValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Integer.parseInt(ResultUserWindValue) < Integer.parseInt(ResultAVGWindValue)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF1.fxml"));
            Parent root = (Parent) loader.load();
            ResultF1Controller controller = (ResultF1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Not a high renewable scenario - Result");
            stage.show();

        }

        else if ((Integer.parseInt(ResultUserWindValue) > Integer.parseInt(ResultAVGWindValue + ResultOverAVGWindValue)))
        {

        if (HRResultActivations.isSelected()) {

            if (HRResultSpotprice.isSelected()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF2.fxml"));
                Parent root = (Parent) loader.load();
                ResultF2Controller controller = (ResultF2Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("High renewable scenario - Result");
                stage.show();
            }

            else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF3.fxml"));
                Parent root = (Parent) loader.load();
                ResultF3Controller controller = (ResultF3Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }

            }

            else if (HRResultUMMDK.isSelected())
            {
            //Hvis ikker der er aktiveringer så tjekkes der for UMM i DK
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF4.fxml"));
            Parent root = (Parent) loader.load();
            ResultF4Controller controller = (ResultF4Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();

            }
            else if (HRResultUMMEU.isSelected()) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF4.fxml"));
            Parent root = (Parent) loader.load();
            ResultF4Controller controller = (ResultF4Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
            }
            else if (HRResultExport.isSelected()){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF4.fxml"));
            Parent root = (Parent) loader.load();
            ResultF4Controller controller = (ResultF4Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
            }

            else if (HRResultNordicVolumes.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF4.fxml"));
            Parent root = (Parent) loader.load();
            ResultF4Controller controller = (ResultF4Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
            }
            else if (HRResultSpotprice.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF2.fxml"));
            Parent root = (Parent) loader.load();
            ResultF2Controller controller = (ResultF2Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
            }
            else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF3.fxml"));
            Parent root = (Parent) loader.load();
            ResultF3Controller controller = (ResultF3Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
            }
        }
    */

    /*
    else if (Integer.parseInt(ResultUserWindValue) > (Integer.parseInt(ResultAVGWindValue) + (Integer.parseInt(ResultOverAVGWindValue))) & (Integer.parseInt(ResultUserSunValue)) > (Integer.parseInt(ResultAVGSunValue))) {

            if (HRResultSpotprice.isSelected()) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF2.fxml"));
                Parent root = (Parent) loader.load();
                ResultF2Controller controller = (ResultF2Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("High renewable scenario");
                stage.show();

            }
            else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultF3.fxml"));
                Parent root = (Parent) loader.load();
                ResultF3Controller controller = (ResultF3Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }

     */



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