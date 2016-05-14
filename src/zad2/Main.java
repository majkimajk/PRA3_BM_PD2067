/**
 * @author Baran Michał PD2067
 */

package zad2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public Main() {

        JFrame f = new JFrame();
        GridLayout lay = new GridLayout();
        f.setLayout(lay);

        MyListModel mm = new MyListModel();
        JList list = new JList(mm);

        JTextArea area = new JTextArea();
        Action actionDoListy = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doListy = area.getText();
                mm.add(doListy);
            }
        } ;
        area.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), actionDoListy);


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
