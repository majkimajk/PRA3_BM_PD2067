package zad2;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by majki on 11.05.2016.
 */
public class MyListModel extends AbstractListModel {

    private Vector v = new Vector();



    @Override
    public int getSize() {
        return v.size();
    }

    @Override
    public Object getElementAt(int index) {
        return v.elementAt(index);
    }

    public void add(int index, Object o) {
        v.insertElementAt(o, index);
        fireIntervalAdded(this, index, index);
    }

    public void add(Object o) {
        add(getSize(), o);

    }
    public void remove(int index) {

        v.removeElementAt(index);
        fireIntervalAdded(this, index, index);
    }
}
