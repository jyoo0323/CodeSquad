import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ShellMain {
    private static boolean exit = false;
    public static void main(String[] args) throws InterruptedException {
        while (!exit) {
            String cmd = Command.TakeinCommands();
            if (Arrays.asList(cmd).contains("q")) {
                exit = true;
            }
            Processor.process(cmd);
        }
    }
}
