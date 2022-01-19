package loneDruid;

public class Strength extends Hero{
    int Power;
    public Strength(){}

    public Strength(String name){
        this.name = name;
    }
    public Strength(int attack){
        this.attack = attack;
    }

    public Strength(String name,int attack){
        this.attack = attack;
        this.name = name;
    }

}
