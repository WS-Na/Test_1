package loneDruid;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class OrmTest {
    // 提供方法get(int id)
    //返回一个Hero对象
    public static void main(String[] args) {
List<PunchMan> list = listMan();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0).getId());
    }

    public static PunchMan getMan(int id) {
        //提取ID 和属性赋予punman
        PunchMan hero = null;
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            String sql = "select * from hero where id=" + id;
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new PunchMan();
//            int thid = rs.getInt(1);
//            String name= rs.getString(2);
//            float hp= rs.getFloat(3);
//            int damage= rs.getInt(4);
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getFloat(3));
                hero.setDamage(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    /*
     根据ORM的思想，设计其他几个常见的ORM方法：

    把一个Hero对象插入到数据库中

    public static void add(Hero h)


    把这个Hero对象对应的数据删除掉

    public static void delete(Hero h)


    更新这条Hero对象

    public static void update(Hero h)


    把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回

    public static List<Hero> list();
     */
    public static void addMan(PunchMan hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //    把这个Hero对象对应的数据删除掉
//
//    public static void delete(Hero h)
    public static void deleteMan(PunchMan hero) {
        String sql = "delete from hero where id=" + hero.getId();
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //    更新这条Hero对象
//
//   public static void update(Hero h)
    public static void updateMan(PunchMan hero) {
        String sql = "insert into hero values(?,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, hero.getId());
            ps.setString(2, hero.getName());
            ps.setFloat(3, hero.getHp());
            ps.setInt(4, hero.getDamage());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //    把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
//
//    public static List<Hero> list();



//    问题我这个集合储存的对象引用名都是一个怎么解决
    public static List<PunchMan> listMan() {
        List<PunchMan> list = new LinkedList<>();
        String sql = "select * from hero where 1=1";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(2);
                PunchMan hero = new PunchMan();
hero.setId(rs.getInt(1));
hero.setName(rs.getString(2));
hero.setHp(rs.getFloat(3));
hero.setDamage(rs.getInt(4));
list.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
