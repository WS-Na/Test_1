package loneDruid;

public class tenet {
    public static void main(String[] args) {
        Hero abaddon = new Hero("abaddon", 20, 31);
        Thread t1 = new Thread() {
            public void run() {
               while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t4 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t5 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t6 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t7 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t8 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t9 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t10= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t11= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t12= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t13= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t14= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };  Thread t15= new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while(true) {
                    abaddon.hurt();
                    System.out.println("现在亚巴顿血量为" + abaddon.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                while (true) {
                abaddon.recover();
                System.out.println("现在亚巴顿血量为" + abaddon.hp);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        };
        t1.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
t2.start();
t3.start();
    }
}