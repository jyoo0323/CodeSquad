package DigimonVpet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

 /*현제의 문제점:
        1. 순간순간 끊기는 부분이 존재함
                이건 호눅스 코드를 참고하여 변형했는데도 여전함
                    더블 버퍼를 이용하니 해결된듯 했으나 여전히 같은 문제가 발생중
                    12/01:
                        move() 의 repaint()를 최소화(if 문들을 if-else로 묶어서 마지막에 한번만 repaint()하도록 바꿈) 하니
                        화면 반짝임 문제는 해결 + while 문을 없앰으로서 Digimon.main에서 좀 더 편한 접근이 가능해짐
                        그러나 이미지가 최초로 그려질때 문제가 발생하는듯.. 게임을 시작할떄, 아구몬이 처음 방향을 바꿀떄, 처음 고기를 먹을때
                        처음 싫어할때 마다 이미지가 출력되지 않음
                    12/02:
                        처음 이미지가 출력될때 이미지가 그려지지 않는 현상을 로딩 화면을 추가하여 그 로딩화면에 랜덤으로 이미지를 출력하는 기능을
                        추가함으로서 실제 인게임에선 발생하지 않도록 조정함. 해결책이라곤 할수없는 사파(?)스런 방법이지만, 확실히 인게임에서
                        처음에 실행되지 않는 부분은 고쳐졌다.

         2. Training 버튼으로 구현이 안됨.
                그냥 train()자체를 작동시키면 잘 작동하나, 무슨 이유에서인지 버튼을 눌러 진행하면 중간에 아구몬 혼자 move()를 진행함함
                    12/02:
                        Training을 구현화, train() 메소드를 만듦. 위의 문제 발생 + 여전히 12/01의 문제가 발생중 train()에서도
                        현상

    */

public class AguAgu extends Frame{
    Image[] AgumonMoving = new Image[23];
    Image[] Attacks = new Image[4];
    Image[] punchingBag = new Image[6];
    Image[] poop = new Image[3];
    String eatPath = "./src/DigimonVpet/Agumon/Handmade/Gogi/";
    String DislikePath = "./src/DigimonVpet/Agumon/Handmade/Dislike/";
    public static int posx = 107;
    public static int posy = 77;
    Toolkit tk =Toolkit.getDefaultToolkit();
    String turn = "standing";
    int num = 0;
    int direction = 7;
    Image img;
    Digimon Agumon;
    boolean attacking = false;
    boolean practice = false;
    int AttackIdx;
    int punchIdx;
    int attackPos;

    Image bg1 = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/bg1.jpeg").getImage();
    Image bg2 = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/Download.jpg").getImage();
    Image bg3 = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/bg8.jpg").getImage();
    Image bg4 = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/home.jpg").getImage();

    Image[] bgs = new Image[]{bg1,bg2,bg3,bg4};
    int bgidx;
    int poopidx = 2;
    int poopposx;

    int trainCount = 0;
    int eatCount = 0;

    boolean dirtOnFloor = false;

    public AguAgu(Digimon myDigimon){
        super("Digimon Virtual Pet");
        setSize(300,240);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        Agumon = myDigimon;

        Button b1 = new Button("Status");
        b1.setSize(75,50);
        b1.setLocation(0,25);
        b1.addActionListener(new StatusActionListener(this, "Status",true, Agumon));

        Button b2 = new Button("Gogi");
        b2.setSize(75,50);
        b2.setLocation(75,25);
        b2.addActionListener(e -> {
            if(Agumon.getCurrentFullness() >= 100){
                for(int i = 0; i < 3; i++){
                    dislike();
                }
            }else{
                eat();
                Agumon.setCurrentFullness(10);
                eatCount++;
            }
            if(eatCount >= 3){
                Agumon.setWeight(Agumon.getWeight()+1);
            }
        });

        Button b3 = new Button("Training");
        b3.setSize(75,50);
        b3.setLocation(150,25);
        b3.addActionListener(e -> {
            train();
            Agumon.setResistanceToIllness(0.05);
            Agumon.setHp(2);
            Agumon.setPower(1);
            Agumon.setDefense(1);
            Agumon.setSpeed(1);
            trainCount++;
            if(trainCount >= 3){
                trainCount = 0;
                Agumon.setWeight(Agumon.getWeight());
            }
        });

        Button b4 = new Button("Adventure");
        b4.setSize(75,50);
        b4.setLocation(225,25);

        Button b5 = new Button("Flush");
        b5.setSize(75,50);
        b5.setLocation(0,190);
        b5.addActionListener(e -> {
            if(dirtOnFloor) {
                flush();
                happy();
            }
        });

        Button b6 = new Button("Hospital");
        b6.setSize(75,50);
        b6.setLocation(75,190);
        b6.addActionListener(e -> {
            if(!Agumon.getIlled()){
                for(int i = 0; i < 3; i++){
                    dislike();
                }
            }else{
                happy();
                Agumon.setIlled(false);
                Agumon.setResistanceToIllness(-0.75);
                Agumon.setHappiness(5);
            }
        });

        Button b7 = new Button("BackGround");
        b7.setSize(75,50);
        b7.setLocation(150,190);
        b7.addActionListener(e -> changeBackground());

        Button b8 = new Button("History");
        b8.setSize(75,50);
        b8.setLocation(225,190);
        b8.addActionListener(new StatusActionListener(this, "History",true, Agumon));

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);

        for(int i = 0; i < 4; i++){
            AgumonMoving[i] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/move/" +i+".gif");
        }

        for(int i = 1; i < 8; i++){
            AgumonMoving[i-1+4] = tk.getImage(eatPath + i + ".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+11] = tk.getImage(DislikePath + i + ".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+13] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/Sleeping/" +i+".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+15] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/Attacking/"+i+".gif");
        }
        for(int i = 0; i < 4; i++){
            Attacks[i] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/Attacking/Attacks/" +i+".gif");
        }
        for(int i = 0; i < 6; i++){
            punchingBag[i] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/Attacking/punchingbag/" +i+".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+17] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/happy/"+i+".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+19] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/sick/"+i+".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+21] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/pooping/"+i+".gif");
        }
        for(int i = 0; i < 3; i++){
            poop[i] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/poop/" +i+".gif");
        }
    }



    void actions(String todo){
        switch(todo){
            case "move":
                move();
                break;
            case "sleeping":
                sleep();
                break;
            case "loading":
                loading();
                break;
            case "sick":
                sick();
                break;
            case "poop":
                pooping();
                break;
        }
    }

    public void loading(){
        bgidx = 1;
        AttackIdx = 0;
        punchIdx = 0;
        poopidx =0;
        Random rd = new Random();
        for(int i = 0; i < 36; i++){
            attacking = true;
            practice = true;
            num = i;
            AttackIdx++;
            punchIdx++;
            posx = rd.nextInt(250);
            attackPos = rd.nextInt(250);
            posy = rd.nextInt(150);
            poopidx++;

            if(num >= 23){
                num -= 23;
            }
            if(AttackIdx >= 4){
                AttackIdx = 0;
            }
            if(punchIdx >= 6){
                punchIdx = 0;
            }
            if(poopidx >= 3){
                poopidx = 0;
            }
            if(i == 35){
                punchIdx = 5;
                AttackIdx = 3;
                poopidx = 2;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        posy = 77;
        posx = 107;
        bgidx = 0;
    }

    public void train() {
        attacking = true;
        practice = true;
        punchIdx = 0;
        posx = 23;
        AttackIdx = 3;
        direction = -7;


        for (int i = 0; i < 2; i++) {
            posx = 23;
            num = 15;
            try {
                if (i == 1) {
                    AttackIdx = 2;
                    attackPos = 36;
                    num = 16;
                }
                this.update(this.getGraphics());
                if (i == 0) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        num = 16;

        for (int i = 0; i < 17; i++) {
            posx = 23;
            num = 16;
            try {
                attackPos += 5;
                this.update(this.getGraphics());
                Thread.sleep(65);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        AttackIdx = 3;
        num = 16;

        for (int i = 0; i < 8; i++) {
            posx = 23;
            num = 16;
            if (i % 2 == 0) {
                punchIdx = 3;
            } else {
                punchIdx = 4;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        num = 16;

        for (int i = 0; i < 6; i++) {
            posx = 23;
            num = 16;
            if (i % 2 == 0) {
                punchIdx = 1;
            } else {
                punchIdx = 2;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(250);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        punchIdx = 5;


        for (int i = 0; i < 6; i++) {
            posx = 107;
            if (i % 2 == 0) {
                num = 17;
            } else {
                num = 18;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        practice = false;
        attacking = false;

    }

    private void happy(){
        int currentx = posx;
        for (int i = 0; i < 6; i++) {
            posx = currentx;
            if (i % 2 == 0) {
                num = 17;
            } else {
                num = 18;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void pooping(){
        for(int i = 0; i < 5; i++) {
            if(i == 0 || i == 1 || i == 2|| i == 3){
                num = 21;
            }
            if(i%2 == 0){
                posx += 3;
            }
            if(i%2 != 0){
                posx -= 3;
            }
            if(i == 4){
                num = 22;
            }
            try {
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        dirtOnFloor = true;
        poopposx = posx;
    }

    public void flush(){
        poopidx = 2;
        this.update(this.getGraphics());
        dirtOnFloor = false;
    }

    public void dislike(){
        for(int i = 11; i < 13; i++) {
            posx = 107;
            try {
                num = i;
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private void sleep() {
        for(int i = 13; i < 15; i++) {
            posx = 107;
            try {
                num = i;
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
    private void sick() {
        posx = 107;
        if (turn.equals("standing")) {
            num = 19;
            turn = "seated";
        }else {
            num = 20;
            turn = "standing";
        }

        try {
            repaint();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void eat(){
        for(int i = 4; i < 11; i++) {
            posx = 107;
            try {
                num = i;
                this.update(this.getGraphics());
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void changeBackground(){
        bgidx++;
        if(bgidx == 1){
            bgidx++;
        }
        if(bgidx >= 4){
            bgidx = 0;
        }
    }

    void move() {
        if (posx <= 0 || posx >= 220) {
            direction = direction * -1;
        }
        if(dirtOnFloor){
            poopidx++;
            if(poopidx >= 2){
                poopidx = 0;
            }
        }
        try {
            if (turn.equals("standing")) {
                if (direction > 0) {
                    posx -= direction;
                    num = 0;
                    turn = "seated";
                }else{
                    posx -= direction;
                    num = 2;
                    turn = "seated";
                }
            }else{
                if (direction > 0) {
                    posx -= direction;
                    num = 1;
                    turn = "standing";
                }else{
                    posx -= direction;
                    num = 3;
                    turn = "standing";
                }
            }
            repaint();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void paint(Graphics g) {
        img = createImage(300,200);
        Graphics img_g = img.getGraphics();
        if(bgidx == 1){
            img_g.drawImage(bgs[bgidx],0,60,null);
        }else{
            img_g.drawImage(bgs[bgidx],0,-5,null);
        }
        img_g.drawImage(AgumonMoving[num], posx, posy,null);
        if(attacking){
            img_g.drawImage(Attacks[AttackIdx],attackPos,posy, null);
        }
        if(practice){
            img_g.drawImage(punchingBag[punchIdx],200,posy, null);
        }
        if(dirtOnFloor){
            img_g.drawImage(poop[poopidx],poopposx,posy+16, null);
        }
        g.drawImage(img, 0,0, this);
        /*double buffering:
            create an image and a graphics, then draw everything on the graphics then draw that image to the
            system's(? idk how to call it) Graphic g.
        * */
    }
}

