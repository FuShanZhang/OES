package club.banyuan.util;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServiceConn {

    void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(8469);
            while(true){
                //建立连接
                Socket socket = serverSocket.accept();
                //JOptionPane.showMessageDialog(null,"有客户端连接了本机8469号端口");

                ClientConn cc = new ClientConn(socket);
                cc.start();

                ConnManager.getConnManager().addClient(cc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
