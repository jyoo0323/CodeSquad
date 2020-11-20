package com.company.Week2.Mission3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Reader {
    public static LinkedList<String> allRecords = new LinkedList<String>();
    public static int start = 0;
    public static int end = 0;

    public static void readAcc(User user){
        try{
            File path = new File("D:\\Desktop\\Classes\\코드스쿼드\\practice\\src\\com\\company\\Week2\\Mission3\\Accounts.txt");
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while((line = br.readLine()) != null){
                String[] lineArr = line.split(";");
                user.addAcc(lineArr[0],lineArr[1]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readRecord(String id, Record record){
        try{
            File path = new File("D:\\Desktop\\Classes\\코드스쿼드\\practice\\src\\com\\company\\Week2\\Mission3\\Records.txt");
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";

            while((line = br.readLine()).equals(id) != true){
                start++;
            }
            while((line = br.readLine()).equals("}}") != true){
                end++;
                String[] lineArr = line.split(";");
                record.addRecord(lineArr[0],lineArr[1],lineArr[2],lineArr[3],lineArr[4]);
            }

            while((line = br.readLine()) != null){
                allRecords.add(line);
            }

            br.close();

            System.out.println("Start: "+start+" End: "+end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
