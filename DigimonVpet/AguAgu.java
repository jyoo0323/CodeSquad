package DigimonVpet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/* using cardlaout example in the AWT text given by Honux, i will make two panels for the
buttons(one for 1~4 and the other for 5~8), and make a panel with CardLayout so that when a
button is pressed, i can just slide to another panel and show what happens.
* */

public class AguAgu extends Frame{
    Image[] AgumonMoving = new Image[14];
    String eatPath = "./src/DigimonVpet/Agumon/Handmade/Gogi/";
    public static int posx = 107;
    public static int posy = 77;
    Toolkit tk =Toolkit.getDefaultToolkit();;
    String turn = "standing";
    int num = 0;
    int ten = 10;
    Boolean walk = true;
    private Image img;
    private Graphics img_g;
    BufferedImage background;

    public AguAgu(){
        super("Digimon Virtual Pet");
        setSize(300,240);
        setVisible(true);
        //setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        loadBackground("./src/DigimonVpet/Agumon/Handmade/bg1.jpeg");


        Button b1 = new Button("Status");
        b1.setSize(75,50);
        b1.setLocation(0,25);

        Button b2 = new Button("Gogi");
        b2.setSize(75,50);
        b2.setLocation(75,25);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eat();
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

        for(int i = 0; i < 8; i++){
            AgumonMoving[i+6] = tk.getImage(eatPath + i + ".gif");
        }

        if(walk){move();}
    }

    private void loadBackground(String path){
        try{
            background = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        img = createImage(300,200);
        img_g = img.getGraphics();
        paintComponents(img_g);
        img_g.drawImage(background,0,-5,this);
        img_g.drawImage(AgumonMoving[num], posx, posy,this);
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
    * */

    void eat(){
        for(int i = 6; i < 14; i++) {
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
                        update();
                    }
                    if (ten < 0) {
                        posx -= ten;
                        num = 2;
                        turn = "seated";
                        update();
                    }
                }else{
                    if (ten > 0) {
                        posx -= ten;
                        num = 1;
                        turn = "standing";
                        update();
                    }
                    if (ten < 0) {
                        posx -= ten;
                        num = 3;
                        turn = "standing";
                        update();
                    }
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        repaint();
    }
    public static void main(String[] args) {
        new AguAgu();
    }
}

