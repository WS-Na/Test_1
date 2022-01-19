package loneDruid;

import loneDruid.PoolThread;

public class PunchThread {
    static Mystack<Character> mystack = new Mystack<>();
    public static void main(String[] args) {
        PoolThread poolThreads = new PoolThread();
       for(int i=0;i<10;i++) {
           poolThreads.add(toRun());
       }
Thread t2 = new Thread(){
           public void run() {

               while(true){
                   poolThreads.add(doRun());
                   try {
                       Thread.sleep(10000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
    }
};

        poolThreads.start();
        t2.start();



    }
    public static Thread toRun() {
        Thread tt = new Thread() {
            public void run() {
                new Consumer(mystack).run();
            }
        };
        return tt;
    }
    public static Thread doRun() {
        Thread tt = new Thread() {
            public void run() {
                new Producer(mystack).run();
            }
        };
        tt.start();
        return tt;
    }
    }
