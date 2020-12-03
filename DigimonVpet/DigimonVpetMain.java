package DigimonVpet;

import java.text.ParseException;
import java.util.List;

public class DigimonVpetMain {
    public static void main(String[] args) throws ParseException {
        List<String> myDigimonData = DigimonReader.readData();
        Digimon myDigimon = new Digimon(myDigimonData);
        AguAgu Agumon = new AguAgu(myDigimon);


        /*
        * while(true){
            //Agumon.actions(myDigimon.DigimonStatus());
        }
        *
        * */

    }
}
