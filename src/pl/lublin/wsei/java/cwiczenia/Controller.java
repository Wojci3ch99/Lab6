package pl.lublin.wsei.java.cwiczenia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public Label lbFile;
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");

    public void initialize() {
        fileChooser.getExtensionFilters().add(csvFilter);
    }

    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file !=null) {
            lbFile.setText(file.getAbsolutePath());
        }
        else {
            lbFile.setText("Proszę wczytać plik ...");
        }
    }
}
