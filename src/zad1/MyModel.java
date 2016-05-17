package zad1;

import javax.swing.*;

/**
 * Created by majki on 11.05.2016.
 */
public class MyModel extends AbstractListModel {
    int start;
    int finish;

    MyModel() {

        start = -70;
        finish = 61;

    }

    @Override
    public int getSize() {
        return finish - start;
    }

    @Override
    public Object getElementAt(int index) {
        int celc = start + index;
        int fahr = 9*celc/5 + 32;

        String pozycja = celc +" stopni C = " + fahr +  "stopni F";

        return pozycja;
    }
}
