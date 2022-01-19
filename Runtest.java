package loneDruid;

import java.io.File;
import java.util.Locale;

public class Runtest {
    public static void main(String[] args) {
        File files = new File("/Users/naweishuai/Desktop/dygo");
        sreachStr(files,"dota2");
    }

    public static void sreachStr(File file, String str) {
        while (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java"))
                new IOSearch(file, str).start();
        }
        if(file.isDirectory()){
            File[] flist =file.listFiles();
            for(File file1 :flist)
                sreachStr(file1,str);
        }
    }


}
