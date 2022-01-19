package loneDruid;
import java.sql.*;

public class Inquire {
    public static void main(String[] args) {
        try(
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8","root", "admin");
                Statement s = c.createStatement();

                ) {
            String sql ="select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                int id =rs.getInt("id");
                String name = rs.getNString(2);
                float hp = rs.getFloat("hp");
                int attack = rs.getInt(4);
                System.out.printf("id为%d的英雄名字是%s,有%f的血量🩸和%d的攻击力🐓%n",id,name,hp,attack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    CREATE TABLE `user`(
//    id int(11) AUTO_INCREMENT ,
//    name varchar(30) ,
//    password varchar(30) ,
//    PRIMARY KEY (id) ,
//) ;
//    insert into `user` values(null,'MonkeyKing','admin123');





//CREATE TABLE user (
//            id int(11) AUTO_INCREMENT,
//    name varchar(30) ,
//    password varchar(30),
//    PRIMARY KEY (id)
//) ;
//    insert into user values(null,'dashen','thisispassword');



}

