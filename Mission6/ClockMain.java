package Hangeul_Clock;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClockMain {
    public static void runClock() throws InterruptedException {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String curtime[] = dft.format(now).split(":");
        ArrayList<Integer[]> khour = new ArrayList<Integer[]>(TimeConverter.convertHour(curtime[0]));
        ArrayList<Integer[]> kmin = new ArrayList<>(TimeConverter.convertMin(curtime[1]));
        ArrayList<Integer[]> ktime = new ArrayList<>();
        ktime.addAll(khour);
        ktime.addAll(kmin);
        if(curtime[0].equals("12") && curtime[1].equals("00")){
            ClockDisplay.displayNoon();
            Thread.sleep(60000);
        }else if(curtime[0].equals("0") && curtime[1].equals("00")){
            ClockDisplay.displayMidnight();
            Thread.sleep(60000);
        }else{
            ClockDisplay.displayClock(ktime);
            try{Thread.sleep(60000);}
            catch(InterruptedException e){return;}
        }
        System.out.println("");
    }
}
