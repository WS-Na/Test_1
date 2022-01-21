package loneDruid;

public class Clears {
    static {
        getName(
                "静态块中"
        );
    }
    {
        getName(
                "块中"
        );
    }
    static String fsd = getName("声明");
    public Clears(){
        getName(
                 "构造函数中"
        );
    }

    public static void main(String[] args) {
       Clears c = new Clears();
        System.out.println("------");
        System.out.println(c.fsd);
    }
    public static String getName(String str){
       String result = "fsd:"+str ;
        System.out.println(result);
        return result;
    }

}
