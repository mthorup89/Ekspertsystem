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

public class A16Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textarea.appendText("A16.\n" +
                "Hvis der på nuværende tidspunkt er en eksport fra DK til prisområderne SE3 eller NO2, så er der sandsylighed for at DK fungerer som et mellemled til at balancere en mangel på produktion i Norden.\n" +
                "Dette kan være en indikator på at reguleringsprisen i ændres. ");
    }

    @FXML
    void Next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A17.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../A15.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
