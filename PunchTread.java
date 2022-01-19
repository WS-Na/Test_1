package loneDruid;

public class PunchTread extends Thread {
    private Hero hero1;
    private Hero hero2;

    public PunchTread(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public void run() {
        for (; !hero2.isDead(); ) {
            hero1.heroAttackTo(hero2);
        }

    }

}
