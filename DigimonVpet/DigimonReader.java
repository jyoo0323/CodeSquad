package DigimonVpet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DigimonReader {
    public static List<String> digimonData = new ArrayList<String>();

    public static List<String> readData(){
        try{
            File path = new File("./src/DigimonVpet/digimonData.txt");
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            String[] lineArr = line.split(";");
            for(int i = 0; i < lineArr.length; i++){
                digimonData.add(lineArr[i]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return digimonData;
    }
}
