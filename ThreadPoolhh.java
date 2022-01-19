package loneDruid;

import java.util.LinkedList;

public class ThreadPoolhh {
    //准备一个构造器引用对象直接会生成十个消费线程
    int threadpoolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();

    public ThreadPoolhh(long ordernumber) {
        threadpoolSize = 10;
        synchronized (tasks) {
            for (int i = 0; i < threadpoolSize; i++) {
                new TaskConsumeThread("汉堡王员工" + i,ordernumber).start();
            }
        }
    }

    //加入任务容器
    public void add(Runnable r) {
        synchronized (tasks) {

            tasks.add(r);
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name,long ordernumber) {
            super(name);
            this.ordernumber = ordernumber;
        }

        long ordernumber ;
        Runnable task;


        public void run() {
            System.out.println("打卡上班：" + this.getName());

            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            //一开始没有写tasks
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //没想到的一点 接收了弹出的任务然后又run（）；
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "收到订单开始制作");
                task.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
