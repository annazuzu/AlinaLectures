package com.company.clientserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket s;
        ServerSocket ss = new ServerSocket(5050);
        s = ss.accept();
        s.getOutputStream().write(10);
        s.close();
        ss.close();
    }
}
