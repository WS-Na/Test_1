package loneDruid;

public class myHashcode {
    public static int myhc(String str){
        if(str == null)
            return 0;
        int a =0;
        char[] ab =str.toCharArray();
        for(int i= 0 ;i<str.length();i++){
            a +=(int)ab[i];
        }
        a= a*23;
        a=a<0?-a:a;
        a = a%2000;
        return a;
    }















}
