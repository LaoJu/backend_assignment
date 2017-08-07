package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive implements Runnable {
    ServerSocket ss = null;
    public Receive(ServerSocket ss) {
        this.ss = ss;
    }

    public void run()
    {
        try {
            //连接客户端，获取客户端地址
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip+"...已连接");

            //读取socket流中的数据 -->源
            BufferedReader  bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String line = null;
            while(true) {

                //判断客户端是否发送了消息
                if ((line = bufIn.readLine()) != null)
                    System.out.println("客户端： " + line);
            }

            }catch (IOException e) {
            e.printStackTrace();
        }

        }
    }

