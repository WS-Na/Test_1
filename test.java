package loneDruid;

import java.io.File;
import java.util.Locale;

import static com.sun.activation.registries.LogSupport.log;

public class test {
    static NewThreadPool poolThread = new NewThreadPool();
    public static void searchtt(File file, String str) {;
        if(file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java")) {
            FileSearchTest fileSearchTest = new FileSearchTest(file, str);
            poolThread.add(fileSearchTest);
        }
        }
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file_1:
                     files) {
                    searchtt(file_1,str);
                }
            }
        }
    }
    public static void main(String[] args) {
        log("pvttrc");
searchtt(new File("/Users/naweishuai/Desktop/dygo"),"cat");
    }

}
