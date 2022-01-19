package loneDruid;

public class Battleground {
    public static void main(String[] args) {
        Hero mercy = new Hero("mercy", 30, 300);
        Hero axe = new Hero("Axe", 20, 200);

        Thread t1 = new Thread() {
            public void run() {
                    while (!axe.isDead()) {
                for (int i = 0; i < 3; i++) {
                    if(axe.isDead())
                        break;
                        System.out.println("unleash第" + (i+1) + "次");
                        mercy.heroAttackTo(axe);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        for(int i =0;i<100;i++){
            System.out.println("haha");
        }
    }
}
