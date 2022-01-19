package loneDruid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mystack<T> {
    List<T> list = new ArrayList<T>();

    public synchronized T pull() {
        while (list.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return list.remove(list.size() - 1);
    }

    public synchronized void push(T t) {
        while (list.size() >= 200) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(list.size(), t);
        notifyAll();
    }

    public T peek() {
        return list.get(list.size() - 1);
    }
    public T get(int index) {
        return list.get(index);
    }
    public int size() {
        return list.size();
    }
}
