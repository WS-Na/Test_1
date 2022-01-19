package loneDruid;

public class concurrency {
    public static void main(String[] args) throws InterruptedException {
        Hero abaddon = new Hero("abaddon",10000,10000);
        System.out.println("我是狼人我有"+abaddon.hp+"雪🩸");

        int n =10000;
        Thread[] addThread1 = new Thread[n];
        Thread[] addThread2 = new Thread[n];
        for(int i = 0; i<n;i++) {
        Thread ti1 =new Thread(){
            public void run() {
                abaddon.recover();
            }
        };
        ti1.start();
        addThread1[i]=ti1;
        }
        for(int i = 0; i<n;i++) {
            Thread ti2 = new Thread() {
                public void run() {
                    abaddon.hurt();
                }
            };
            ti2.start();
            addThread2[i]=ti2;
        }
        for (Thread t:
             addThread1) {
           t.join();
        }
        for (Thread t:
             addThread2) {
           t.join();
        }
        System.out.println("在增加和减少了10000个线程后血量为"+abaddon.hp);
    }
}
