package loneDruid;

public class PunchMan {
    private int id;
    private String name ;
    private float hp;
    private int damage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public float getHp() {
        return hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
