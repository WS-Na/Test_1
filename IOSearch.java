package loneDruid;

import java.io.*;

public class IOSearch extends Thread{

private File file;
private String str;
public IOSearch(File file,String str){
    this.file=file;
    this.str=str;
}
    //将字符串和文件字符串进行比较
    public  void run(){
        String fileString = fileToString();
        while(fileString.contains(str))
            System.out.printf("在%s中有相同字符串",file.getName());
    }
    //将所有文件读到字符串中
    public String fileToString() {
        try (FileReader allTheFile = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            allTheFile.read(chars);
        return new String(chars);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
    File f = new File("/Users/naweishuai/Documents/workspace/newstart/src");
        IOSearch ioSearch = new IOSearch(f,"sgg");
    }
}
