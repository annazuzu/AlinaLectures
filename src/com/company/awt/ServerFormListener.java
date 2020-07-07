package com.company.awt;

import com.company.awt.client.ClientThread;
import com.company.awt.model.ServerForm;
import com.company.awt.server.ServerThread;

import java.awt.event.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

class ServerFormListener implements ActionListener, FocusListener, KeyListener, MouseListener, WindowListener {
    ServerForm sf;
    WindowAdapter windowAdapter = null;
    //int port;
    ClientThread cl;
    ServerThread sr;

    public ServerFormListener(ServerForm sf) {
        this.sf = sf;
       // this.sr = sr;
        //this.cl = cl;

        sf.getStartButton().addActionListener(this);
        sf.getStopButton().addActionListener(this);
        sf.getExitButton().addActionListener(this);
        sf.getPortTextField().addActionListener(this);
        sf.getPortTextField().addFocusListener(this);
        sf.getPortTextField().addKeyListener(this);
        sf.getPortTextField().addMouseListener(this);
        sf.addWindowListener(this);
        this.windowAdapter = new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //sf.dispose();
                System.exit(1);
            }
        };
        sf.addWindowListener(this.windowAdapter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sf.getStartButton()) {
            if(!sf.getPortTextField().getText().equals("")){
                int PORT = sf.GetPortNumber();
                System.out.println(PORT);
                // вызвать программный код из соответствующего уровня приложения, который будет запускать сервер

                ServerThread serv = new ServerThread();
                serv.setPORT(PORT);

                Thread s = new Thread(serv);

                sf.startServer();
                s.start();

            } else {
                sf.ErrorPort("Поле 'Port' пустое!");
                return;
            }
        }
        if (e.getSource() == sf.getStopButton()) {
            // вызвать программный код из соответствующего уровня бизнес-логики, останавливающий сервер
            int PORT = sf.GetPortNumber();

            ClientThread cli = new ClientThread();
            cli.setPORT(PORT);

            Thread c = new Thread(cli);

            c.start();
            sf.stopServer();
        }
        if (e.getSource() == sf.getExitButton()) {
            // вызвать программный код из соответствующего уровня бизнес-логики, останавливающий сервер и выходящий из формы
            System.exit(1);
        }

        // все данные с формы собираются в формате String. Если по смыслу задачи параметры имеют другой тип, в нашем случае тип int,
        // то требуется преобразование в нужный тип. Кроме этого требуется проверка на корректность ввода данных (поле должно быть пустым,
        // должно соответствовать формату данных и, если того требует специфика задачи, дополнительная логика по проверке).
        // Проверка на корректность формальная и может быть реализована в методе actionPerformed - проверка на пустоту, на совпадение итпов. Более
        // сложная проверка () должна делаться на уровне модели.
        // Если параметры введены корректно, то в текущем примере выполняется код по запуску проверки.
        // Если параметры заданы некорректно, то sf.ErrorPort().

    }

    @Override
    public void focusGained(FocusEvent e) {
//        if (e.getSource() == sf.getPortTextField()){
//            sf.EditablePort();
//        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == sf.getPortTextField()){
            Pattern p = Pattern.compile("(([0-9]){0,})");
            Matcher m = p.matcher(sf.getPortTextField().getText());

            if(!m.matches()) {
                m.reset();
                sf.ErrorPort("Введен текст, а не число!");
                return;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == sf.getPortTextField()){
            char[] letters = sf.getPortTextField().getText().toCharArray();
            if(sf.getPortTextField().getText().length() <= 5)
            {
                return;

            }  else
            {
                sf.getPortTextField().setText(""+letters[0]+letters[1]+letters[2]+letters[3]+letters[4]);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == sf.getPortTextField()){
            if (sf.getPortTextField().getText().length() > 5)
            {
                sf.ErrorPort("Больше 5 чисел!");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == sf.getPortTextField()){
            sf.EditablePort();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
