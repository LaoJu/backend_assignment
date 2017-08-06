package com.company;

import java.util.Scanner;

public class Player implements Comparable<Player>{
    private String name;        //定义玩家姓名
    private int count;       //定义猜数字次数
    int num = 0;               //定义排行榜名次



    public Player()
    {}
    public Player(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void setName()        //输入姓名
    {
        Scanner inName = new Scanner(System.in);
        this.name = inName.nextLine();
    }
    public String getName()
    {
        return this.name ;
    }

        @Override

    public  String toString() {
        num++;
        return  num + "姓名： " + this.name + " 次数： " + this.count + '\n';
    }


    //对玩家猜数字次数排序 不显示同名同次数的对象

    public int compareTo(Player p) {
        if (this.count > p.count) {
            return 1;
        } else if (this.count < p.count) {
            return -1;
        } else {
            return this.name.compareTo(p.name);
        }
    }
}

