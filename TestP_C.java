package loneDruid;

public class TestP_C {
    public static void main(String[] args) {
        MMstack<Character> stack = new MMstack<>();
        new Producers(stack ,"meepo1").start();
        new Producers(stack,"meepo2").start();
        new Producers(stack,"meepo3").start();
        new Producers(stack,"meepo4").start();

        new Consumers(stack ,"Consumer1").start();
        new Consumers(stack ,"Consumer2").start();
        new Consumers(stack ,"Consumer3").start();
    }
}
