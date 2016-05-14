/**
 * @author Baran Michał PD2067
 */

package zad2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    public Main() {

        JFrame f = new JFrame();
        GridLayout lay = new GridLayout();

        f.setLayout(lay);

        //model listy i usuwanie alt kliknieciem
        MyListModel mm = new MyListModel();
        JList list = new JList(mm);
        //list.setBorder(BorderFactory.createBevelBorder(3));

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.isAltDown() && e.getSource() instanceof JList) {

                    JList list2 = (JList) e.getSource();
                    int index = list2.locationToIndex(e.getPoint());
                    mm.remove(index);

                }
            }
        };
        list.addMouseListener(ml);

        // textArea i action
        JTextArea area = new JTextArea();
        Action actionDoListy = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doListy = area.getText();
                mm.add(doListy);
            }
        };
        area.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), actionDoListy);


        f.add(list);
        f.add(area);


        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main());

    }
}
