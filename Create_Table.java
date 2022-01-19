package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {
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
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/andraid?characterEncoding=UTF-8";
    private static final String USERS = "root";
    private static final String PASS = "admin";

    public static void main(String[] args) {
        try (
                Connection c = DriverManager.getConnection(DB_URL, USERS, PASS);
                Statement s = c.createStatement();
        ) {
    /*
    CREATE TABLE hero (
  id int(11) AUTO_INCREMENT,
  name varchar(30) ,
  hp float ,
  damage int(11) ,
  PRIMARY KEY (id)
)  DEFAULT CHARSET=utf8;
     */
            String sql = "CREATE TABLE meepo("
                    +"id int(11) AUTO_INCREMENT,"
                    +"receive varchar(30),"
                    +"response varchar(30),"
                    +"PRIMARY KEY (id)"
                    +") DEFAULT CHARSET =utf8";
            s.execute(sql);
            System.out.println("successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        String sql = "CREATE  andraid ("
                + "";

    }
}
