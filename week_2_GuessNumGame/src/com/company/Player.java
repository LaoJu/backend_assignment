package com.company;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/7/22.
 */
public class Player {
    private String name;
    int guessNum;
    /*
    构造函数，定义玩家姓名
     */
    public Player(String name)
    {
        this.name = name;
    }

    /*
    获取玩家姓名
     */
    public String getName()
    {
        return name;
    }

    /*
    玩家输入数字
     */
    public int getNum()
    {
        Scanner inNum  = new Scanner(System.in);
        int guessNum = inNum.nextInt();
        return guessNum;
    }

}
