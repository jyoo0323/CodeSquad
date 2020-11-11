package com.company.Week2.Mission3;

import java.io.IOException;
import java.util.HashMap;

public class User {
    private HashMap<String, String> accounts = new HashMap<String,String>();

    public boolean checkId(String id){
        if(accounts.containsKey(id)){
            System.out.println("\nThe ID you have entered already exists, please try different ID\n");
            return false;
        }
        System.out.println("It is a valid ID");
        return true;
    }

    public static void registerAcc(String id, String pw) throws IOException {
        Writer.saveUser(id,pw);
    }

    public void addAcc(String id, String pw){
        accounts.put(id, pw);
    }

    public boolean logIn(String id, String pw){
        if (accounts.containsKey(id)){
            if(accounts.get(id).equals(pw)){
                System.out.println("\nYou have logged in successfully\n");
                return true;
            }
        }
        System.out.println("\nYou have failed to log in\n");
        return false;
    }

    public HashMap<String, String> getAccounts() {
        return this.accounts;
    }
}
