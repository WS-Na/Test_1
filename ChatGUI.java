package loneDruid;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatGUI {
    //由于收发我都写在一起了，所以写了个打开程序就需要的选择的窗口，选择是接收方还是 发送方。
    static boolean yy;  //下方的df(JFrame) 方法窗口就是给用户选择的窗口，如果yy是true，那就需要输入对方的IP
    private static Font font = new Font("微软雅黑", Font.BOLD, 15);

    public static void main(String[] args) {
        JFrame f = new JFrame("聊天窗口");
        f.setSize(500, 600);
        f.setLocation(500, 200);
        f.setLayout(null);

        String txip = ""; //存放通讯ip地址
        df(f);  //下方df(JFrame)方法
        if (yy) {
            while (true) {
                String ip = JOptionPane.showInputDialog(f, "请输入对方的ip地址：\n(IPv4/IPv6均可)\n\nIPv4请在ip末尾处输入   - 4\nIPv6请在ip末尾处输入   - 6");

                if (ip == null || ip.equals("")) {   //先判断用户是否未输入对方的IP地址
                    JOptionPane.showMessageDialog(f, "你取消了输入或者输入为空\n程序即将退出");
                    System.exit(0);
                }
                String ips[] = ip.split("-");   //分割用户输入的ip，通过“-”分割
                if (ips.length != 2) {  //判断用户输入是否正确
                    JOptionPane.showMessageDialog(f, "输入不符合规范！\n请重新输入");
                    continue;
                }
                try {
                    //调用下方的方法checkPing(String,JFrame,int)方法，返回一个boolean值
                    if (checkPing(ips[0], f, Integer.parseInt(ips[1]))) {
                        txip = ips[0]; //如果返回的boolean值为true，把IP地址赋值给txip
                        break;  //结束while循环
                    }
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        }


        //聊天记录框
        JTextArea recording = new JTextArea();
        recording.setEditable(false);      //为不能编辑，但仍然可以选中内容进行复制等操作
        recording.setFont(font);
        JScrollPane p1 = new JScrollPane(recording);
        p1.setBounds(20, 10, 450, 300);
        f.add(p1);

        //输入框
        JTextArea InputBox = new JTextArea();
        JScrollPane p2 = new JScrollPane(InputBox);
        p2.setBounds(20, 330, 450, 150);
        f.add(p2);

        //发送按钮
        JButton b = new JButton("发送");
        b.setBounds(380, 500, 80, 30);
        f.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //连接
        if (yy) {//如果yy是true
            try {               //启动Socket客户端
                Socket s = new Socket(txip, 8990);
                // 启动发送消息线程
                ClientsSoft(s, b, recording, InputBox);   //调用ClientsSoft(Socket,JButton,JTextArea)方法     发送端
                // 启动接受消息线程
                ServerSoft(s, recording);            //调用 Server(Socket,JTextArea)方法                     接收端

            } catch (UnknownHostException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
                //不知道怎么捕获java.net.ConnectException: Connection refused: connect异常
                //只能出此下策，直接在catch块里写下弹窗并关闭程序
                JOptionPane.showMessageDialog(f, "连接失败！\n对方没有开启服务端程序\n\n程序即将退出");
                System.exit(0);
            }
        } else {//如果yy是false或者用户关闭了第一个选择窗口，则默认启动服务端
            try {       //启动ServerSocket服务端
                ServerSocket ss = new ServerSocket(8990);
                Socket s = ss.accept();
                // 启动发送消息线程
                ClientsSoft(s, b, recording, InputBox);    //调用ClientsSoft(Socket,JButton,JTextArea)方法     发送端
                // 启动接受消息线程
                ServerSoft(s, recording);            //调用 Server(Socket,JTextArea)方法                     接收端

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //判断是否是ping 通                   这里掺入JFrame是为了JOptionPane传入f参数
    public static boolean checkPing(String s, JFrame f, int v4v6) throws IOException {
        boolean check = false;
        Process p;
        if (v4v6 == 4) {
            p = Runtime.getRuntime().exec("ping " + s);  //利用ping命令判断ip地址是否ping 的通
        } else {
            if (v4v6 != 6) {//如果用户输入的最后一位数不是4也不是6，就关闭程序，等待用户重新输入
                JOptionPane.showMessageDialog(f, "您输入的数据不正确，程序即将关闭，请重新启动程序尝试");
                System.exit(0);
            }
            p = Runtime.getRuntime().exec("ping -6 " + s);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains("时间")) {//返回字符串里出现"时间"，就是通过
                check = true;
                break;
            }
            if (line.contains("请求超时")) {
                JOptionPane.showMessageDialog(f, "您输入的IP和您主机所在网络不是一个网段\n或对方主机不在线");
                break;
            } else if (line.contains("无法访问目标主机")) {
                JOptionPane.showMessageDialog(f, "您输入的IP无法访问\n或对方主机不在线");
                break;
            } else if (line.contains("请求找不到主机")) {
                JOptionPane.showMessageDialog(f, "您输入的IP无法访问\n请检查该名称，然后重试。");
                break;
            }
        }
        return check;
    }

    //开始页面，选择
    public static void df(JFrame f) {
        JDialog df = new JDialog(f);
        df.setTitle("选择客户端端或者服务端");
        df.setModal(true);
        df.setSize(300, 120);
        df.setLocation(f.getX() + 50, f.getY() + 50);

        JPanel p = new JPanel();
        p.setBounds(0, 50, 380, 35);
        JButton b1 = new JButton("客户端");
        JButton b2 = new JButton("服务端");
        p.add(b1);
        p.add(b2);
        df.add(p);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yy = true;
                df.dispose();   //关闭窗口
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yy = false;
                df.dispose();       //关闭窗口
            }
        });
        df.setVisible(true);
    }

    public static void ClientsSoft(Socket s, JButton b, JTextArea recording, JTextArea InputBox) {
        JTextArea rta = recording;
        JTextArea wta = InputBox;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  //时间格式
        Thread T1 = new Thread() {
            public void run() {
                try {
                    OutputStream os = s.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os); //把输出流封装在DataOutputStream中

                    b.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if (!wta.getText().equals("")) {   //判断输入框是否为空
                                    dos.writeUTF(wta.getText());  //发送信息
                                    rta.setEditable(true); //聊天框可编辑
                                    rta.append("\n" + sdf.format(new Date()) + "\n我方："); //时间+发送端和接收端提示
                                    rta.append(wta.getText() + "\n");
                                    rta.selectAll();   //强行将光标移动在最后
                                    rta.setEditable(false);    //聊天框不可编辑
                                    wta.setText("");  //清除输入框
                                }
                            } catch (IOException err) {
                                err.printStackTrace();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        T1.start();
    }


    public static void ServerSoft(Socket s, JTextArea rta) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");//时间格式

        Thread T2 = new Thread() {
            public void run() {
                try {
                    InputStream is = s.getInputStream();
                    DataInputStream dis = new DataInputStream(is); //把输出流封装在DataOutputStream中

                    while (true) {
                        String msg = dis.readUTF();  //接收信息
                        rta.setEditable(true);     //可编辑
                        rta.append("\n" + sdf.format(new Date()) + "\n对方：");  //时间
                        rta.append(msg + "\n");
                        rta.selectAll();   //强行将光标移动在最后
                        rta.setEditable(false);        //不可编辑
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        T2.start();
    }
}

