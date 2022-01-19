package loneDruid;

import java.sql.*;

public class Batrider {
    public static void main(String[] args) {

        long stateStart = System.currentTimeMillis();
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            for (int i = 0; i < 10000; i++) {
                String sql = "insert into user values(null,"+"'meepo"+i+"'"+","+(Math.random()*100000)+")";
                s.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        long stateEnd = System.currentTimeMillis();
        System.out.println("Statement:"+(stateEnd-stateStart));
        System.out.println("--------------");
        long PrepareStart = System.currentTimeMillis();
            String sql = "insert into user values(null,?,?)";
            try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement ps= c.prepareStatement(sql);
        ) {
            for (int i = 0; i < 10000; i++) {
                ps.setString(1,"meepo"+i);
                ps.setString(2,String.valueOf(Math.random()*1000000));
                ps.execute();

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        long PrepareEnd = System.currentTimeMillis();
        System.out.println("prepare:"+(PrepareEnd-PrepareStart));
    }
}
