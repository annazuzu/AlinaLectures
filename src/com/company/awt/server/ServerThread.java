package com.company.awt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
//    public void serverUp(int port) throws IOException {
//        Socket s;
//        ServerSocket ss = new ServerSocket(port);
//        s = ss.accept();
//        s.getOutputStream().write(10);
//        s.close();
//        ss.close();
//    }
    int port;

    public ServerThread(){}

    @Override
    public void run() {
        try {
            Socket s;
            ServerSocket ss = null;
            ss = new ServerSocket(port);
            s = ss.accept();
            s.getOutputStream().write(10);
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPORT(){
        return port;
    }

    public void setPORT(int port){
        this.port = port;
    }
}
