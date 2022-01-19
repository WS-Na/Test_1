package loneDruid;

import java.sql.*;

public class innoDB {
    public static void main(String[] args) {
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            /*假设业务操作是：加血，减血各做一次
结束后，英雄的血量不变
而减血的SQL
不小心写错写成了 updata(而非update)
那么最后结果是血量增加了，而非期望的不变
             */
            c.setAutoCommit(false);
            String sqlquery = "select * from hero where id = 999";
            float hp = 0;
            ResultSet rs = s.executeQuery(sqlquery);
            if(rs.next()) {
                hp = rs.getFloat(3);
                System.out.println(hp);
            }
            String sqladd = "update hero set hp = hp+1  where id = 999";
            s.execute(sqladd);
            String sqlderent= "update hero set hp =hp-1 where id = 999";
            s.execute(sqlderent);
            float hpsecond = 0;
            ResultSet rs2= s.executeQuery(sqlquery);
            if(rs2.next()) {
              hpsecond = rs2.getFloat(3);
                System.out.println(hpsecond);
            }
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
