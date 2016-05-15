package zad3;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by michalbaran on 14/05/16.
 */
public class MyTableModel extends AbstractTableModel {

    final String[] nazwaKolumn = {"Autor", "Tytuł", "Cena", "Okładka"};
    private ArrayList<String> autorzy = new ArrayList<>();

    private ArrayList<String> tytuly = new ArrayList<>();
    private ArrayList<String> ceny = new ArrayList<>();
    private ArrayList<ImageIcon> okladki = new ArrayList<>();

    public MyTableModel(String pathFile) {
/*
        FileReader fr = new FileReader(dane);
        BufferedReader br = new BufferedReader(fr);
        */
        Scanner scan = null;
        try {
            scan = new Scanner(new File(pathFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNext()) {
            autorzy.add(scan.next());
            tytuly.add(scan.next());
            ceny.add(scan.next());
            okladki.add(new ImageIcon(scan.next()));
        }


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

        return nazwaKolumn.length;
    }

    @Override
    public Class getColumnClass(int columnIndex) {

        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        switch (columnIndex) {

            case 0:
                o = autorzy.get(rowIndex);
                break;
            case 1:
                o = tytuly.get(rowIndex);
                break;
            case 2:
                o = ceny.get(rowIndex);
                break;
            case 3:
                o = okladki.get(rowIndex);
            default:
                break;
        }

        return o;
    }
}
