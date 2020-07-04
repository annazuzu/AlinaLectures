package com.company.clientserver.model;

import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread{
    Socket s;

    public ClientThread (Socket s){
        this.s = s;
    }

    public void run(){
        try {
            s.getOutputStream().write(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
