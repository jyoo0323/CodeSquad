package DigimonVpet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* using cardlaout example in the AWT text given by Honux, i will make two panels for the
buttons(one for 1~4 and the other for 5~8), and make a panel with CardLayout so that when a
button is pressed, i can just slide to another panel and show what happens.

* */

public class AguAgu extends Frame{
    Image[] AgumonMoving = new Image[15];
    String eatPath = "./src/DigimonVpet/Agumon/Handmade/Gogi/";
    String DislikePath = "./src/DigimonVpet/Agumon/Handmade/Dislike/";
    public static int posx = 107;
    public static int posy = 77;
    Toolkit tk =Toolkit.getDefaultToolkit();;
    String turn = "standing";
    int num = 0;
    int ten = 7;
    Boolean walk = true;
    Image img;
    private Graphics img_g;
    Digimon Agumon;
    List<String> AgumonData;

    Image bg = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/bg1.jpeg").getImage();

    public AguAgu(){
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

        Button b1 = new Button("Status");
        b1.setSize(75,50);
        b1.setLocation(0,25);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStatus();
            }
        });

        Button b2 = new Button("Gogi");
        b2.setSize(75,50);
        b2.setLocation(75,25);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Agumon.getCurrentFullness() >= 100){
                    dislike();
                    dislike();
                    dislike();
                }else{
                    eat();
                    Agumon.setCurrentFullness(10);
                }
            }
        });

        Button b3 = new Button("Training");
        b3.setSize(75,50);
        b3.setLocation(150,25);

        Button b4 = new Button("Adventure");
        b4.setSize(75,50);
        b4.setLocation(225,25);

        Button b5 = new Button("W.C");
        b5.setSize(75,50);
        b5.setLocation(0,190);

        Button b6 = new Button("Hospital");
        b6.setSize(75,50);
        b6.setLocation(75,190);

        Button b7 = new Button("Light");
        b7.setSize(75,50);
        b7.setLocation(150,190);

        Button b8 = new Button("History");
        b8.setSize(75,50);
        b8.setLocation(225,190);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);

        AgumonMoving[0] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/standing.gif");
        AgumonMoving[1] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/seated.gif");
        AgumonMoving[2] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/ref_standing.gif");
        AgumonMoving[3] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/ref_seated.gif");
        AgumonMoving[4] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/happy.gif");
        AgumonMoving[5] = tk.getImage("./src/DigimonVpet/Agumon/Handmade/ref_happy.gif");

        for(int i = 1; i < 8; i++){
            AgumonMoving[i-1+6] = tk.getImage(eatPath + i + ".gif");
        }
        for(int i = 0; i < 2; i++){
            AgumonMoving[i+13] = tk.getImage(DislikePath + i + ".gif");
        }

        Agumon = new Digimon(Digimon.getDigimonData());
        AgumonData = new ArrayList<String>(Agumon.getDigimonData());
    }

    void showStatus(){
        Label name = new Label(AgumonData.get(0));
        name.setBounds(0, 25,300, 50);
        add(name);
        System.out.println("Status clicked");;
        repaint();
    }

    void actions(String todo){
        switch(todo){
            case "move":
                move();
                break;
            case "sleeping":
                sleep();
                break;
        }
    }

    public void dislike(){
        for(int i = 13; i < 15; i++) {
            posx = 107;
            try {
                num = i;
                this.update(this.getGraphics());
                System.out.println(num);
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        img = createImage(300,200);
        img_g = img.getGraphics();
        img_g.drawImage(bg,0,-5,null);
        img_g.drawImage(AgumonMoving[num], posx, posy,null);
        g.drawImage(img, 0,0, this);

        /*double buffering:
            create an image and a graphics, then draw everything on the graphics then draw that image to the
            system's(? idk how to call it) Graphic g.
        * */
    }

    /*현제의 문제점:
        1. 순간순간 끊기는 부분이 존재함
                이건 호눅스 코드를 참고하여 변형했는데도 여전함
                    더블 버퍼를 이용하니 해결된듯 했으나 여전히 같은 문제가 발생중
                    move() 의 repaint()를 최소화(if 문들을 if-else로 묶어서 마지막에 한번만 repaint()하도록 바꿈) 하니
                    화면 반짝임 문제는 해결
                    그러나 이미지가 최초로 그려질때 문제가 발생하는듯.. 게임을 시작할떄, 아구몬이 처음 방향을 바꿀떄, 처음 고기를 먹을때
                    처음 싫어할때 마다 이미지가 출력되지 않음
    * */

    void eat(){
        for(int i = 6; i < 13; i++) {
            posx = 107;
            try {
                num = i;
                this.update(this.getGraphics());
                System.out.println(num);
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private void sleep() {

    }

    void move() {
        while (walk) {
            if (posx <= 0 || posx >= 220) {
                ten = ten * -1;
            }
            try {
                if (turn.equals("standing")) {
                    if (ten > 0) {
                        posx -= ten;
                        num = 0;
                        turn = "seated";
                    }else{
                        posx -= ten;
                        num = 2;
                        turn = "seated";
                    }
                }else{
                    if (ten > 0) {
                        posx -= ten;
                        num = 1;
                        turn = "standing";
                    }else{
                        posx -= ten;
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
    }
    /*
    * public static void main(String[] args) {
        List<String> myDigimonData = DigimonReader.readData();
        Digimon myDigimon = new Digimon(myDigimonData);
        new AguAgu();
    }
    *
    * */

}

