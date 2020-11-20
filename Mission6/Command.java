import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Command {
    private static Scanner sc = new Scanner(System.in);
    static String TakeinCommands(){
        System.out.println("Java Shell>_ ");
        String cmds = sc.nextLine().trim();

        return cmds;
    }
}
