package loneDruid;

public class Consumers extends Thread {
    MMstack<Character> stack;

    public Consumers(MMstack<Character> stack, String name) {
        super(name);
        this.stack = stack;
    }

    public Consumers() {
    }

    public void shop() {
        System.out.println("弹出⏏️:" + stack.pull());
    }

    public void run() {
        while (true) {
            System.out.println("弹出⏏️:" + stack.pull());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

