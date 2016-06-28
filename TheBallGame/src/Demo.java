import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by cerebro on 27/06/16.
 */

public class Demo implements KeyListener {

    private static int xVel = 0;
    private static int yVel = 0;

    private static int pointXCord;
    private static int pointYCord;
    private static Random random = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);
        panel.setFocusable(true);
        panel.addKeyListener(new Demo());
        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Graphics graphics1 = panel.getGraphics();


        panel.requestFocus();
        int x = 0;
        int y = 0;

        Demo.pointXCord = Demo.random.nextInt(580);
        Demo.pointYCord = Demo.random.nextInt(580);

        while (true) {
            x = x + Demo.xVel;
            y = y + Demo.yVel;

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graphics1.clearRect(0, 0, 800, 500);

            graphics1.setColor(Color.red);
            graphics1.fillOval(x, y, 100, 100);

            graphics1.setColor(Color.green);
            graphics1.fillOval(Demo.pointXCord, Demo.pointYCord, 20, 20);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Demo.yVel = 0;
            Demo.xVel = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Demo.yVel = 0;
            Demo.xVel = -4;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            Demo.yVel = 4;
            Demo.xVel = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            Demo.yVel = -4;
            Demo.xVel = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
