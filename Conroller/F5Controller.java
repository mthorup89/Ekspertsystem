package sample.Conroller;


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
import java.util.ResourceBundle;

public class F5Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("F5. \n" +
                "Hvis den gældende time's spot pris er\n" +
                "under 80 EUR/MWH eller den nuværende\n" +
                "intraday pris er lavere end 25 procent\n" +
                "under den gældende time's spot pris, så er der usikkerhed omkring at reguleringsprisen falder til et niveau som er under den nuværende intraday pris.\n" +
                "\n" +
                "Et køb involverere høj risiko.\n" +
                "\n" +
                "Et salg involverer mellem risiko.");
    }

    /*@FXML
    void Next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A16.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }*/

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A21.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}