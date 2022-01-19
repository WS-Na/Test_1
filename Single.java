package loneDruid;

import java.sql.*;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Single {
    public static void main(String[] args) {
        String userName = "MonkeyKing";
        String zhangPassword = "admin1";
//        list(1);
//        System.out.println("------------");
//        list(2);
//        System.out.println("------------");
//        list(3);
        String sql = "insert into hero values(null,?,?,?) ";
        String sql1 = "select * from hero where 1>0";

        String dsql = "delete from hero where name='BeastMaster'";
        try(
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root","admin");
                PreparedStatement ps =  c.prepareStatement(sql);
                Statement s = c.createStatement();
                ){
//            ps.setString(1,"BeastMaster");
//            ps.setFloat(2,23455);
//            ps.setInt(3,2355);
//            ps.execute();
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()) {
      String name = rs.getString("name");
                System.out.println(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int count() {
        int total = 0;
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
                System.out.println(total);
            }
            return total;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static void naPa(String name, String password) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();) {
            String sql = "select * from user where name='" + name + "'and password='" + password + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void list(int index) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            int ind = ((index - 1) * 5);
            String sql = "select * from hero limit" + " " + ind + "," + (5);
            //String sql1 = "select * from hero limit 0 "
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int attack = rs.getInt(4);
                System.out.printf("%d:%s:%.2f:%d:%n", id, name, hp, attack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
