package loneDruid;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Hero {
    String name;
    int attack;
    float hp;
    AtomicInteger hhp = new AtomicInteger();
    static String copyright ;

    public static String getCopyright() {
        return copyright;
    }

    public static void setCopyright(String copyright) {
    }

    public AtomicInteger getHhp() {
        return hhp;
    }

    public void setHhp(AtomicInteger hhp) {
        this.hhp = hhp;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由value公司所有";
    }

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(int attack) {
        this.attack = attack;
    }

    public Hero(String name, int attack) {
        this.attack = attack;
        this.name = name;
    }

    public Hero(String name, int attack, int hp) {
        this.attack = attack;
        this.name = name;
        this.hp = hp;
    }

    public Hero(int attack, int hp) {
        this.attack = attack;
        this.hp = hp;
    }

    public boolean isDead() {
        return this.hp > 0 ? false : true;
    }

    public static boolean heroSearch(Hero one) {

        return (one.attack > 8 && one.hp > 6);
    }

    public synchronized void recover() {

        this.hp++;
        if (this.hp >= 31) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void hurt() {
        synchronized (this) {
            while (this.hp <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.hp--;
            this.notify();


        }
    }

    public int heroPunch(Hero h1) {
        return h1.attack;
    }

    public void heroAttackTo(Hero hero) {
        hero.hp -= this.attack;
        System.out.printf("%s正在攻击%s，%s的血量现在是%d%n", this.name, hero.name, hero.name, hero.hp);
        if (hero.isDead())
            System.out.println(hero.name + "已阵亡");
    }

    public static int heroCompare(Hero h1, Hero h2) {
        return h1.attack - h2.attack;
    }

    public static void iteger(List<? extends Hero> list) {
        for (Hero e : list) {
            System.out.printf("英雄%s有%d点攻击力%n", e.name, e.attack);
        }
    }

    public void recoverx() {
        hhp.incrementAndGet();
    }

    public void hurtx() {
        hhp.decrementAndGet();
    }
}
