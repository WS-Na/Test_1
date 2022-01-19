package loneDruid;

public class Lycan implements Comparable<Lycan>{
    public Object key;
    public Object value;
    public String name;
    public int attack;
    public int hp;
    public Lycan(String key,Object value){
        super();
        this.key = key;
        this.value =value;
    }
    public Lycan(){}
    public Lycan(String name){
        this.name = name;
        this.key = name;
    }
    public Lycan(String name,int attack,int hp){
        this.name = name;
        this.attack = attack;
        this.hp=hp;
    }
    public Lycan(int attack){
        this.attack=attack;
    }

    @Override
    public int compareTo(Lycan o) {
        return  this.attack>o.attack?1:-1;
    }

    public  String toString(){
        //健值对
        //return "[key="+key+"value="+value+"]";
        return String.valueOf(this.attack);
    }




}
