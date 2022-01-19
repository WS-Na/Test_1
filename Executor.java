package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Executor {
    public static  void executeadd(String DATABASEFile,String table,String id,String name,float hp,int attack) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+DATABASEFile+"?characterEncoding=UTF-8",
                "root", "admin");
       Statement statment = connection.createStatement();
        ) {
           String sql = "insert into"+table+"value("+id+","+"'"+name+"'"+","+hp+","+attack+")";
            //String sql = "insert into hero value(null," + "'spirit breaker" +i+"'"+"," + 234.0f + "," + 35 + ")";
            statment.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
