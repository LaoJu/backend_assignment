package com.company;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Send implements Runnable {
    ServerSocket ss = null;
    public Send(ServerSocket ss) {
        this.ss = ss;
    }

    public void run()
    {
        try {
            Socket s = ss.accept();

            //读取键盘数据的流对象 -->源
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

            //socket输出流 （将键入数据写书socket输出流 发送给客户端） -->目的
            BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String line1 = null;
            while (true) {

                //判断键入的源是否为空
                if ((line1 = bufr.readLine()) != null) {
                    System.out.println("(我)服务器: " + line1);
                    bufOut.write(line1);
                    bufOut.newLine();
                    bufOut.flush();
                }

            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
