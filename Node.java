package loneDruid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Node<T>{
    public Node<T> leftNode;
    public Node<T> rightNode;
    public T value;

    public void add(T t){
        if(null == value)
            this.value = t;
        else {
            if ((Integer) this.value - (Integer) t >= 0) {
                if (leftNode == null)
                    leftNode = new Node<T>();
                leftNode.add(t);
            }
            if ((Integer) this.value - (Integer) t < 0) {
                if (rightNode == null)
                    rightNode = new Node<T>();
                rightNode.add(t);
            }
        }
    }
    public List<T> values(){
        List<T> values = new ArrayList<>();
        if(leftNode!=null)
        values.addAll( leftNode.values());
        values.add(value);
        if(rightNode!=null)
        values.addAll( rightNode.values());
        return values;
    }


    public static void main(String[] args) {
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node<Integer> nodes = new Node<>();
        for(int i :randoms){
            nodes.add(i);
        }
        System.out.println(nodes.values());
    }
}
