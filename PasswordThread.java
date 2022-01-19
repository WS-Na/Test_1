package loneDruid;

import java.util.ArrayList;
import java.util.List;

public class PasswordThread extends Thread {
    String password;
    List<String> list;
    boolean found = false;

    public PasswordThread(List<String> list, String password) {
        this.password = password;
        this.list = list;

    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        String password = "1D3";
        PasswordThread pa = new PasswordThread(list, password);
        pa.start();
        pa.join();
        System.out.println(list);
    }


    public void run() {
        char[] chars = new char[password.length()];
        System.out.println("这是run方法");
        generatePassword(chars, 0,password);
    }

    public void generatePassword(char[] guessPassword, String password) {
        System.out.println("这是中转方法");
        generatePassword(guessPassword, 0, password);
    }

    public void generatePassword(char[] chars, int index, String password) {
        System.out.println("------"+index);
        if (found)
            return;
        String pass = "";
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char) i;
            if (!Character.isLetterOrDigit(c))
                continue;
            chars[index] = c;
            if (index != password.length() - 1) {
                generatePassword(chars, index + 1, password);
            } else {
                pass = new String(chars);
                list.add(pass);
                if (pass.equals(password)) {
                    System.out.println("找到了密码是" + pass);
                    found = true;
                    return;
                }
            }
        }

    }
}