package DigimonVpet;

import java.awt.*;

import java.awt.event.*;

public class Animation1 extends Frame{

    Image img[] = new Image[3];

    /*2개의 이미지 객체를 선언함.*/

    int num = 0;

    public Animation1(String title){

        super(title);
        Toolkit tk = Toolkit.getDefaultToolkit();

        img[0] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\standing.gif");
        img[1] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\seated.gif");
        img[2] = tk.getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\Handmade\\happy.gif");
        addWindowListener(new WindowHandler());

        setSize(520, 550);

        setVisible(true);

    }

    public void paint(Graphics g){

        if(num > 2)num = 0;

        g.drawImage(img[num++], 80, 80, this);

    }/*img[0], img[6]을 바꿔가며 출력함.*/

    class WindowHandler extends WindowAdapter{

        public void windowClosing(WindowEvent e){

            System.exit(0);
        }

    }



    public static void main(String[] args) {

        // TODO Auto-generated method stub

        Animation1 ani = new Animation1("애니메이션");

        while(true){

            try{

                Thread.sleep(10000000);

                ani.repaint();

            }

            catch(InterruptedException e){

                System.out.println(e.getMessage());

                break;

            }
        }/*0.1초마다 화면을 갱신하면서 달리는 캐릭터를 출력함.*/
    }
}
