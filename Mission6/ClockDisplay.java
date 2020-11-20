package Hangeul_Clock;

import java.util.ArrayList;
import java.util.Arrays;

public class ClockDisplay {
    private static final String[][] hclock = {{"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}};

    static void displayClock(ArrayList<Integer[]> htime) {
        /*
        * Description: Method to display the inputted current time. This method only prints times other than midnight and noon.
        * How does it work:
        *      using double for-loop to iterate through hclock and for each pair of i&j, if the Integer array of i&j, {i,j}, exists
        *      in htime, then we print it with different color using Ansi color code. If {i,j} is not in htime, the method then prints
        *      with white colored code to distinguish the difference.
        *
        * Difficulties encountered:
        *      Had such a painful time deciding with what type of data structure to use for htime. First started with int[][] and then realized that
        *      int[][] would not let me delete the element in it, so I had to re-do the entire labor.
        *
        * learned: Ansi color code & what type of data structure to use.
        * */

        for (int i = 0; i < hclock.length; i++) {
            for (int j = 0; j < hclock.length; j++) {
                Integer[] cur = new Integer[]{i,j};
                for(Integer[] k: new ArrayList<>(htime)){
                    if(Arrays.equals(k,cur)){
                        System.out.print("\u001B[5m\u001B[32m" + hclock[i][j] + "\u001B[0m");
                        htime.remove(k);
                        break;
                    }else{
                        System.out.print("\u001B[37m"+hclock[i][j]+"\u001B[0m");
                        break;
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void displayMidnight(){
        for (int i = 0; i < hclock.length; i++) {
            for (int j = 0; j < hclock.length; j++) {
                if((i == 3 && j == 0) || (i == 4 && j == 0)){
                    System.out.print("\u001B[5m\u001B[32m" + hclock[i][j] + "\u001B[0m");
                }else{
                    System.out.print("\u001B[37m"+hclock[i][j]+"\u001B[0m");
                }
            }
            System.out.println("");
        }
    }

    public static void displayNoon(){
        for (int i = 0; i < hclock.length; i++) {
            for (int j = 0; j < hclock.length; j++) {
                if((i == 4 && j == 0) || (i == 5 && j == 0)){
                    System.out.print("\u001B[5m\u001B[32m" + hclock[i][j] + "\u001B[0m");
                }else{
                    System.out.print("\u001B[37m"+hclock[i][j]+"\u001B[0m");
                }
            }
            System.out.println("");
        }
    }
}
