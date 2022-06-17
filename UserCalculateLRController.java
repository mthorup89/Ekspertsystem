package sample;

import dbConnector.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Conroller.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCalculateLRController {

    @FXML
    private Button CalculateHRPage;

    @FXML
    private Button CalculateLRPage;

    @FXML
    private Button EnterHRPage;

    @FXML
    private Button EnterLRPage;

    @FXML
    private Button LRCalculateResultButton;

    @FXML
    private CheckBox LRResultActivations;

    @FXML
    private CheckBox LRResultExport;

    @FXML
    private CheckBox LRResultNordicVolumes;

    @FXML
    private CheckBox LRResultSpotprice;

    @FXML
    private TextField LRResultUserSun;

    @FXML
    private TextField LRResultUserWind;

    @FXML
    private Button LRUserEnterValues;

    @FXML
    private TextField LRUserSun;

    @FXML
    private TextField LRUserWind;

    @FXML
    private Label label;



    public void LRUserCalculate(ActionEvent event) throws IOException, SQLException {

        String LRUserWindValue = LRUserWind.getText();
        String LRUserSunValue = LRUserSun.getText();
        String LRAVGWindValue = null;
        String LRUnderAVGWindValue = null;
        String LRAVGSunValue = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt1 = connection.prepareStatement("SELECT LRAverageWindValue FROM lowrenewables");
            ResultSet rs1;
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                LRAVGWindValue = (rs1.getString("LRAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt2 = connection.prepareStatement("SELECT LRUnderAverageWindValue FROM lowrenewables");
            ResultSet rs2;
            rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                LRUnderAVGWindValue = (rs2.getString("LRUnderAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt3 = connection.prepareStatement("SELECT LRAverageSunValue FROM lowrenewables");
            ResultSet rs3;
            rs3 = stmt3.executeQuery();
            while (rs3.next()) {
                LRAVGSunValue = (rs3.getString("LRAverageSunValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Integer.parseInt(LRUserWindValue) < (Integer.parseInt(LRAVGWindValue) - (Integer.parseInt(LRUnderAVGWindValue))) & (Integer.parseInt(LRUserSunValue)) < (Integer.parseInt(LRAVGSunValue) + 1000)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Z1.fxml"));
            Parent root = (Parent) loader.load();
            Z1Controller controller = (Z1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Low renewables scenario");
            stage.show();
        }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("V1.fxml"));
                Parent root = (Parent) loader.load();
                V1Controller controller = (V1Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Not a low renewables scenario.");
                stage.show();
            }

        } /*else if ((Integer.parseInt(LRUserWindValue) < Integer.parseInt(LRAVGWindValue)) & (Integer.parseInt(LRUserWindValue) > (Integer.parseInt(LRAVGWindValue) - Integer.parseInt(LRUnderAVGWindValue)))) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Z1.fxml"));
            Parent root = (Parent) loader.load();
            Z1Controller controller = (Z1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Medium low renewable calculation");
            stage.show();

        }*/


    public void LRCalculateResult(ActionEvent event) throws IOException, SQLException {

        String LRResultUserWindValue = LRResultUserWind.getText();
        String LRResultUserSunValue = LRResultUserSun.getText();
        String LRResultAVGWindValue = null;
        String LRResultUnderAVGWindValue = null;
        String LRResultAVGSunValue = null;

        dbConnection ConnectionClass = new dbConnection();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement stmt1 = connection.prepareStatement("SELECT LRAverageWindValue FROM lowrenewables");
            ResultSet rs1;
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                LRResultAVGWindValue = (rs1.getString("LRAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt2 = connection.prepareStatement("SELECT LRUnderAverageWindValue FROM lowrenewables");
            ResultSet rs2;
            rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                LRResultUnderAVGWindValue = (rs2.getString("LRUnderAverageWindValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement stmt3 = connection.prepareStatement("SELECT LRAverageSunValue FROM lowrenewables");
            ResultSet rs3;
            rs3 = stmt3.executeQuery();
            while (rs3.next()) {
                LRResultAVGSunValue = (rs3.getString("LRAverageSunValue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Integer.parseInt(LRResultUserWindValue) > Integer.parseInt(LRResultAVGWindValue)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV1.fxml"));
            Parent root = (Parent) loader.load();
            ResultV1Controller controller = (ResultV1Controller) loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Not a low renewables scenario.");
            stage.show();
        }

        /*
            if (LRResultSpotprice.isSelected()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV2.fxml"));
                Parent root = (Parent) loader.load();
                ResultV2Controller controller = (ResultV2Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV3.fxml"));
                Parent root = (Parent) loader.load();
                ResultV3Controller controller = (ResultV3Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }
        */
        //else if ((Integer.parseInt(LRResultUserWindValue) < Integer.parseInt(LRResultAVGWindValue)) & (Integer.parseInt(LRResultUserWindValue) > (Integer.parseInt(LRResultAVGWindValue) - Integer.parseInt(LRResultUnderAVGWindValue))))
        else if (Integer.parseInt(LRResultUserWindValue) < (Integer.parseInt(LRResultAVGWindValue) - (Integer.parseInt(LRResultUnderAVGWindValue))) & (Integer.parseInt(LRResultUserSunValue)) < (Integer.parseInt(LRResultAVGSunValue)))
        {
            if (LRResultActivations.isSelected())
            {
                if (LRResultSpotprice.isSelected())
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV2.fxml"));
                    Parent root = (Parent) loader.load();
                    ResultV2Controller controller = (ResultV2Controller) loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Low renewables scenario - Result");
                    stage.show();
                }
                else
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV3.fxml"));
                    Parent root = (Parent) loader.load();
                    ResultV3Controller controller = (ResultV3Controller) loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("");
                    stage.show();
                }
            }
            else if(LRResultExport.isSelected())
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV4.fxml"));
                Parent root = (Parent) loader.load();
                ResultV4Controller controller = (ResultV4Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }
            else if(LRResultNordicVolumes.isSelected())
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV4.fxml"));
                Parent root = (Parent) loader.load();
                ResultV4Controller controller = (ResultV4Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }
            else if(LRResultSpotprice.isSelected())
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV2.fxml"));
                Parent root = (Parent) loader.load();
                ResultV2Controller controller = (ResultV2Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultV3.fxml"));
                Parent root = (Parent) loader.load();
                ResultV3Controller controller = (ResultV3Controller) loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();
            }
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
