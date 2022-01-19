package loneDruid;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.TreeSet;

public class Comparabletest implements Comparator {
    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 > 0 ? 1 : -1;
            }
        };
        Set<Integer> treeSet = new TreeSet<>(c);
        List<Lycan> list = new ArrayList<>();
        Map<Lycan, List<Lycan>> ls = new HashMap<>();
        List<TreeSetTest> trees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lycan a = new Lycan((int) (Math.random() * 100));
            list.add(a);
            treeSet.add((int) (Math.random() * 100));
            trees.add(new TreeSetTest((int) (Math.random() * 100)));

        }
        Collections.sort(list, new Comparator<Lycan>() {
            @Override
            public int compare(Lycan o1, Lycan o2) {
                return 0;
            }
        });
        System.out.println(trees);
        System.out.println("--------------");
        Collections.sort(trees);
        System.out.println(trees);


    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
