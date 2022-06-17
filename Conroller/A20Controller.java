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

public class A20Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        textarea.appendText("A20.\n" +
                "Hvis den nuværende intraday pris er under den gældende time's spot pris, så kan der være sandsynlighed for at selvom reguleringsprisen falder, så vil den ikke falde til en et lavere niveau end den nuværende intraday pris. Der er derfor behov for yderligere vurdering af den nuværende intraday pris.");
    }

    @FXML
    void Next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A21.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A19.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}