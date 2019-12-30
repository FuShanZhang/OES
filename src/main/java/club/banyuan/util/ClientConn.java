package club.banyuan.util;

import club.banyuan.view.Login;

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
        Login.startUI();
    }
}

