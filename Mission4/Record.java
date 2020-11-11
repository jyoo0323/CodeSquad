package com.company.Week2.Mission3;


import java.util.*;

public class Record {
    private HashMap<Integer, String[]> recordMap = new HashMap<Integer, String[]>();
    private int number = 0;

    public void addRecord(String type, String date, String amount, String desc, String paytype) {
        number++;
        if(type.equals("C")){
            recordMap.put(number, new String[]{type, date, amount, desc,paytype});
            return;
        }
        recordMap.put(number, new String[]{type, date, amount, desc});
    }

    public void editRecord(int num){
        System.out.println("Which information do you want to change?\ndate:d// amount:a //description:desc");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch(choice){
            case "t":
                System.out.println("Was it falsely reported to be revenue/cost?");
                String ntype = sc.nextLine();
                recordMap.get(num)[0] = ntype;
            case "d":
                System.out.println("Enter the new date: ");
                String ndate = sc.nextLine();
                recordMap.get(num)[1] = ndate;
                break;
            case "a":
                System.out.println("Enter the new amount: ");
                String amount = sc.nextLine();
                recordMap.get(num)[2] = amount;
                break;
            case "desc":
                System.out.println("Enter the new description: ");
                String ndesc = sc.nextLine();
                recordMap.get(num)[3] = ndesc;
                break;
            default:
                System.out.println("\nIS IT THAT DIFFICULT FOR YOU TO ENTER THE CORRECT LETTERS?\n");
                editRecord(num);
        }
        return;
    }

    public void printAllRecords() {
        Set<Integer> keys = recordMap.keySet();
        int total = 0;
        for(Integer key: keys){
            System.out.println("\nInvoice "+ key+" "+ Arrays.toString(recordMap.get(key)));
            if(recordMap.get(key)[0].equals("R")){
                total += Integer.parseInt(recordMap.get(key)[2]);
            }
            else{
                total -= Integer.parseInt(recordMap.get(key)[2]);
            }
        }
        System.out.println("\nTotal balance left: "+total);
    }

    public void deleteRecord(int num) {
        recordMap.remove(num);
    }

    public void search(String clue){
        for(int i = 1; i < number+1; i++){
            List<String> ithVals = Arrays.asList(recordMap.get(i));
            if(ithVals.contains(clue)){
                System.out.println("\nInvoice number: "+ i+" contains: "+ Arrays.toString(recordMap.get(i)));
            }
        }
    }
}
