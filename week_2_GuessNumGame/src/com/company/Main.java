package com.company;

public class Main {

    public static void main(String[] args) {
        TheGame game = new TheGame();
        game.gameStart();
        int[] a = game.record;
        game.printRecord(a);
           /* Record rc = new Record();
            rc.paiXu();*/
    }
}