package com.company.awt.server;

import com.company.awt.client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUpAndDown {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerThread serv = new ServerThread();
        serv.setPORT(5050);

        Thread s = new Thread(serv);
        //s.setPriority(1);
        s.start();

        Thread.sleep(4000);

        ClientThread cli = new ClientThread();
        cli.setPORT(5050);

        Thread c = new Thread(cli);

        c.start();
    }
}
