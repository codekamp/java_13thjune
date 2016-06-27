import javax.swing.*;
import java.awt.*;

/**
 * Created by cerebro on 27/06/16.
 */

public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);
        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Graphics graphics1 = panel.getGraphics();
        graphics1.setColor(Color.red);


        int x = 0;
        int y = 0;
        int xVel = 4;
        int yVel = 4;
        while (true) {
            x = x + xVel;
            y = y + yVel;

            if (y >= 400) {
                yVel = -4;
            }

            if (x >= 700) {
                xVel = -4;
            }

            if (x <= 0) {
                xVel = 4;
            }

            if (y <= 0) {
                yVel = 4;
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graphics1.clearRect(0, 0, 800, 500);
            graphics1.fillOval(x, y, 100, 100);
        }


    }
}
