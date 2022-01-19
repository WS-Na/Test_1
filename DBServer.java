package loneDruid;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DBServer {
    public static void main(String[] args) {
        connectionDB();
    }
    public static void connectionDB() {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while (true) {
                String receive_str = dis.readUTF();
                System.out.println("receive:" +receive_str);
                System.out.println("enter text");
                dos.writeUTF(auto_Response(receive_str));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static String auto_Response(String str) {
        String sql = "select * from dictionary where receive = " +"'"+ str+"'";
        String sql_else = "select * from dictionary";
        String response_str ="" ;
        try (
                Connection c= TestSql_Net.getConnection();
                Statement s = c.createStatement();
                ){
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
               response_str = rs.getString(3) ;
            }else{
               ResultSet rse = s.executeQuery(sql_else) ;
               List<String> list= new ArrayList<>();
              while(rse.next()){
                  list.add(rse.getString(3));
              }
                Collections.shuffle(list);;
                response_str = list.get(0);
            }
            return response_str;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  response_str;
    }

}
