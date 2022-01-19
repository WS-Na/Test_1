package loneDruid;

public class TestMethod {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            public void run(){
                int time =0;
                int vv = 10;
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    vv--;
                System.out.println(time++);

            }
        };
        thread1.start();

    }
}
