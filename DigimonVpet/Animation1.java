package DigimonVpet;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.util.HashMap;

public class Animation1 extends Frame{

    Image imgs;
    Graphics img_g;
    Image img[] = new Image[3];
    Image[] AgumonMoving = new Image[8];
    /*2개의 이미지 객체를 선언함.*/

    static int num = 0;
    int imgnum = 0;
    Image Agumon;
    Image Attack;
    Image pb;

    public Animation1(String title){

        super(title);
        Toolkit tk = Toolkit.getDefaultToolkit();

        Agumon = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/Attacking/1.gif").getImage();
        Attack = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/Attacking/Attacks/2.gif").getImage();
        pb = new ImageIcon("./src/DigimonVpet/Agumon/Handmade/Attacking/punchingbag/1.gif").getImage();


        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        repaint();
    }


    public void paint(Graphics g) {
        imgs = createImage(300,200);
        img_g = imgs.getGraphics();
        paintComponents(img_g);
        img_g.drawImage(Agumon, 10, 50,this);
        img_g.drawImage(Attack, 50, 50,this);
        img_g.drawImage(pb, 150, 50,this);

        g.drawImage(imgs, 0,0, this);
    }

    public static void main(String[] args){
        new Animation1("애니메이션");

        HashMap<Integer,String> as = new HashMap<Integer,String>();
        as.put(1,"S");
        System.out.println(as.get(1));
    }
}
