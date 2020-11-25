package DigimonVpet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Bat  extends JFrame{
    static int xPixel = 300;
    static int yPixel = 300;

    ImageIcon icon; //

    JButton bat;
    Image myImage, offScreenImage;
    Graphics offScreenGraphics;

    public Bat() {
        //setLayout(null);

        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.setSize(200, 200);

        bat = new JButton(new ImageIcon("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\seated.gif"));


        //bat.setBounds(100,100,60,40);

        bat.setBorderPainted(false);
        bat.setFocusPainted(false);
        bat.setContentAreaFilled(false);
        //bat.setLocation(100,100);

        this.add(bat);
        bat.addKeyListener(new Bat.KeyHandler());
        try {
            myImage = Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Classes\\코드스쿼드\\Week4\\src\\DigimonVpet\\Agumon\\seated.gif");
        } catch (Exception e) {
        }
        setSize(800, 600);
        setVisible(true);
        moveImage();

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        int width = getWidth();
        int height = getHeight();

        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
            offScreenGraphics = offScreenImage.getGraphics();
        }

        // clear the off screen image
        offScreenGraphics.clearRect(0, 0, width + 1, height + 1);

        // draw your image off screen
        offScreenGraphics.drawImage(myImage, xPixel, yPixel, this);

        // show the off screen image
        g.drawImage(offScreenImage, 0, 0, this);
    }

    void moveImage() {
        int k = 1;
        while (true) {

            System.out.println("next set of Pixels " + xPixel);
            Random rand = new Random();
            int r = rand.nextInt(30);
            int a = rand.nextInt(30);

            if (k > 0 && k < 2) {
                xPixel += r;
                yPixel += a;
                if (xPixel >= 600 || yPixel >= 600) {
                    k += 1;
                }
            }
            if (k > 1 && k < 3) {
                xPixel -= a;
                yPixel += r;
                if (xPixel <= 30 || yPixel >= 500) {
                    k += 1;
                }
            }
            if (k > 2 && k < 4) {
                xPixel -= r;
                yPixel -= a;
                if (xPixel <= 30 || yPixel <= 30) {
                    k += 1;
                }
            }
            if (k > 3 && k < 5) {
                xPixel += a;
                yPixel -= r;
                if (xPixel >= 600 || yPixel <= 30) {
                    k -= 3;
                }
            }


            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            String direction = e.getKeyText(e.getKeyCode());
            System.out.println(direction);
            int x = bat.getX();
            int y = bat.getY();

            if (direction.equals("Right") || direction.equals("D")) {
                if (x < 550) {
                    x += 10;
                }
            } else if (direction.equals("Left") || direction.equals("A")) {
                if (x > 0) {
                    x -= 10;
                }
            } else if (direction.equals("Down") || direction.equals("X")) {
                if (y < 550) {
                    y += 10;
                }
            } else if (direction.equals("Up") || direction.equals("W")) {
                if (y > 0) {
                    y -= 10;
                }
            } else if (direction.equals("Q")) {
                if (x > 0 && y > 0) {
                    x -= 10;
                    y -= 10;
                }
            } else if (direction.equals("E")) {
                if (x < 550 && y > 0) {
                    x += 10;
                    y -= 10;
                }
            } else if (direction.equals("Z")) {
                if (x > 0 && y < 550) {
                    x -= 10;
                    y += 10;
                }
            } else if (direction.equals("C")) {
                if (x < 550 && y < 550) {
                    x += 10;
                    y += 10;
                }
            }
            bat.setLocation(x, y);
        }
    }

    public static void main(String args[]) {
        Bat play = new Bat();
        play.setVisible(true);
    }
}