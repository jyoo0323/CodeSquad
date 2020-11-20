package Hangeul_Clock;

import java.util.ArrayList;
import java.util.List;

public class TimeConverter {
    public static List<Integer[]> convertHour(String curHour){
        List<Integer[]> hhour = new ArrayList<>();
        if(curHour.equals("0")){
            hhour.add(new Integer[]{3,0});
            hhour.add(new Integer[]{4,0});
        }
        if(curHour.equals("1") || curHour.equals("13")){
            hhour.add(new Integer[]{0,0});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("2") || curHour.equals("14")){
            hhour.add(new Integer[]{0,1});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("3") || curHour.equals("15")){
            hhour.add(new Integer[]{0,2});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("4") || curHour.equals("16")){
            hhour.add(new Integer[]{0,3});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("5") || curHour.equals("17")){
            hhour.add(new Integer[]{0,4});
            hhour.add(new Integer[]{0,5});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("6") || curHour.equals("18")){
            hhour.add(new Integer[]{1,0});
            hhour.add(new Integer[]{1,1});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("7") || curHour.equals("19")){
            hhour.add(new Integer[]{1,2});
            hhour.add(new Integer[]{1,3});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("8") || curHour.equals("20")){
            hhour.add(new Integer[]{1,4});
            hhour.add(new Integer[]{1,5});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("9") || curHour.equals("21")){
            hhour.add(new Integer[]{2,0});
            hhour.add(new Integer[]{2,1});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("10") || curHour.equals("21")){
            hhour.add(new Integer[]{2,2});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("11") || curHour.equals("23")){
            hhour.add(new Integer[]{2,2});
            hhour.add(new Integer[]{2,3});
            hhour.add(new Integer[]{2,5});
        }
        if(curHour.equals("12")){
            hhour.add(new Integer[]{2,3});
            hhour.add(new Integer[]{2,4});
            hhour.add(new Integer[]{2,5});
        }
        return hhour;
    }
    public static List<Integer[]> convertMin(String curMin){
        List<Integer[]> hmin = new ArrayList<>();
        if(curMin.equals("00")){
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("01")){
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("02")){
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("03")){
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("04")){
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("05")){
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("06")){
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("07")){
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("08")){
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("09")){
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("10")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("11")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("12")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("13")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("14")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("15")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("16")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("17")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("18")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("19")){
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("20")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("21")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("22")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("23")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("24")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("25")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("26")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("27")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("28")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("29")){
            hmin.add(new Integer[]{3,1});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("30")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("31")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("32")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("33")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("34")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("35")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("36")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("37")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("38")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("39")){
            hmin.add(new Integer[]{3,2});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("40")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("41")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("42")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("43")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("44")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("45")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("46")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("47")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("48")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("49")){
            hmin.add(new Integer[]{3,3});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("50")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("51")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("52")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("53")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("54")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,4});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("55")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,1});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("56")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{4,5});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("57")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,2});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("58")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,3});
            hmin.add(new Integer[]{5,5});
        }
        if(curMin.equals("59")){
            hmin.add(new Integer[]{3,4});
            hmin.add(new Integer[]{3,5});
            hmin.add(new Integer[]{5,4});
            hmin.add(new Integer[]{5,5});
        }
        hmin.add(new Integer[]{6,6});
        return hmin;
    }
}
