package loneDruid;

import java.util.*;

public class Heal {


    public static void main(String[] args) {
        HashSet<String> hs = new HashSet();
        for(int i =0;i<100;i++) {
            hs.add(randomCharArray());
        }
        for(Iterator<String> i = hs.iterator();i.hasNext();){
            System.out.println(i.next());
        }

       System.out.println(100-hs.size());
    }


    public static String randomCharArray() {
        Random r = new Random();
        char[] cr = new char[] {
                ( (char) (r.nextInt(26) + 96)), ((char)(r.nextInt(26) + 96))};
        String str = String.copyValueOf(cr);
        return str;
    }

}
