package loneDruid;

public class Producer extends Thread implements Runnable{
    //占地方的Stack
    private Mystack<Character> mystack;

    public Producer(Mystack<Character> mystack) {
        this.mystack = mystack;
    }

    public char alphabet() {
        String str = "";
        for (short i = 'A'; i <= 'Z'; i++) {
            str += (char) i;
        }
        char temp = str.charAt((int) (Math.random() * str.length()));
        return temp;
    }

    public void run() {
        while (true) {
            char screen = alphabet();
            System.out.println("压入--" + screen);
            mystack.push(screen);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

