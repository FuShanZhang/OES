package club.banyuan.util;

import java.io.*;
import java.net.Socket;

public class ClientConn extends Thread{

    private Socket socket;

    ClientConn(Socket socket) {
        this.socket = socket;
    }

    void out(String str){
        try{
            socket.getOutputStream().write(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        out("success\n");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

            String line ;
            while ((line = br.readLine())!=null){
                System.out.println(line);
                ConnManager.getConnManager().send(this,line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

