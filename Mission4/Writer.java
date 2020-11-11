package com.company.Week2.Mission3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    private static User user;
    private static Record record;
    private static Scanner sc;
    private static String id;
    private static Reader allRecords;

    public static void initialize() throws IOException {
        user = new User();
        record = new Record();
        allRecords = new Reader();

        boolean login = false;
        sc = new Scanner(System.in);
        while(login == false){
            System.out.println("=============Select One===============");
            System.out.println("0. log in \n1. register new account");
            System.out.println("======================================");
            String LoR = sc.nextLine();
            if (LoR.equals("1")){
                System.out.println("\nEnter an ID you want to use: ");
                id = sc.nextLine();
                while(user.checkId(id) == false){
                    System.out.println("Enter an ID you want to use: ");
                    id = sc.nextLine();
                }
                System.out.println("Enter the password you want to use: ");
                String pw = sc.nextLine();

                User.registerAcc(id,pw);
                initializeRecords(id);
            }

            login = true;
        }

        Reader.readAcc(user);
        login = false;
        while(login == false){
            System.out.println("Please enter your ID");
            id = sc.nextLine();
            System.out.println("Please enter the password");
            String pw = sc.nextLine();

            if(user.logIn(id, pw)){
                login = true;
                break;
            }
            System.out.println("Please try again \n");
        }
        Reader.readRecord(id,record);


    }

    public static void end(){
        sc.close();
    }

    public static void work(){
        while(true){
            System.out.println("=============Select One===============");
            System.out.println("1. Add revenue or cost \n2. Delete revenue/cost \n3. Edit a record \n4. Search for a record \n5: Print all records");
            System.out.println("======================================");
            String todo = sc.nextLine();
            switch (todo){
                case "1":
                    System.out.println("Did you earn(R)? or wasted(C)?");
                    String type = sc.nextLine();
                    System.out.println("Enter the date");
                    String date = sc.nextLine();
                    System.out.println("Enter the amount");
                    String amount = sc.nextLine();
                    System.out.println("Enter the description");
                    String desc = sc.nextLine();
                    if(type.equals("C")){
                        System.out.println("Was it 1.Cash or 2.Credit?");
                        String input = sc.nextLine();
                        String ptype = null;
                        if (input.equals("1")){
                            ptype = "Cash";
                        }
                        if(input.equals("2")){
                            ptype = "Credit";
                        }
                        record.addRecord(type, date, amount, desc,ptype);
                        break;
                    }
                    record.addRecord(type, date, amount, desc, null);
                    break;
                case "2":
                    System.out.println("Enter the number of invoice you want to delete");
                    int dnum = sc.nextInt();
                    record.deleteRecord(dnum);
                    break;
                case "3":
                    System.out.println("Enter the number of invoice you want to edit");
                    int numtoedit = sc.nextInt();
                    record.editRecord(numtoedit);
                    break;
                case "4":
                    System.out.println("Enter what you know about it");
                    String clue = sc.nextLine();
                    record.search(clue);
                    break;
                case "5":
                    record.printAllRecords();
                    break;
                default:
                    System.out.println("\nAN ERROR MESSAGE: IS IT YOUR READING? OR WRITING?\n");
                    continue;
            }
            System.out.println("\nIs there anything I can help? enter s if you want to log out and exit");
            String keepOrNot = sc.nextLine();
            if(keepOrNot.equals("s")){

                end();
                break;
            }


        }
    }

    public static void saveUser(String id, String pw) throws IOException {
        String path = "D:\\Desktop\\Classes\\코드스쿼드\\practice\\src\\com\\company\\Week2\\Mission3\\Accounts.txt";

        FileWriter fileWriter = new FileWriter(path,true);

        String idpw = id+";"+pw;

        try{
            fileWriter.write(idpw+"\n");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void saveRecords(Record record){
        /*
         * option 1:
         *   Make a linkedList in Reader.readRecord and store all info from Records.txt, and then, have
         * Writer.saveRecords to extend the linkedList to contain additional records added during the session.
         * and then use fileWriter.write to write entire linkedList into the Records.txt.
         *
         * pros: possible (Not that I know how to... dang it)
         * cons: seems too inefficient.. making unnecessary linkedList..
         * */
    }
    public static void initializeRecords(String id) throws IOException {
        String path = "D:\\Desktop\\Classes\\코드스쿼드\\practice\\src\\com\\company\\Week2\\Mission3\\Records.txt";

        FileWriter fileWriter = new FileWriter(path,true);

        try{
            fileWriter.write(id+"\n\n"+"}}\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
