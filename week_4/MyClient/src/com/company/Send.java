package com.company;


import java.io.*;
import java.net.Socket;

class Send implements Runnable {

      Socket s = null;
     public Send (Socket s)
     {
         this.s = s;
     }
     public void run()
     {
         //读取键盘数据的流对象 -->源
         BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

         //将数据写入sock输出流 发给服务端  -->目的
         BufferedWriter bufOut = null;
         try {
             bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

             //定义socket读取流 读取服务器发出的信息
             BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

         } catch (IOException e) {
             e.printStackTrace();
         }

         String line =null;
         while(true) {
             try {
                    //判断键入是否为空
                 if ((line = bufr.readLine()) != null) {
                     System.out.println("(我)客户端： " + line);

                     //传入服务器
                     bufOut.write(line);
                     bufOut.newLine();
                     bufOut.flush();
                 }
             }catch (IOException ex)
             {
                 ex.printStackTrace();
             }
         }
     }

}
