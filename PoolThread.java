package loneDruid;

import java.util.List;
import java.util.ArrayList;

public class PoolThread {
    List<Thread> list = new ArrayList<>();

    public void add(Thread t1) {
        list.add(t1);
    }

    public PoolThread() {
    }

    public PoolThread(Thread t1) {
        list.add(t1);
    }

    public void start() {
        for (Thread t1 : list) {
            t1.start();
        }
    }

}
