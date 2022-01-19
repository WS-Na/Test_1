package loneDruid;

import java.util.Random;

public class Producers extends Thread {
   MMstack<Character> stack ;
   public Producers(MMstack<Character> stack,String name){
       super(name);
       this.stack = stack;
   }
public Producers() {}

   public void work() {
       Random r = new Random();
       stack.push((char)(r.nextInt(26)+65));
       System.out.println("压入😊:"+stack.peek());

   }

   public void run() {
       while(true) {
           Random r = new Random();
           stack.push((char)(r.nextInt(26)+65));
           System.out.println("压入😊:"+stack.peek());
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
}
