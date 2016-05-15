/**
 * @author Baran Michał PD2067
 */

package zad3;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {

    public Main() {


        JFrame f = new JFrame();
        GridLayout lay = new GridLayout();
        f.setLayout(lay);


        MyTableModel mm = new MyTableModel("aaa", "bbb", "ccc", "aaa.png");
        JTable table = new JTable(mm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowHeight(300);


        f.add(scrollPane);
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main());

    }
}
