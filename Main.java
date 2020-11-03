package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        sc.close();
        for(int i = 0; i < A; i++){
            System.out.println("Plz");
            if(i == 5) System.out.println(job(i));
        }
    }
    public static int job(int a){
        if(a>5) return a;
        return 5;
    }
}
