package loneDruid;
import java.util.*;

public class TreeSetTest implements Comparable<TreeSetTest>{
        public int attack;
    public TreeSetTest(int attack){
        this.attack = attack;
    }

    public int compareTo(TreeSetTest o) {
        //return this.attack-o.attack;
        return 1;
    }

    public String toString(){
        return String.valueOf(this.attack);
    }
}
