package pl.lublin.wsei.java.cwiczenia;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    public Label lbFile;
    public ListView lstNoblisci;
    public String imieNazwisko;
    public TextField textRok;
    public TextField textDziedzina;
    public TextField textKraj;
    public TextField textMotywacja;
    private Noblista selNoblista;
    public Button buttonExport;

    ObservableList<String> imieNazwiskoList = FXCollections.observableArrayList();
    NoblisciList nbList;


    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV (*.csv)", "*.csv");


    public void initialize() {

        fileChooser.getExtensionFilters().add(csvFilter);
        lstNoblisci.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                        int index = new_val.intValue();
                        if (index != -1 ){
                            selNoblista = nbList.Lista.get(index);
                            textRok.setText(selNoblista.Rok);
                            textDziedzina.setText(selNoblista.Kategoria);
                            textKraj.setText(selNoblista.Kraj);
                            textMotywacja.setText(selNoblista.Uzasadnienie);

                        }
                        else{
                            textRok.setText(" ");
                            textDziedzina.setText(" ");
                            textKraj.setText(" ");
                            textMotywacja.setText(" ");
                            selNoblista = null;
                        }
                    }
                }
        );

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

    public void btnExport(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Export.fxml"));
            Parent root = loader.load();

            Export controller = loader.getController();
            if(nbList!=null){
                controller.setNoblisci(nbList);
            }

            Stage stage = new Stage();
            stage.setTitle("Export Danych");
            stage.setScene(new Scene(root, 500, 400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
