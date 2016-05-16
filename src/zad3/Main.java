/**
 * @author Baran Michał PD2067
 */

package zad3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Main {

    public Main() {


        JFrame f = new JFrame();
        GridLayout lay = new GridLayout(0, 1);
        f.setLayout(lay);


        MyTableModel mm = new MyTableModel("aaa.txt");
        JTable table = new JTable(mm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowHeight(100);

        JButton dodaj = new JButton();
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        dodaj.setSize(10, 10);
        JButton usun = new JButton();


        f.add(scrollPane);
        f.add(dodaj);
        f.add(usun);
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main());

    }
}
