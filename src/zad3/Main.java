/**
 * @author Baran Michał PD2067
 */

package zad3;


import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {

    public Main() {


        JFrame f = new JFrame("JTable z książkami");

        //wczytanie pliku z danymi

        MyTableModel mm = new MyTableModel(System.getProperty("user.home") + "/aaa.txt");


        JTable table = new JTable(mm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowHeight(70);

//button do dodawani wiersza

        JButton dodaj = new JButton("Dodaj wiersz");
        String[] daneWiersza = new String[4];
        dodaj.addActionListener(e -> {


            daneWiersza[0] = JOptionPane.showInputDialog("Podaj autora:");
            daneWiersza[1] = JOptionPane.showInputDialog("Podaj tytuł:");
            daneWiersza[2] = JOptionPane.showInputDialog("Podaj cenę:");
            daneWiersza[3] = JOptionPane.showInputDialog("Podaj nazwę pliku okładki:");
            mm.addRow(daneWiersza);

        });

        dodaj.setSize(10, 10);

        //button do usuwania wiersza

        JButton usun = new JButton("Usuń zaznaczony wiersz");
        usun.addActionListener(e -> {
            int rowDoUsuniecia = -1;
            rowDoUsuniecia = table.getSelectedRow();
            if (rowDoUsuniecia != -1) {
                mm.removeRow(rowDoUsuniecia);
            }
        });

        // japnel na buttony

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(f.getWidth(), 50);
        panel.add(dodaj);
        panel.add(usun);

        //dodanie tabeli i panelu z buttonami do głównego frame'a'

        f.add(scrollPane, BorderLayout.CENTER);
        f.add(panel, BorderLayout.PAGE_END);
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main());

    }
}
