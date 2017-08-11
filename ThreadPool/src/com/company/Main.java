package com.company;

public class Main
{
    public static void main(String[] args)
    {
        ThreadPool tp = new ThreadPool(5);
        for(int i = 0;i<10;i++)
        {
            int num = i;
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(num);
                }
            });
        }
    }
}