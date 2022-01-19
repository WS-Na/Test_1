package loneDruid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;



public class Xmas {
    public static void main(String[] args) {

        Supplier<List> spu = new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList<>();
            }
        };
        List<Hero> list= Xmas.getList(spu);
        System.out.println(list);

        List<Hero> l2 = getList(()->new ArrayList<>());









    }
    public static List getList(Supplier<List> sups){
                return sups.get();
    }
}
