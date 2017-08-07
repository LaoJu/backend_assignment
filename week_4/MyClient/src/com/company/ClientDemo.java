package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket s =new Socket(gethost(),getport());

        Send send = new Send(s);
        Receive receive = new Receive(s);
        new Thread(send).start();
        new Thread(receive).start();

    }

    public static String gethost() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入IP值");
        String ip = null;
        if (s.hasNext()) {
            ip = s.next();
        }
        return ip;
    }

    public static int getport() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入端口值");
        int port = 0;
        if (s.hasNextInt()) {
            port = s.nextInt();
        }
        return port;
    }
}
