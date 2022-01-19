package loneDruid;

public class Intelligence extends Hero{
    int intelligent;
    public Intelligence(){}

    public Intelligence(String name){
        this.name = name;
    }
    public Intelligence(int attack){
        this.attack = attack;
    }

    public Intelligence(String name,int attack){
        this.attack = attack;
        this.name = name;
    }

}
