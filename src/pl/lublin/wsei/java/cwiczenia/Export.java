package pl.lublin.wsei.java.cwiczenia;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Export {
    public TextField textRokEx;
    public TextField textKrajEx;
    public TextField textDziedzinaEx;
    public Label lblWynikEx;
    NoblisciList noblisciListEX;

    public ArrayList<String> filtered = new ArrayList<>();
    private NoblisciList noblisciList;

    public void setNoblisci(NoblisciList listaNoblistow){
        this.noblisciList = listaNoblistow;
    }



}
