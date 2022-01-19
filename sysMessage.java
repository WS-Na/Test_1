package loneDruid;

import java.sql.*;

public class sysMessage {
    public static void sysMeta() {
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
        ) {
            DatabaseMetaData dbmd = c.getMetaData();
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseMajorVersion());
            System.out.println(dbmd.getDriverVersion());
            System.out.println(dbmd.getDatabaseProductVersion());
            ResultSet rs = dbmd.getCatalogs();
            if (rs.next())
                System.out.println(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, "michael_jardon");
            ps.setFloat(2, 4267);
            ps.setInt(3, 643);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idIndex = rs.getInt(1);
                for (int i = idIndex - 1; i > 0; i--) {
                    String sqll = "select * from hero where id = "+i;
                    ResultSet resultSet = ps.executeQuery(sqll);
                    if (resultSet.next()){
                        beforeDelete(i);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void beforeDelete(int idIndex) {
        String sql = "delete from hero where id = " + (idIndex);
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                Statement s = c.createStatement();
        ) {
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

