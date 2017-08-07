package com.company;

import java.io.*;
import java.net.Socket;

public class Receive implements Runnable{
    Socket s = null;

    public Receive(Socket s) {
        this.s = s;
    }

    public void run() {
        BufferedReader bufIn = null;
        try {
             bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String lineIn = null;
        while (true) {
            try {
                //判断键入是否为空
                if ((lineIn = bufIn.readLine()) != null) {
                    System.out.println("服务器：" + lineIn);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
