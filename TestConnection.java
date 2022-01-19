package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection {
    /*
    首先初始化一个有3条连接的数据库连接池
然后创建100个线程，每个线程都会从连接池中借用连接，并且在借用之后，归还连接。 拿到连接之后，执行一个耗时1秒的SQL语句。

运行程序，就可以观察到如图所示的效果
     */
    public static void main(String[] args) {
        long poolCStart = System.currentTimeMillis();
        ConnectionPool cp = new ConnectionPool(10);
        long poolCEnd= System.currentTimeMillis();
        System.out.println("连接池创建时间花费："+(poolCEnd-poolCStart));
        System.out.println("-------------------");
        long poolStart = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread() {
                public void run() {
                    String sql = "insert into hero values(null,?,?,?)";
                    Connection c = cp.getConnection();
                    try (
                            PreparedStatement ps = c.prepareStatement(sql);
                    ) {
                        ps.setString(1, "火猫");
                        ps.setFloat(2, (float) (Math.random() * 100f));
                        ps.setInt(3, (int) (Math.random() * 10));
                        ps.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cp.returnConnection(c);
                }
            };
            t.start();
        }
        long poolEnd = System.currentTimeMillis();
        System.out.println("Pool: " + (poolEnd - poolStart));
        System.out.println("--------------------------");

        long noStart= System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread tt = new Thread() {
                public void run() {
                    String sql = "insert into hero values(null,?,?,?)";
                    try (
                            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                            PreparedStatement ps = c.prepareStatement(sql);
                    ) {
                        ps.setString(1, "蓝猫");
                        ps.setFloat(2, (float) (Math.random() * 100f));
                        ps.setInt(3, (int) (Math.random() * 10));
                        ps.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };
            tt.start();
        }
        long noEnd = System.currentTimeMillis();
        System.out.println("normal : "+(noEnd-noStart));
    }
}
