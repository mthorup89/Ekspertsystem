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

public class F7Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText(
                "F7.\n" +
                "Hvis der på nuværende tidspunkt er en samlet eksport\n" +
                "fra DK på over 250 MWh så er det en indikation på at\n" +
                "reguleringsprisen ændres.\n" +
                "\n" +
                "Et køb involverer lav risiko.\n" +
                "\n" +
                "Et salg involverer høj risiko.\n" +
                "\n");
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

        Parent root = FXMLLoader.load(getClass().getResource("../A13.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
