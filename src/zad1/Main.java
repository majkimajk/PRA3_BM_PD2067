/**
 * @author Baran Michał PD2067
 */

package zad1;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main() {
        JList list = new JList(new MyModel());
        JScrollPane scroll = new JScrollPane(list);
        JFrame f = new JFrame();
        GridLayout lay = new GridLayout();
        f.setLayout(lay);
        f.setVisible(true);
        f.add(scroll);
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
