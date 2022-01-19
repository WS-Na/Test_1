package loneDruid;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Mystack<Character> mystack = new Mystack<>();
        Thread t10 = new Thread() {
            public void run() {
                new Producer(mystack).run();


            }

        };
        Thread t11 = new Thread() {
            public void run() {
                new Producer(mystack).run();


            }

        };
        Thread t20 = new Thread() {
            public void run() {
                new Consumer(mystack).run();
            }
        };
        Thread t21 = new Thread() {
            public void run() {
                new Consumer(mystack).run();
            }
        };
        Thread t22 = new Thread() {
            public void run() {
                new Consumer(mystack).run();
            }
        };
        t20.start();
        t10.start();
        t11.start();
        t21.start();
        t22.start();

        for (int i = 0; i < mystack.size(); i++) {
            System.out.println(mystack.get(i));
        }
    }
}