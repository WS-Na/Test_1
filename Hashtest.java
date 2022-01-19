package loneDruid;

import java.util.ArrayList;
import java.util.List;

public class Hashtest {
    public static void main(String[] args) {
        List<Lycan> ls = new ArrayList<>();
        MyHashMap myStyle = new MyHashMap();
        for(int i =0 ;i<100000;i++){
            int meenum  = ((int)(Math.random()*10000));
            String str = "米波"+meenum;
            ls.add(new Lycan(str));
        }

        //普通方法查找出米波5555
        String meebo = "米波5555";
        List<Lycan> meebo5555 = new ArrayList<>();
        int n =0;
        long start1 =System.currentTimeMillis();
        for(Lycan e:ls){
            if(meebo.equals(e.name)){
                meebo5555.add(e);
                n++;
            }
        }
        long end1 =System.currentTimeMillis();
        System.out.printf("一共有%d个meebo5555%n",n);
        System.out.println(meebo5555);
        System.out.println(end1-start1+"ms");
        System.out.println("-----------------------------------------");
        //MyhashMap方法查找

        for(Lycan e:ls){
            //myStyle.get((String) e.key这句回来的是list但是这个列表现在是字符串所以把它强转会list
            List<Lycan> lycans = (List<Lycan>) myStyle.get((String) e.key);
            if(null ==lycans){
                lycans = new ArrayList<>();
                myStyle.put(e.name,lycans);
            }
            lycans.add(e);

        }
        System.out.println(myStyle.get("米波3452"));
        List<Lycan> List1 = (List<Lycan>)myStyle.get("米波7523");
        System.out.println(List1);

        System.out.println(myStyle.get("米波5555"));


        //System.out.println(ac);

    }
}
