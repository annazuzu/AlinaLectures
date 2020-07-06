package com.company.awt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUpAndDown {
    static Socket s;
    static ServerSocket ss;

    public ServerUpAndDown()  {

    }

    public static void main(String[] args) throws IOException {
        serverUp(5050);
        serverDown ();

    }

    public static void serverUp(int port) throws IOException {
        ss = new ServerSocket(port);
        s = ss.accept();
    }

    public static void serverDown() throws IOException {
        s.close();
        ss.close();
    }
}
