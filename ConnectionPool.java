package loneDruid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
    List<Connection> list = new LinkedList<>();
    int size;


    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dota2?characterEncoding=UTF-8", "root", "admin");
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = list.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c) {
        list.add(c);
        notifyAll();
    }

}


