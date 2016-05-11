/**
 * @author Baran Michał PD2067
 */

package zad2;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main() {

        JFrame f = new JFrame();
        GridLayout lay = new GridLayout();
        f.setLayout(lay);

        String a = "sdsdds";

        MyListModel mm = new MyListModel();
        mm.add(a);
        JList list = new JList(mm);

        JTextArea area = new JTextArea();
        area.addComponentListener(new );


       f.add(list);
        f.add(area);



        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Main();
            }
        });

    }
}
