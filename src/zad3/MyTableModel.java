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
    private ArrayList<Double> ceny = new ArrayList<>();
    private ArrayList<ImageIcon> okladki = new ArrayList<>();

    public MyTableModel(String pathFile) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File(pathFile));
        } catch (FileNotFoundException e) {
            System.out.println("Niepoprawny plik");;
        }
        while (scan.hasNext()) {
            autorzy.add(scan.next());
            tytuly.add(scan.next());
            ceny.add(scan.nextDouble());
            Image okladka = null;
            try {
                okladka = ImageIO.read(new File((scan.next())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image okladkaZmniejszona = okladka.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ikonka = new ImageIcon(okladkaZmniejszona);
            okladki.add(ikonka);
        }


    }

    public String getColumnName(int col) {
        return
                nazwaKolumn[col];
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

    public void setValueAt(Object value, int row, int col) {
        if (col == 2) {
            ceny.add(row, (Double) value);
            fireTableCellUpdated(row, col);
        }
    }


}
