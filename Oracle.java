package loneDruid;

import java.sql.*;

public class Oracle {
    public static void main(String[] args) {
       list(1) ;
    }
    public static void list(int index) {
        String sql = "select * from hero limit "+((index-1)*5)+",5";
        try(
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8","root","admin");
                Statement s = c.createStatement();
                ) {
           s.execute(sql) ;
            ResultSet rs = s.getResultSet();
           while(rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               float hp = rs.getFloat("hp");
               int damage = rs.getInt("damage");
               System.out.printf("%d---%s---%.2f---%d%n",id,name,hp,damage);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
