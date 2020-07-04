package com.company.clientserver.server;

import com.company.clientserver.model.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClientOutput {

      public static void main(String[] args) throws IOException, InterruptedException {
          ServerSocket ss = new ServerSocket(5050);
          while (true){
              Socket s = ss.accept();
              ClientThread st = new ClientThread(s);
              st.start();
              ss.close();
          }
      }
}
