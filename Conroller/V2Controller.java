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

public class V2Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("V2.\n" +
                "Hvis der er indmeldt en aktivering i form af opregulering i\n" +
                "Mkplanner og den nuværende intraday pris er over\n" +
                "aktiveringsprisen for den billigste PG gruppe fra Energinet, er der sandsynlighed for at den nuværende intraday pris er højere end den forventede reguleringspris.\n" +
                "\n" +
                "Et køb involverer mellem risiko\n" +
                "\n" +
                "Et salg involverer stor risiko");
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Z10.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
}