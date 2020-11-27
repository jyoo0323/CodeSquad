package DigimonVpet;

import java.awt.*;

import java.awt.event.*;

public class Animation1 extends Frame{

    Image imgs;
    Graphics img_g;
    Image img[] = new Image[3];
    Image[] AgumonMoving = new Image[8];
    /*2개의 이미지 객체를 선언함.*/

    static int num = 0;
    int imgnum = 0;

    public Animation1(String title){

        super(title);
        Toolkit tk = Toolkit.getDefaultToolkit();
        String eatPath = "D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\Gogi\\";

        for(int i = 0; i < 8; i++){
            String filename = eatPath + i + ".GIF";
            System.out.println(filename);
            AgumonMoving[i] = tk.getImage(filename);
        }

        img[0] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\standing.gif");
        img[1] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\seated.gif");
        img[2] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\happy.gif");

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
        animae();
    }

    void animae(){
        while(true){
            if(num == 8){num = 0;}
            try{
                Thread.sleep(500);
                repaint();
                num++;
                System.out.println(num);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        imgs = createImage(300,200);
        img_g = imgs.getGraphics();
        paintComponents(img_g);
        img_g.drawImage(AgumonMoving[num], 150, 100,this);
        g.drawImage(imgs, 0,0, this);
    }

    public static void main(String[] args){
        new Animation1("애니메이션");
    }
}
