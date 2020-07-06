package com.company.awt;

import com.company.awt.client.Client;
import com.company.awt.model.ServerForm;
import com.company.awt.server.Server;

import java.awt.event.WindowEvent;

public class ServerFormApp {
    public static void main(String[] args){
        ServerForm sf = new ServerForm();
        Server s = new Server();
        //Client c = new Client();
        ServerFormListener sfl = new ServerFormListener(sf, s);
    }
}
