package loneDruid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyNode<T extends Comparable<T>> {
    private MyNode<T> leftNode;
    private MyNode<T> rightNode;
    private T value;

    public void add(T t) {
        if (null == value)
            value = t;
        else {
            if (t.compareTo(value)<=0) {
                if (null == leftNode)
                    leftNode = new MyNode<>();
                leftNode.add(t);
            }
            if (t.compareTo(value)>0) {
                if (null == rightNode)
                    rightNode = new MyNode<>();
                rightNode.add(t);
            }

        }
    }

    public List<T> values() {
        List<T> list = new ArrayList<>();
        if (null != leftNode)
            list.addAll(leftNode.values());
        list.add(value);
        if (null != rightNode)
            list.addAll(rightNode.values());
        return list;
    }

    public static void main(String[] args) {
        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        MyNode<Integer> nodes = new MyNode<>();
        for (int i : randoms) {
            nodes.add(i);
        }
        System.out.println(nodes.values());
    }
}

