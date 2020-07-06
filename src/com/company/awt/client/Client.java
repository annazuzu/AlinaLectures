package com.company.awt.client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public void clientDown(int port) throws IOException {
        Socket s = new Socket("localhost", port);
        s.close();
    }
}
