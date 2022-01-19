package loneDruid;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Anti_Mage {

    public static void main(String[] args) {
        final Hero antiMage = new Hero("antiMage", 50, 10);
        antiMage.hhp.addAndGet(30);
        Anti_Mage xt = new Anti_Mage();
        Thread[] threadList = new Thread[1000];
        for(int i = 0;i< threadList.length;i++) {
            Thread t1 = new Thread() {
                public void run() {
                    antiMage.hurtx();
                    System.out.println(antiMage.hhp);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            threadList[i] = t1;
        }
        Thread[] threadList2 = new Thread[1000];
        for(int i = 0;i< threadList2.length;i++) {
            Thread t2 = new Thread() {
                public void run() {
                    antiMage.recoverx();
                    System.out.println(antiMage.hhp);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadList2[i] = t2;
        }
        for (Thread tt :
                threadList) {
            tt.run();
        }
        for (Thread tt :
                threadList2) {
            tt.run();
        }
        }

    

    public void recover(Hero hero) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger hero_Hp = new AtomicInteger((int) hero.hp);
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    lock.lock();
                    while (hero.hp >= 123) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                    hero.hp = hero_Hp.incrementAndGet();
                    System.out.println(hero.name + "---" + hero.hp);
                    lock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
    }

    public void hurt(Hero hero) {
        Thread tt = new Thread() {
            Lock lock = new ReentrantLock();
            Condition condition = lock.newCondition();
            AtomicInteger hero_hp = new AtomicInteger((int) hero.hp);

            public void run() {
                while (true) {
                    lock.lock();
                    while (hero.hp <= 0) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }

                    }
                    hero.hp = hero_hp.decrementAndGet();
                    System.out.println(hero.name + "---" + hero.hp);
                    lock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        tt.start();
    }

    public synchronized void hurtx(Hero hero) {
        Thread tt = new Thread() {
            public void run() {
                while (true) {
                    AtomicInteger hero_hp = new AtomicInteger((int) hero.hp);
                    while (hero.hp <= 0) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    hero.hp = hero_hp.decrementAndGet();
                    System.out.println(hero.hp);
                }
            }
        };
        tt.start();
    }

    public synchronized void recoverx(Hero hero) {
        Thread tt = new Thread() {
            public void run() {
                while (true) {
                    AtomicInteger hero_hp = new AtomicInteger((int) hero.hp);
                    while (hero.hp >= 123) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    hero.hp = hero_hp.incrementAndGet();
                    System.out.println(hero.hp);
                }
            }
        };
        tt.start();
    }

}
