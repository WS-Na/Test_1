package loneDruid;

public class TestThreadPool {
    public static void main(String[] args) {
        long time =0;
        ThreadPoolhh thp = new ThreadPoolhh(time);
        while(true) {
            long times = 10000;
            times = times - time<=0?0:times -time;

            long ordernumber = time;
            long finalTimes = times;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("自助点餐单号"+ordernumber);
                    try {
                        Thread.sleep(finalTimes);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thp.add(task);
            time++;

        }
    }
}