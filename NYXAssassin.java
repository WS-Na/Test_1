package loneDruid;

import java.sql.*;

public class NYXAssassin {
    public static void main(String[] args) {
        String sql = "select * from hero where 2<100";
        String sqlUpdate = "update hero set damage=101 where damage>11";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            boolean sqlQuiry = s.execute(sql);
            int sqlInquiry = s.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            while(rs.next()) {
               int id = rs.getInt(1) ;
               String name = rs.getString(2);
               float hp = rs.getFloat(3);
               int damage = rs.getInt(4);
                System.out.printf("%d--%s--%.2f--%d%n",id,name,hp,damage);
                //System.out.printf("%d---%s---%.0f---%d%n",id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
