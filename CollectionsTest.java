package loneDruid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> zlist = new ArrayList<>();
        zlist.add(3);
        zlist.add(1);
        zlist.add(4);
        String fin = zlist.toString();
        double n=0;
        int time =1000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //shuffle
        for(int i =0;i<time;i++) {
            Collections.shuffle(list);
            String temp = list.toString();
            temp = temp.substring(0, 8) + "]";
            if (fin.equals(temp)) {
                n++;
            }
        }
        double d =(n/(double)time)*100d;
        System.out.println("打印后出现的概率为"+d+'%');
    }
}
