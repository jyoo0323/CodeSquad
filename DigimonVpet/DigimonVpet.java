package DigimonVpet;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*Virtual pet game!
추억의 디지몬 다마고찌를 구현하는중.
incompleted:
    buttons(actionListener)
* */
public class DigimonVpet extends Frame{
    Image[] AgumonMoving = new Image[4];
    public static int posx;
    public static int posy;
    Toolkit tk =Toolkit.getDefaultToolkit();;
    String turn = "standing";
    int num = 0;
    int ten = 5;

    public DigimonVpet(){
        super("Digimon Virtual Pet");
        setSize(300,200);
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

        Button b2 = new Button("Gogi");
        b2.setSize(75,50);
        b2.setLocation(75,25);

        Button b3 = new Button("Training");
        b3.setSize(75,50);
        b3.setLocation(150,25);

        Button b4 = new Button("Adventure");
        b4.setSize(75,50);
        b4.setLocation(225,25);

        Button b5 = new Button("W.C");
        b5.setSize(75,50);
        b5.setLocation(0,150);

        Button b6 = new Button("Hospital");
        b6.setSize(75,50);
        b6.setLocation(75,150);

        Button b7 = new Button("Light");
        b7.setSize(75,50);
        b7.setLocation(150,150);

        Button b8 = new Button("Beep");
        b8.setSize(75,50);
        b8.setLocation(225,150);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);

        AgumonMoving[0] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\standing.gif");
        AgumonMoving[1] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\seated.gif");
        AgumonMoving[2] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\ref_standing.gif");
        AgumonMoving[3] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\ref_seated.gif");
        posx = 102;
        posy = 52;
        movement();
    }


    public void paint(Graphics g) {
        if(num > 1){num = 0;}
        if(num == 0 && ten > 0){
            g.drawImage(AgumonMoving[0], posx,posy,this);
        }
        if(num == 1 && ten > 0){
            g.drawImage(AgumonMoving[1], posx,posy,this);
        }
        if(num == 0 && ten < 0){
            g.drawImage(AgumonMoving[2], posx,posy,this);
        }
        if(num == 1 && ten < 0){
            g.drawImage(AgumonMoving[3], posx,posy,this);
        }
        num++;
    }

    /*현제의 문제점:
        1. 움직임이 한 x좌표에서 다 일어난후 이동한후에 같은 동작을 반복. 원래 목적은 1번사진 이였다가 이동하고 2번
            사진으로 바뀌는 방식
        2. 순간순간 끊기는 부분이 존재함
        3. 추가할 동작 많음
    * */
    void movement(){
        while(true){
            if (posx <= 0 || posx >= 220){
                ten = ten*-1;
            }
            try {
                if(turn.equals("standing")){
                    posx -= ten;
                    System.out.println(turn +" "+ posx);
                    turn = "seated";
                    repaint();
                }
                Thread.sleep(1500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            try {
                if(turn.equals("seated")){
                    posx -= ten;
                    System.out.println(turn +" "+ posx);
                    turn = "standing";
                    repaint();
                }
                Thread.sleep(1500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        DigimonVpet Agumon = new DigimonVpet();
    }
}
