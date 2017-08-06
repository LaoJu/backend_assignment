package com.company;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;


public class TheGame {
    private static int count = 0;                             //定义猜数字的次数
    private static int rodomnum = 0;                           //定义电脑获取的随机数
    private Scanner input = new Scanner(System.in);            //定义输入的源
    Set<Player> rank = new TreeSet<Player>();               //定义排行榜排序
    Player p = new Player();                                 //定义玩家



    //定义菜单功能的数字简写
    private static final int START = 1;
    private static final int RESTART = 2;
    private static final int EXIT = 3;
    private static final int PANK = 4;


    //开始界面
    public void showMeun()
    {
        print("-----------");
        if(rank.isEmpty()) {
            print("1-START");
        }
        else {
            print("2-RESTART");
        }
        print("3-EXIT");
        print("4-SHOWRANK");
        print("-----------");


    }


    //菜单选择功能
    public  void menuChoose() {
        print("输入数字编号");
        Scanner input = new Scanner(System.in); //定义输入的源
        int s = input.nextInt();

        switch (s) {
            case 1:
                start();
                break;
            case 2:
                restart();
                break;
            case 3:
                exit();
                break;
            case 4:
                showRank();
                break;
            default:
                System.out.println("输入有误");
                start();
                break;

        }
    }

    //获取1-10的随机数
    public  int getRandom()
    {
        int x = (int) (1 + Math.random() * (10 - 1 + 1));
        return x;
    }



    //定义游戏开始的方法
    public  void start()
    {
        int random = getRandom();
        print("游戏开始,请输入用户名");
        p.setName();
        print("请输入1-10的整数");
    while(true) {
        Scanner input1 = new Scanner(System.in);       //定义输入的源
        int guessnum = input1.nextInt();
        compareNum(guessnum, random);
    }
    }



    //判断玩家是否猜对并给出提示
    public  void compareNum(int guessnum,int random) {
        int max = 10;
        int min = 1;
        count++;

        //判断玩家是否猜对并给出提示
        if (guessnum < min || guessnum > max) {
            print("输入有误，重新输入");
            count--;
        } else if (guessnum > random) {
            print(guessnum + " 大了。 次数： " + count);
        } else if (guessnum < random) {
            print(guessnum + " 小了。 次数： " + count);

        } else if (guessnum == random)
        {
            print("YOU WIN!  " + guessnum + " 次数：  " + count);
            String name = p.getName();
            rank.add(new Player(name, count));
            print("返回菜单 ? (y/n)");
            if (isBackToMenu()) {
                count = 0;
                showMeun();
                menuChoose();
            } else
                exit();

        }
    }


    //判断是否显示菜单
    public boolean isBackToMenu()
    {
        Scanner inLine = new Scanner(System.in);
        String str = inLine.nextLine();
        if("y".equals(str)||"Y".equals(str))
            return true;
        else if("n".equals(str)||"N".equals(str))
            return false;
        else {
            print("输入有误，重新输入");
            isBackToMenu();
        }

        return false;
    }

    //显示排行
    public void showRank()
    {
        print(rank);
        print("返回菜单 ? (y/n)");
        if(isBackToMenu())
        {
            showMeun();
            menuChoose();
        }
    }

    public static void print(Object obj)
    {
        System.out.println(obj);
    }

    public static void exit()
    {
        print("退出游戏");
        System.exit(0);
    }

    public void restart()
    {
        start();
    }

}
