package com.company.awt.client;

import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {

    int port;

    public ClientThread (){}

    @Override
    public void run() {
        try {
            Socket s = new Socket("localhost", port);
            System.out.println((byte)s.getInputStream().read());
            s.close();
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
