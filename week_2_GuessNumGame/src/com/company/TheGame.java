package com.company;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Created by lenovo on 2017/7/22.
 */

public class TheGame {
    public  static int count = 0;    //定义猜数字的次数
    public int[] record =new int[10];
    int x=0;


    public void gameStart()
    {
        System.out.println("Game Start");
        int randomNum = (int)(1+Math.random()*(10-1+1));   //获取一个随机数


        System.out.println("input yourname");
        Scanner inName = new Scanner(System.in);   //获取玩家姓名
        String name = inName.nextLine();
        Player p1 = new Player(name);

        while(true)
        {

            System.out.println("please input a int number of 1 to 10");
            int guessNum = p1.getNum();
            int max = 10;
            int min = 1;
            count++;


            //判断玩家是否猜对并给出提示
            if(guessNum>randomNum && guessNum<max)
            {
                System.out.println(guessNum+" is bigger than the correct number. number of times:"+count);
            }
            else if(guessNum<randomNum && guessNum>min)
            {
                System.out.println(guessNum+" is smaller than the correct number. number of times:"+count);

            }
            else if(guessNum==randomNum)
            {
                System.out.println("YOU WIN!  "+guessNum+" is the correct number. number of times:"+count);
                System.out.println("wanna try again ? (yes/no)");
                Scanner inLine = new Scanner(System.in);
                String str = inLine.nextLine();
                if("yes".equals(str))    //判断玩家是否再来一次
                {
                    //        int x = 0;
                    record[x] = count;
                    x++;

                    randomNum = (int)(1+Math.random()*(10-1+1));
                    count = 0;
                    System.out.println("Game Start");
                }
                else
                {
                    record[x] = count;
                    break;
                }

            }
            else
            {
                System.out.println("Please re-enter");
                count--;
            }

        }

    }

    public static void printRecord(int[] arr)
    {
        for(int x =0;x<arr.length;x++)
        {
            System.out.print(arr[x]+" ");
        }
    }

}
