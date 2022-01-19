package loneDruid;

public class Agile extends Hero{
    int agility;
    public Agile(){
        super();
    }


    public Agile(String name){
        this.name = name;
    }
    public Agile(int attack){
        this.attack = attack;
    }

    public Agile(String name,int attack){
        this.attack = attack;
        this.name = name;
    }


}
