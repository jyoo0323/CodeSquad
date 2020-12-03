package DigimonVpet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Digimon {
    private String name,type;
    //type: Vaccine, Data, Virus.
    // the type has one specific purpose: making Rock,Paper and Scisor relationship.
    // Vaccine ==> Virus ==> Data ==> Vaccine

    private int age,weight, hp,power,defense,speed,currentFullness,maxFullness,happiness,adventurePts,numWins,numLoses,numFights;
    //happiness is related to how much attention the user gives to the monster.
    //If the map is dirty with excreta, or the monster got hurt from practice, etc..
    //adventurePts earned from go out for adventure. It affects monster's evolution to Champion/Perfect/Ultimate
    //winRates = numWins/numFights will affect digimon's availavility for evolution to Perfect/Ultimate.


    private boolean consciousness;
    //consciousness == true: digimon is awake and moving(unless illed/hurt)
    //consciousness == flase: digimon is sleeping

    private double resistanceToIllness;

    private final DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm");
    private LocalDateTime now = LocalDateTime.now();

    public String[] curtime = dft.format(now).split(":");

    public static String[] sleepingTimeZone = new String[]{ "02", "03",
                                                            "04", "05", "06", "07", "08"};

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private Calendar cal = Calendar.getInstance();
    private Date rightNow = new Date();
    private Date lastPoop;
    private Date lastEaten;

    private boolean illed;

    private final Random RD = new Random();

    public Digimon(List<String> data) throws ParseException {
        this.name = data.get(0);
        this.age = Integer.parseInt(data.get(1));
        this.type = data.get(2);
        this.weight = Integer.parseInt(data.get(3));
        this.hp = Integer.parseInt(data.get(4));
        this.power = Integer.parseInt(data.get(5));
        this.defense = Integer.parseInt(data.get(6));
        this.speed = Integer.parseInt(data.get(7));
        this.currentFullness = Integer.parseInt(data.get(8));
        this.maxFullness = Integer.parseInt(data.get(9));
        this.happiness = Integer.parseInt(data.get(10));
        this.adventurePts = Integer.parseInt(data.get(11));
        this.numWins = Integer.parseInt(data.get(12));
        this.numLoses = Integer.parseInt(data.get(13));
        this.numFights = Integer.parseInt(data.get(14));
        this.consciousness = Boolean.parseBoolean(data.get(15));
        this.resistanceToIllness = Double.parseDouble(data.get(16));
        this.illed = false;

        cal.add(Calendar.MINUTE, -29);
        lastEaten = sdf.parse(sdf.format(cal.getTime()));
        lastPoop = sdf.parse(sdf.format(cal.getTime()));
    }

    public void updateTime() throws ParseException {
        now = LocalDateTime.now();
        curtime = dft.format(now).split(":");
        cal = Calendar.getInstance();
        rightNow = sdf.parse(sdf.format(cal.getTime()));

    }



    public static void main(String[] args) throws ParseException {
        List<String> myDigimonData = DigimonReader.readData();

        Digimon myDigimon = new Digimon(myDigimonData);

        AguAgu Agumon = new AguAgu(myDigimon);

        Agumon.actions("loading");
        while(true){
            Agumon.actions(myDigimon.DigimonStatus());
        }
    }

    private void hungers(){
        Long differenceInTime = (this.rightNow.getTime() - lastEaten.getTime())/3600000;

        if(differenceInTime >= 1){
            lastEaten = rightNow;
            setCurrentFullness(-10);
        }

    }

    private Boolean sleepCheck(){
        if(Arrays.asList(sleepingTimeZone).contains(curtime[0])){
            this.consciousness = false;
            return true;
        }
        return false;
    }

    private void sickCheck(){
        int a = RD.nextInt(100);
        if((int)(1-this.getResistanceToIllness())*100 > a){
            illed = true;
        }
    }

    private boolean poopCheck(){
        Long differenceInTime = (this.rightNow.getTime() - lastPoop.getTime())/60000;
        if((double)currentFullness/maxFullness > 0.3){
            if(differenceInTime >= 30){
                lastPoop = rightNow;
                return true;
            }
        }
        return false;
    }

    public String DigimonStatus() throws ParseException {
        updateTime();
        if(sleepCheck()){
            return "sleeping";
        }else{
            sickCheck();
            if(illed){
                return "sick";
            }
            if(poopCheck()){
                return "poop";
            }
        }
        hungers();
        return "move";
    }








    //getter and setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power += power;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense += defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed += speed;
    }

    public int getCurrentFullness() {
        return currentFullness;
    }

    public void setCurrentFullness(int currentFullness) {
        this.currentFullness += currentFullness;
    }

    public int getMaxFullness() {
        return maxFullness;
    }

    public void setMaxFullness(int maxFullness) {
        this.maxFullness = maxFullness;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness -= happiness;
    }

    public int getAdventurePts() {
        return adventurePts;
    }

    public void setAdventurePts(int adventurePts) {
        this.adventurePts = adventurePts;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getNumLoses() {
        return numLoses;
    }

    public void setNumLoses(int numLoses) {
        this.numLoses = numLoses;
    }

    public int getNumFights() {
        return numFights;
    }

    public void setNumFights(int numFights) {
        this.numFights = numFights;
    }

    public boolean getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(boolean sleeping) {
        consciousness = sleeping;
    }

    public double getResistanceToIllness() {
        return resistanceToIllness;
    }

    public void setResistanceToIllness(double resistanceToIllness) {
        this.resistanceToIllness -= resistanceToIllness;
    }
    public boolean getIlled() {
        return illed;
    }
    public void setIlled(boolean illed) {
        this.illed = illed;
    }
}

