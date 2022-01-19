package loneDruid;

public class Consumer extends Thread implements Runnable{
    private Mystack<Character> mystack;

    public Consumer(Mystack<Character> mystack) {
    //    super(name);
        this.mystack = mystack;

    }

    public void run() {
        while (true){
            System.out.println("弹出--"+mystack.pull());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
