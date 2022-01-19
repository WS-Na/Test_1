package loneDruid;

import sun.text.normalizer.UCharacter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class FileSearchTest implements Runnable{
    private File file;
    private String search;
    public FileSearchTest(File file,String search) {
        this.file = file;
        this.search = search;
    }

    public void run() {
String fileSearchRun = FileSearch(file);
if(fileSearchRun.contains(search)) {
    System.out.printf("线程:%s已经在%s文件中找到包含%s的文件",Thread.currentThread().getName(),file.getName(),search);
}

        }
public String FileSearch(File file) {
    try(
            FileReader fileReader = new FileReader(file) ;
            ) {char[] all = new char[(int)file.length()];
        fileReader.read(all);
        return new String(all);

    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
    }

