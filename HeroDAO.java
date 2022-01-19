package loneDruid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO {
    public static void main(String[] args) {
        HeroDAO hero = new HeroDAO();
        List<PunchMan> list = hero.list(3, 100);
        for (PunchMan e:
                list) {
            System.out.println(e.getName());
        }
    }
    /*
    设计类HeroDAO，实现接口DAO

这个HeroDAO和答案-ORM很接近，做了几个改进：
1. 把驱动的初始化放在了构造方法HeroDAO里：

public HeroDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}


因为驱动初始化只需要执行一次，所以放在这里更合适，其他方法里也不需要写了，代码更简洁

2. 提供了一个getConnection方法返回连接
所有的数据库操作都需要事先拿到一个数据库连接Connection，以前的做法每个方法里都会写一个，如果要改动密码，那么每个地方都需要修改。 通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁。
     */

    public HeroDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
    }


    @Override
    public void add(PunchMan hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = getConnection();
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


    @Override
    public void update(PunchMan hero) {
        String sql = "update hero set name = ?, hp = ?, damage = ? where id = " + hero.getId();
        try (
                Connection c = getConnection();
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

    @Override
    public void delete(int id) {
        String sql = "delete hero from where id =" + id;
        try (
                Connection c = getConnection();
                Statement ps = c.createStatement();
        ) {
            ps.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PunchMan get(int id) {
        String sql = "select * from hero where id=" + id;
        PunchMan hero = null;
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new PunchMan();
                hero.setId(id);
                hero.setName(rs.getString(1));
                hero.setHp(rs.getFloat(2));
                hero.setDamage(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<PunchMan> list() {
        String sql = "select * from hero ";
        List<PunchMan> list = new ArrayList<>();
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                PunchMan hero = new PunchMan();
                hero.setDamage(rs.getInt(4));
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getFloat(3));
                list.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PunchMan> list(int start, int count) {
        String sql = "select * from hero limit " + start + "," + count;
        List<PunchMan> list = new ArrayList<>();
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                PunchMan hero = new PunchMan();
                hero.setDamage(rs.getInt(4));
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getFloat(3));
                list.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
