package com.company;

import java.net.ServerSocket;


public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(23333);  //创建接收客户端的对象
        System.out.println("...等待客户端连接...");
        Send send = new Send(ss);
        Receive receive = new Receive(ss);
        new Thread(send).start();
        new Thread(receive).start();
    }
}

