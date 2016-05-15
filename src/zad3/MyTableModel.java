package zad3;

import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by michalbaran on 14/05/16.
 */
public class MyTableModel extends AbstractTableModel {

    final String[] nazwaKolumn = {"Autor", "Tytuł", "Cena", "Okładka"};
    private ArrayList<String> autorzy = new ArrayList<>();

    private ArrayList<String> tytuly = new ArrayList<>();
    private ArrayList<String> ceny = new ArrayList<>();
    private ArrayList<String> okladki = new ArrayList<>();

    public MyTableModel(String autor, String tytul, String cena, String okladka){
/*
        FileReader fr = new FileReader(dane);
        BufferedReader br = new BufferedReader(fr);
        */
        autorzy.add(autor);
        tytuly.add(tytul);
        ceny.add(cena);
        okladki.add(okladka);




    }
    public String getColumnName(int col) {
        return nazwaKolumn[col];
    }

    @Override
    public int getRowCount() {

        return autorzy.size();
    }

    @Override
    public int getColumnCount() {

        return  nazwaKolumn.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        switch(columnIndex) {

            case 0 : o = autorzy.get(rowIndex);
                break;
            case 1 : o = tytuly.get(rowIndex);
                break;
            case 2 : o = ceny.get(rowIndex);
                break;
            case 3 : o = okladki.get(rowIndex);
                default: break;
        }

        return o;
    }
}
