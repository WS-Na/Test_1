package loneDruid;

import java.util.*;
import java.util.Collections;

public class AggregateOp {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Hero("米波" + i, (int) (Math.random() * 1000)));
        }
        String hname =
                list.stream()
                        .sorted((h1, h2) -> h2.attack - h1.attack)
                        .skip(2)
                        .map(h->h.name)
                        .findFirst()
                        .get();
        System.out.println(hname);
        Collections.sort(list, (h1, h2) -> h2.attack - h1.attack);
        System.out.println(list.get(2).name + "--" + list.get(2).attack);

    long cout =
            list.stream()
                    .count();
        System.out.println(cout);

    }
}

