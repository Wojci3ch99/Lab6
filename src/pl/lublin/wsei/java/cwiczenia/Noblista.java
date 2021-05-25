package pl.lublin.wsei.java.cwiczenia;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noblista {
    public String Imie;
    public String Nazwisko;
    public String Rok;
    public String Kategoria;
    public String Uzasadnienie;
    public String Kraj;
    public String DataRow;

    public Noblista(String tekst) {
        Pattern pat = Pattern.compile("(?:([^,]*)(?:[^,-]|))");
        DataRow = tekst;
        Matcher m = pat.matcher(tekst);
        List<String> data = new ArrayList<String>();
        while (m.find()) {
            for (int j = 1; j <= m.groupCount(); j++) {
                if (m.group(0) != "") data.add(m.group(0));
            }
        }
        Imie = data.get(1);
        Nazwisko = data.get(2);
        Kraj = data.get(5);
        Rok = data.get(12);
        Kategoria = data.get(13);
        Uzasadnienie = data.get(16);
    }
        public void print()
        {
            System.out.println("\nNoblista");
            System.out.println("Imie: " + Imie);
            System.out.println("Nazwisko: " + Nazwisko);
            System.out.println("Rok otrzymania: " + Rok);
            System.out.println("Kategoria: " + Kategoria);
            System.out.println("Kraj: " + Kraj);
            System.out.println("Uzasadnienie: " + Uzasadnienie);
            System.out.println("DataRow: " + DataRow);
        }
    }

