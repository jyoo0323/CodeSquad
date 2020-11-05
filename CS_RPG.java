package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class CS_RPG {
    static String[][] map;
    static int[] userAt;
    static int[][] mineAt;
    static int[] monsterAt;
    static int score;
    static int mineCount;

    public static void main(String[] args) {
        map = new String[11][11];
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                map[i][j] = "⬜";
            }
        }
        userAt = new int[2];
        mineAt = new int[][]{{randloc()[0],randloc()[1]}};

        monsterAt = new int[2];

        userAt[0] = 5;
        userAt[1] = 5;
        map[userAt[0]][userAt[1]] = "😀";

        map[mineAt[0][0]][mineAt[0][1]] = "💥";

        monsterAt[0] = randloc()[0];
        monsterAt[1] = randloc()[1];
        map[monsterAt[0]][monsterAt[1]] = "⚔";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        score = 0;
        sb.append("Score: " + score);
        System.out.print(sb);
        System.out.println(" ");
        boolean life = true;

        Scanner sc = new Scanner(System.in);

        String[] allowableMoves = {"w","s","a","d","W","S","D","A"};
        mineCount = 1;

         while(life){

             System.out.println("Enter the direction you want to go to: \n");
             String movement = sc.next();
             if ((Arrays.stream(allowableMoves).anyMatch(movement::equals)) == false){
                 System.out.println("Wrong moves! select one from w,s,a,d! ");
                 continue;
             }
             map[userAt[0]][userAt[1]] = "⬜";
             int[] prevloc = {0,0};
             prevloc[0] = userAt[0];
             prevloc[1] = userAt[1];
             location(movement);

             map[userAt[0]][userAt[1]] = "😀";
             for(int i = 0; i < mineAt.length; i++) {
                 if (userAt[0] == mineAt[i][0] && userAt[1] == mineAt[i][1]) {
                     map[userAt[0]][userAt[1]] = "💥";
                     life = false;
                 }
             }
             if(userAt[0] == monsterAt[0] && userAt[1] == monsterAt[1]){
                 score = monsterHunter(mineCount);
                 mineCount = 2*mineCount;
             }


             if (life == false){
                 System.out.println("\n----------------------------\n"+"---------Game over!---------"+"\n----------------------------\n");
                 for (int j = 0; j < mineAt.length; j++) {
                     map[mineAt[j][0]][mineAt[j][1]] = "💥";
                 }
             }
             sb.delete(0,sb.length());
             for(int i = 0; i < 11; i++){
                 for(int j = 0; j < 11; j++){
                     sb.append(map[i][j]);
                 }
                 sb.append('\n');
             }

             sb.append("Score: " + score);
             System.out.print(sb);
             System.out.println("\n----------------------------");

             if (life == false){
                 System.out.println("\n----------------------------\n"+"---------Game over!---------"+"\n----------------------------\n");
             }



             if(userAt[0] == prevloc[0] && userAt[1] == prevloc[1]){
                 System.out.println("Better Move to a right direction");
             }

        }
    }

    static void location(String movement){
        switch(movement){
            case "w":
                if(userAt[0] != 0){userAt[0] -= 1;}
                break;
            case "s":
                if(userAt[0] != 10){userAt[0] += 1;}
                break;
            case "a":
                if(userAt[1] != 0){userAt[1] -= 1;}
                break;
            case "d":
                if(userAt[1] != 10){userAt[1] += 1;}
                break;
        }
        return;
    }

    static int[] randloc(){
        int[] randloc = {0,0};
        randloc[0] = (int)((Math.random()*10000)%10);
        randloc[1] = (int)((Math.random()*10000)%10);
        return randloc;
    }


    static int monsterHunter(int mineCount){
        int newScore = score + 100;
        boolean possibility = true;

        mineCount = 2*mineCount;


        ArrayList<int[]> mineAtList = new ArrayList<int[]>();
        for(int i = 0; i < mineAt.length; i++){
            mineAtList.add(mineAt[i]);
        }

        while(possibility) {
            int prevmonsterx = monsterAt[0];
            int prevmonstery = monsterAt[1];
            monsterAt[0] = randloc()[0];
            monsterAt[1] = randloc()[1];
            if (monsterAt[0] != prevmonsterx && monsterAt[1] != prevmonstery){
                possibility = false;
            }

        }


        for(int i = 0; i < mineCount; i++){
            mineAtList.add(new int[] {randloc()[0],randloc()[1]});
        }

        while(mineAtList.size() != mineCount){
            int[] a = {randloc()[0],randloc()[1]};
            if (monsterAt[0] != a[0] && monsterAt[1] != a[1]){
                if(userAt[0] != a[0] && userAt[1] != a[1]){
                    mineAtList.add(a);
                }
            }
        }

        int[][] nmine = new int[mineCount][2];

        for(int k = 0; k < mineCount; k++){
            nmine[k] = (int[])mineAtList.get(k);
        }

        mineAt = nmine;

        for(int j = 0; j < mineAt.length; j++){
            map[mineAt[j][0]][mineAt[j][1]] = "💥";
        }


        map[monsterAt[0]][monsterAt[1]] = "⚔";

        return newScore;
    }


}
