package loneDruid;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import static loneDruid.myHashcode.myhc;

public class MyHashMap implements IHashMap{
    //创建一个链表数组
    LinkedList<Lycan>[] lhm = new LinkedList[2000];

    //put(),get()方法的实现
    public void put(String key,Object value){
        //获取hashcode值
        int hashcode = myhc(key);
        //找到对应的list
        LinkedList<Lycan> list  =lhm[hashcode];
        //如果list是空就说明没有里面没有值
        if(null == list){
            list= new LinkedList<>();
            lhm[hashcode] = list;
        }
        boolean node = false;
        for(Lycan e:list) {
            if (key.equals(e.key)) {
                e.value = value;
                node = true;
                break;
            }
        }
            if(!node){
                Lycan lycan = new Lycan(key,value);
                list.add(lycan);
            }
        }

    public Object get(String key) {
        int hashcode = myhc(key);
        LinkedList<Lycan> list = lhm[hashcode];
        if(null==list)
            return null;
        Object result = null;

        for (Lycan e : list) {
            //key用的是String方法
            if (key.equals(e.key)) {

                result = e.value;
            }
        }
            return result;
    }
    public String toString(){
        LinkedList<Lycan> lycans = new LinkedList<>();
        for(LinkedList<Lycan> e:lhm){
            if(null ==e)
                continue;
            lycans.addAll(e);
    }
        return lycans.toString();
        }
}
