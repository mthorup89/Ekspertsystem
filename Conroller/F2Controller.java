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

public class F2Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("F2.\n" +
                        "Hvis den gældende time's spot pris ikke er\n" +
                        "under 80 EUR/MWH eller den nuværende\n" +
                        "intraday pris ikke er lavere end 25 procent under\n" +
                        "den gældende time's spot pris, så er der\n" +
                        "sandsynlighed for at reguleringsprisen falder til et niveau som er under den nuværende intraday pris.\n" +
                        " \n" +
                        "Et køb involverer høj risiko.\n" +
                        "\n" +
                        "Et salg involverer lav risiko."
                );
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A21.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
