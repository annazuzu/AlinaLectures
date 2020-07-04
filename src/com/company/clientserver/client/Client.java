package com.company.clientserver.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5050);
        System.out.println((byte)s.getInputStream().read());
        s.close();
    }
}
