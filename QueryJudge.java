package loneDruid;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class QueryJudge {
    /*当c.setAutoCommit(false);时，事务是不会提交的
只有执行使用 c.commit(); 才会提交进行

设计一个代码，删除表中前10条数据，但是删除前会在控制台弹出一个提示：
是否要删除数据(Y/N)
如果用户输入Y，则删除
如果输入N则不删除。
如果输入的既不是Y也不是N，则重复提示
*/
    //建立连接并使用setautocommit控制
    public static void main(String[] args) {
        judge();

    }

    public static void judge() {
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
                Statement st = c.createStatement();
                Scanner scanner = new Scanner(System.in);
        ) {
            String sqlQue = "select * from hero limit 0,10";
            ResultSet rs = st.executeQuery(sqlQue);
            c.setAutoCommit(false);
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("试图删除id=" + id + "的数据");
                s.execute("delete from hero where id=" + id);
            }
            //建立用户输入界面
            while(true) {
                System.out.println("是否删除y/n");
                String ynchar = scanner.next();
                if (ynchar.toLowerCase().equals("y") || ynchar.toLowerCase().equals("yes")) {
                    c.commit();
                    break;
                }
                else if (ynchar.toLowerCase().equals("n") || ynchar.toLowerCase().equals("no")) {
                    System.out.println("放弃删除");
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
