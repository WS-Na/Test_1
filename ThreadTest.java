package loneDruid;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Hero Tusk = new Hero("Tusk", 1, 600);
        Hero viper = new Hero("viper", 1, 600);
        Hero spirit = new Hero("spirit", 1, 600);
        Hero earthShaker = new Hero("earthShaker", 1, 600);
        Thread t1 = new Thread() {
            public void run() {
                while (!viper.isDead())
                    Tusk.heroAttackTo(viper);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (!earthShaker.isDead())
                    Thread.yield();
                spirit.heroAttackTo(earthShaker);
            }
        };
        t1.start();
        t2.setDaemon(true);
        t2.start();
//        PunchTread punchTread1 = new PunchTread(Tusk, viper);
//        PunchTread punchTread2 = new PunchTread(spirit, earthShaker);
//        punchTread1.setPriority(5);
//        punchTread2.setPriority(5);
//        punchTread1.sleep(10000);
//        punchTread1.start();
//        try{
//            punchTread1.join();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        punchTread2.start();
//        punchTread2.yield();
//        try {
//            punchTread1.join();
//            System.out.println("---");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Battle roundOne = new Battle(Tusk, viper);
//        new Thread(roundOne).start();
//        Battle roundTwo = new Battle(spirit, earthShaker);
//        new Thread(roundTwo).start();
//        Thread thread1 = new Thread() {
//            public void run() {
//                while (!Tusk.isDead()) {
//                    viper.heroAttackTo(Tusk);
//                }
//            }
//        };

    }

}

