package com.company.awt.model;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import static java.lang.Integer.parseInt;

public class ServerForm extends Frame
{
    Label portLabel;
    TextField portTextField;
    Button startButton;
    Button stopButton;
    Button exitButton;
    WindowEvent closingEvent;

    public ServerForm(){
        portLabel = new Label("port:");
        portLabel.setBounds(66, 36, 26, 17);

        portTextField = new TextField(5);
        portTextField.setBounds(105, 31, 148, 26);

        startButton = new Button("start");
        startButton.setBounds(31, 125, 89, 30);

        stopButton = new Button("stop");
        stopButton.setBounds(136, 125, 89, 30);

        exitButton = new Button("exit");
        exitButton.setBounds(241, 125, 89, 30);

        // 1.	Остановлен (не запущен). Доступно для редактирования поле «port», кнопки «start», «exit» - разблокированы,
        // кнопка «stop» - заблокирована:

        //portLabel.setVisible(true);
        portTextField.setEditable(true);
        portTextField.setFocusable(true);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        exitButton.setEnabled(true);

        this.add(portLabel);
        this.add(portTextField);
        this.add(startButton);
        this.add(stopButton);
        this.add(exitButton);

        this.setLayout(null);
        this.setSize(360,180);
        this.setLocation(503, 294);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);

        closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);

        startButton.setBackground(Color.white);
        stopButton.setBackground(Color.white);
        exitButton.setBackground(Color.white);
    }

    public void startServer(){
        portTextField.setEnabled(false);
        portTextField.setFocusable(false);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        exitButton.setEnabled(false);
    }

    public void stopServer(){
        portTextField.setEnabled(true);
        portTextField.setEditable(true);
        portTextField.setFocusable(true);
        portTextField.setBackground(Color.white);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        exitButton.setEnabled(true);
    }

    public void ErrorPort(String t){
        portTextField.setFocusable(false);
        portTextField.setBackground(Color.red);
        portTextField.setText(t);
        portTextField.setEditable(false);
    }

    public void EditablePort(){
        portTextField.setFocusable(true);
        portTextField.setBackground(Color.white);
        portTextField.setText("");
        portTextField.setEditable(true);
    }

    public int GetPortNumber(){
        return parseInt(portTextField.getText());
    }

    // Геттеры:

    public TextField getPortTextField() {return this.portTextField;}
    public Button getStartButton() {return this.startButton;}
    public Button getStopButton() {return this.stopButton;}
    public Button getExitButton() {return this.exitButton;}

    // Сеттеры:

}
