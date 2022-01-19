package loneDruid;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MMstack<T> {
    LinkedList<T> list = new LinkedList<T>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void push(T t) {
        try {
            lock.lock();
            while(list.size()>=100) {
                try {
                    condition.await(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(t);
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public T pull() {
        try {
            lock.lock();
            while (list.size()==0) {
                try {
                    condition.await(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T c = list.removeLast();
            condition.signalAll();
            return c;
        } finally {
            lock.unlock();
        }

    }

    public T peek() {
        if(list.size()==0)
            return null;
        return list.getLast();
    }

    public String toString() {
        return list.toString();
    }
    public int size() {
        return list.size();
    }
}
