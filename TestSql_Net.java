package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestSql_Net {
    /*
    首先创建一个数据库android(android现在是手机操作系统，其本意是机器人的意思)

然后创建一个表dictionary，字段：
id int
receive varchar(100)
response varchar(100)

receive 表示受到的信息
response 表示回应的信息

在这个表里准备一些数据：
     */
    public static void main(String[] args) {

    }
public static  void  insertSql(String str_receive,String response) {
    String sql = "insert into dictionary values(null,?,?)";
    try(
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ) {
       ps.setString(1,str_receive);
       ps.setString(2,response);
       ps.execute();
        System.out.println("successfully");
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/andraid?characterEncoding=UTF-8","root","admin");
}
}
