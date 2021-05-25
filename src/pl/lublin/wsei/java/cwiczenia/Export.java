package pl.lublin.wsei.java.cwiczenia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Export {

    public TextField textRokEx;
    public TextField textKrajEx;
    public TextField textDziedzinaEx;
    public Label lblWynikEx;
    NoblisciList noblisciList;
    public ArrayList<String> SearchNoblisci = new ArrayList<>();

    public void setNoblisci(NoblisciList listaNoblistow){
        this.noblisciList = listaNoblistow;
    }

    public void Zapis(ActionEvent actionEvent){
        try {
            FileWriter zapis = new FileWriter("export_nobel.csv");
            zapis.write("");
            zapis.close();
            String rok = textRokEx.getText().toLowerCase();
            String kraj = textKrajEx.getText().toLowerCase();
            String dziedzina = textDziedzinaEx.getText().toLowerCase();
            ArrayList<Noblista> NoblisciRok = new ArrayList<>();
            for(Noblista noblist: noblisciList.Lista){
                if (rok.equals(""))
                    NoblisciRok.add(noblist);
                else if (noblist.Rok.toLowerCase().contains(rok)){
                    NoblisciRok.add(noblist);
                }
            }
            SearchNoblisci.clear();
            ArrayList<Noblista> NoblisciKraj = new ArrayList<>();
            for(Noblista noblist : NoblisciRok){
                if(kraj.equals(""))
                    NoblisciKraj.add(noblist);
                else if(noblist.Kraj.toLowerCase().contains(kraj)){
                    NoblisciKraj.add(noblist);
                }
            }
            for(Noblista noblist : NoblisciKraj){
                if(dziedzina.equals(""))
                    SearchNoblisci.add(noblist.DataRow);
                else if(noblist.Kategoria.toLowerCase().contains(dziedzina)){
                    SearchNoblisci.add(noblist.DataRow);
                }
            }
            FileWriter myWriter = new FileWriter("export_nobel.csv");
            for (int i = 0; i < SearchNoblisci.size(); i++) myWriter.append(SearchNoblisci.get(i));
            myWriter.close();
            System.out.println("Zapisano dane do pliku");
            if(SearchNoblisci.size()==1) lblWynikEx.setText("Wyszukano" + SearchNoblisci.size() + " noblista");
            else lblWynikEx.setText("Wyszukano " + SearchNoblisci.size() + " noblistów");
            SearchNoblisci.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}