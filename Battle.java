package loneDruid;

public class Battle implements Runnable {
    private Hero hero1;
    private Hero hero2;

    public Battle(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    @Override
    public void run() {
        if (!hero1.isDead())
            hero2.heroAttackTo(hero1);
    }
}
