package pl.lublin.wsei.java.cwiczenia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public Label lbFile;
    public ListView lstNoblisci;
    public String imieNazwisko;

    ObservableList<String> imieNazwiskoList = FXCollections.observableArrayList();
    NoblisciList nbList;


    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");

    public void initialize() {
        fileChooser.getExtensionFilters().add(csvFilter);
    }

    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file !=null) {
            nbList = new NoblisciList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            for (Noblista nb: nbList.Lista) {
                imieNazwisko = nb.Imie + " " + nb.Nazwisko;
                imieNazwiskoList.add(imieNazwisko);
            }
            lstNoblisci.setItems(imieNazwiskoList);
        }
        else
            {
            lbFile.setText("Proszę wczytać plik ...");
        }
    }

}
