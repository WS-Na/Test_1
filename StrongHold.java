package loneDruid;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StrongHold {
    public static void main(String[] args) {
        Lock sentryTower_1 = new ReentrantLock();
        Lock sentryTower_2 = new ReentrantLock();
        Lock sentryTower_3 = new ReentrantLock();
        Thread t1 = new Thread() {
            public void run() {
                boolean drowRanger = false;
                boolean emberSpirit = false;
                boolean morphling = false;
                try {
                    drowRanger = sentryTower_1.tryLock();
                    if (drowRanger) {
                        System.out.println("卓尔游侠攻占了哨塔1号站");
                        Thread.sleep(1000);
                        System.out.println("火猫试图攻占2号哨塔🔥");
                        try {
                            emberSpirit = sentryTower_2.tryLock(10, TimeUnit.SECONDS);
                            if (emberSpirit) {
                                System.out.println("火猫🔥攻占2号哨塔");
                                Thread.sleep(1000);
                                System.out.println("水人💧试图攻占3号哨塔");
                                try {
                                    morphling = sentryTower_3.tryLock(10, TimeUnit.SECONDS);
                                    if (morphling) {
                                        System.out.println("水人💧攻占3号哨塔");
                                        Thread.sleep(1000);
                                    } else {
                                        System.out.println("水人没有攻下3号哨塔");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {
                                    if(morphling) {
                                        sentryTower_3.unlock();
                                        System.out.println("水人释放3号哨塔");
                                    }
                                }
                            } else {
                                System.out.println("火猫🔥没有攻下2号哨塔");
                                try {
                                    System.out.println("水人💧试图攻占3号哨塔");
                                    morphling = sentryTower_3.tryLock(10, TimeUnit.SECONDS);
                                    if (morphling) {
                                        System.out.println("水人💧攻占3号哨塔");
                                        Thread.sleep(1000);
                                    } else {
                                        System.out.println("水人没有攻下3号哨塔");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {
                                    if(morphling) {
                                        sentryTower_3.unlock();
                                        System.out.println("水人释放3号哨塔");
                                    }
                                    }
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            if(emberSpirit){
                                sentryTower_2.unlock();
                                System.out.println("火猫🔥释放2号哨塔");
                            }
                        }

                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } finally {
                    sentryTower_1.unlock();
                    System.out.println("卓尔游侠释放1号哨塔");
                }
            }
        };

            Thread t2 = new Thread() {
                public void run() {
                    boolean tusk= false;
                    boolean abaddon= false;
                    boolean timersaw= false;
                    try {
                        tusk= sentryTower_2.tryLock();
                        if (tusk) {
                            System.out.println("Tusk攻占了哨塔2号站");
                            Thread.sleep(1000);
                            System.out.println("Abddon试图攻占3号哨塔🔥");
                            try {
                                abaddon= sentryTower_3.tryLock(10, TimeUnit.SECONDS);
                                if (abaddon) {
                                    System.out.println("Abaddon攻占3号哨塔");
                                    Thread.sleep(1000);
                                    System.out.println("timersaw试图攻占1号哨塔");
                                    try {
                                        timersaw= sentryTower_1.tryLock(10, TimeUnit.SECONDS);
                                        if (timersaw) {
                                            System.out.println("timersaw攻占1号哨塔");
                                            Thread.sleep(1000);
                                        } else {
                                            System.out.println("timersaw没有攻下1号哨塔");
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } finally {
                                        if (timersaw) {
                                            sentryTower_1.unlock();
                                            System.out.println("timersaw释放1号哨塔");
                                        }
                                    }
                                } else {
                                    System.out.println("abaddon没有攻下3号哨塔");
                                    try {
                                        System.out.println("timersaw试图攻占1号哨塔");
                                        timersaw= sentryTower_1.tryLock(10, TimeUnit.SECONDS);
                                        if (timersaw) {
                                            System.out.println("timersaw攻占3号哨塔");
                                            Thread.sleep(1000);
                                        } else {
                                            System.out.println("timersaw没有攻下3号哨塔");
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } finally {
                                        if(timersaw){
                                            sentryTower_1.unlock();
                                            System.out.println("timersaw释放1号哨塔");
                                        }

                                    }
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                if(abaddon) {
                                    sentryTower_3.unlock();
                                    System.out.println("Abaddon释放3号哨塔");
                                }

                            }

                        }
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }finally {
                        sentryTower_2.unlock();
                        System.out.println("tusk释放2号哨塔");
                    }
                }
            };

        Thread t3 = new Thread() {
            public void run() {
                boolean invoker= false;
                boolean jakiro= false;
                boolean leshrac= false;
                try {
                    invoker= sentryTower_3.tryLock();
                    if (invoker) {
                        System.out.println("invoker攻占了哨塔3号站");
                        Thread.sleep(1000);
                        System.out.println("jakiro试图攻占1号哨塔🔥");
                        try {
                            jakiro= sentryTower_1.tryLock(10, TimeUnit.SECONDS);
                            if (jakiro) {
                                System.out.println("jakiro攻占1号哨塔");
                                Thread.sleep(1000);
                                System.out.println("leshrac试图攻占2号哨塔");
                                try {
                                    leshrac= sentryTower_2.tryLock(10, TimeUnit.SECONDS);
                                    if (leshrac) {
                                        System.out.println("leshrac攻占2号哨塔");
                                        Thread.sleep(1000);
                                    } else {
                                        System.out.println("leshrac没有攻下2号哨塔");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {
                                    if(leshrac){
                                        sentryTower_2.unlock();
                                        System.out.println("leshrac释放2号哨塔");
                                    }
                                }
                            } else {
                                System.out.println("jakiro没有攻下1号哨塔");
                                try {
                                    System.out.println("leshrac试图攻占2号哨塔");
                                    leshrac= sentryTower_2.tryLock(10, TimeUnit.SECONDS);
                                    if (leshrac) {
                                        System.out.println("leshrac攻占2号哨塔");
                                        Thread.sleep(1000);
                                    } else {
                                        System.out.println("leshrac没有攻下2号哨塔");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {
                                    if(leshrac){
                                        sentryTower_2.unlock();
                                        System.out.println("leshrac释放2号哨塔");
                                    }

                                }
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            if(jakiro) {
                                sentryTower_1.unlock();
                                System.out.println("jakiro释放1号哨塔");
                            }
                        }

                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }finally {
                    sentryTower_3.unlock();
                    System.out.println("invoker释放3号哨塔");
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}