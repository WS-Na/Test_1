package loneDruid;

public class Tvno {


    public static void main(String[] args) {
    Hero abaddon = new Hero("abaddon", 350, 5000);
    Hero pudge = new Hero("Pudge", 100, 300);
    Hero timersaw = new Hero("Timersaw", 320, 3288);
    Thread t1 = new Thread() {
        public void run() {
            System.out.println("t1正在占有亚巴顿");
            synchronized (abaddon) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (pudge){
                System.out.println("t2正在占有屠夫");
            }
        }
    };
    Thread t2 = new Thread() {
        public void run() {
            System.out.println("t2正在占有屠夫");
            synchronized (pudge) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            synchronized (abaddon){
                System.out.println("t2正在占有伐木机");
            }
            }
        }
    };
    Thread t3 = new Thread() {
        public void run() {
            System.out.println("t3正在占有伐木机");
            synchronized (timersaw) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            synchronized (abaddon){
                System.out.println("t3正在占有亚巴顿");
            }
            }
        }
    };
        t1.start();
        t2.start();
        t3.start();
    }
}