package pl.lublin.wsei.java.cwiczenia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class NoblisciList {
    public ArrayList<Noblista> Lista;

    public NoblisciList(String nobelFileName){
        Lista = new ArrayList<>();
        String contents;
        try{
            contents = new String(Files.readAllBytes(Paths.get(nobelFileName)));
        }
        catch (IOException e){
            System.out.println("Błąd wczytywania pliku nobel_prize_by_winner.csv => "+e.getLocalizedMessage());
            e.printStackTrace();
            contents = "";
        }
        String[] items = contents.split("\n");
        for (int i = 1; i < items.length; i++){
            items[i]=items[i].replaceAll(",(?!(?:[^\"]*\"[^\"]*\")*[^\"]*$)", "");
            items[i]=items[i].replaceAll(",,", " , , ");
            items[i]=items[i].replaceAll("\"\"\"", "\"");
            Lista.add(new Noblista(items[i]));

        }
        for(Noblista no: Lista) no.print();
    }
}
