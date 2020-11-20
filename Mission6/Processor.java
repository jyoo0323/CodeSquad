import Hangeul_Clock.ClockMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Processor {
    public static void process(String cmd) throws InterruptedException {
        if (cmd.equals("q")) {
            System.out.println("We are Exiting!");

        }else if(cmd.equals("hclock")){
            ClockMain.runClock();
        }
        else {
            try {
                ProcessBuilder b = new ProcessBuilder("cmd.exe", "/c", cmd);
                b.redirectErrorStream(true);
                Process p = b.start();

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

                BufferedReader std = new BufferedReader(new InputStreamReader(p.getInputStream(), "euc-kr"));
                String outputLine = "";
                String outputMessage = "";
                while ((outputLine = std.readLine()) != null) {
                    outputMessage += outputLine + "\r\n";
                }

                p.waitFor();

                System.out.println(outputMessage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
