package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;


/**
 * Created by cerebro on 27/06/16.
 */

public class Demo implements KeyListener, MouseListener {

    private static Image grassImage;
    private static Image playerImage1;
    private static Image playerImage2;
    private static Image playerImage3;
    private static Image playerImage4;
    private static Image playerImage5;
    private static Image blockImage;
    private static int playerXCord = 400;
    private static int playerYCord = 315;
    private static int playerYVel = 0;
    private static int playerYAcc = 0;
    private static Random randomGenerator = new Random();
    private static Rectangle playerRectangle = new Rectangle();
    private static Rectangle blockRectangle = new Rectangle();
    private static boolean blockVisible = true;
    private static boolean gamePaused = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 450);
        panel.setPreferredSize(dimension1);
        panel.setFocusable(true);
        Demo demo1 = new Demo();
        panel.addKeyListener(demo1);
        panel.addMouseListener(demo1);
        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Graphics graphics1 = panel.getGraphics();


        panel.requestFocus();


        try {
            Demo.grassImage = ImageIO.read(Demo.class.getResource("images/grass.png"));
            Demo.playerImage1 = ImageIO.read(Demo.class.getResource("images/run_anim1.png"));
            Demo.playerImage2 = ImageIO.read(Demo.class.getResource("images/run_anim2.png"));
            Demo.playerImage3 = ImageIO.read(Demo.class.getResource("images/run_anim3.png"));
            Demo.playerImage4 = ImageIO.read(Demo.class.getResource("images/run_anim4.png"));
            Demo.playerImage5 = ImageIO.read(Demo.class.getResource("images/run_anim5.png"));
            Demo.blockImage = ImageIO.read(Demo.class.getResource("images/block.png"));
        } catch (IOException e) {

        }


        Image[] playerImages = {
                Demo.playerImage1,
                Demo.playerImage2,
                Demo.playerImage3,
                Demo.playerImage4,
                Demo.playerImage5,
                Demo.playerImage3,
                Demo.playerImage2
        };

        int playerImageIndex = 0;
        Image currentPlayerImage;
        int blockXCord = 900;
        int blockYCord = 355;

        while (true) {

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(Demo.gamePaused) {
                continue;
            }

            playerImageIndex++;

            playerImageIndex = playerImageIndex % 7;

            currentPlayerImage = playerImages[playerImageIndex];

            Demo.playerYVel += Demo.playerYAcc;
            Demo.playerYCord += Demo.playerYVel;

            if (Demo.playerYCord >= 315) {
                Demo.playerYCord = 315;
                Demo.playerYVel = 0;
                Demo.playerYAcc = 0;
            }

            blockXCord -= 6;

            if(blockXCord < -20) {
                blockXCord = 900;
                int randomInt = Demo.randomGenerator.nextInt(2);

                if (randomInt == 0) {
                    blockYCord  = 295;
                } else {
                    blockYCord = 355;
                }

                Demo.blockVisible = true;
            }

            Demo.blockRectangle.setBounds(blockXCord, blockYCord, 20, 50);
            Demo.playerRectangle.setBounds(Demo.playerXCord, Demo.playerYCord, 72, 90);

            if(Demo.blockVisible && Demo.playerRectangle.intersects(Demo.blockRectangle)) {
                Demo.playerXCord -= 25;
                Demo.blockVisible = false;
            }

            graphics1.clearRect(0, 0, 800, 450);
            graphics1.setColor(Color.cyan);
            graphics1.fillRect(0, 0, 800, 450);

            graphics1.drawImage(Demo.grassImage,0,405,null);

            graphics1.drawImage(currentPlayerImage,Demo.playerXCord,Demo.playerYCord,null);

            if(Demo.blockVisible) {
                graphics1.drawImage(Demo.blockImage, blockXCord, blockYCord, null);
            }

            graphics1.setColor(Color.red);
            graphics1.fillRect(740, 10, 50, 50);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && Demo.playerYCord == 315) {
            Demo.playerYVel = -20;
            Demo.playerYAcc = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getX() > 740 && e.getX() < 790 && e.getY() > 10 && e.getY() < 60) {
            Demo.gamePaused = !Demo.gamePaused;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
