package DigimonVpet;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public static void main(String[] args) throws ParseException {
        String today = null;


        Date date = new Date();

        System.out.println(date);

// 포맷변경 ( 년월일 시분초)
        SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

// Java 시간 더하기

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);


        today = sdformat.format(cal.getTime());
        System.out.println("지금 : " + today);

// 3분 더하기

        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        cal.add(Calendar.MINUTE, 3);
        Date rightNow = f.parse(f.format(cal.getTime()));
        today = sdformat.format(cal.getTime());
        System.out.println("3분전 : " + today);

        cal.setTime(date);
// 1시간 전
        cal.add(Calendar.HOUR, -1);

        today = sdformat.format(cal.getTime());
        System.out.println("1시간 전 : " + today);

        cal.setTime(date);
// 하루 전
        cal.add(Calendar.DATE, -1);

        today = sdformat.format(cal.getTime());
        System.out.println("1일 전 : " + today);

        /*
        * new Animation1("애니메이션");

        HashMap<Integer,String> as = new HashMap<Integer,String>();
        as.put(1,"S");
        System.out.println(as.get(1));
        *
        *
        * */
    }
}
