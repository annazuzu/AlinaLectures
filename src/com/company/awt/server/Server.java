package com.company.awt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void serverUp(int port) throws IOException {
        Socket s;
        ServerSocket ss = new ServerSocket(port);
        s = ss.accept();
        s.close();
        ss.close();
    }
}
