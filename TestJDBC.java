package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        // Class.forName("com.mysql.jdbc.Driver");
//            try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8",
//                    "root", "admin");
//                 Statement s = c.createStatement();
//            ) {
//                System.out.println("连接成功，获取连接对象： " + c);
//                System.out.println("获取对象" + s);
//                for(int i = 0;i<100;i++) {
//                    String sql = "insert into hero value(null," + "'spirit breaker" +i+"'"+"," + 234.0f + "," + 35 + ")";
//                    s.execute(sql);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            for (int i = 0;i<10;i++) {

                //executex("delete from hero where id>=100");
                executex("insert into hero value(null," + "'ember_spirit" +i+"'"+"," + 234.0f + "," + 35 + ")");
                executex("update hero set name='earthShaker' where id>=100");
            }
    }
    public static  void executex(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       try(
               Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8","root", "admin");
               Statement s = c.createStatement();
               ){
           s.execute(sql);
       }catch (SQLException e) {
           e.printStackTrace();
       }
    }
}
