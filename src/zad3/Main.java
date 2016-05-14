/**
 *
 *  @author Baran Michał PD2067
 *
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


    try {
      JTable table = new JTable(new MyTableModel());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }


    f.setVisible(true);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> new Main());

  }
}
