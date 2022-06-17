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

public class F4Controller implements Initializable {

    @FXML
    private Button ToEtBack;

    @FXML
    private Button ToEtNext;

    @FXML
    private TextArea textarea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            textarea.appendText("F4. \n" +
                    " Der er fundamentals som indikerer en tilstrækkelig\n" +
                    "defekt på et lokalt eller et nært liggende prisområde.\n" +
                    "Dette kan betyde at der er behov for at balancere den manglende produktion af elektricitet, hvilket kan få reguleringsprisen i DK til at stige.\n" +
                    "\n" +
                    "Et køb involverer medium risiko. \n" +
                    "\n" +
                    "Et salg involverer høj risiko.\n" +
                    "\n");

    }

}
