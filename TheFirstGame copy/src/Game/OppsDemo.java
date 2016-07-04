package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 01/07/16.
 */
public class OppsDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 450);
        panel.setPreferredSize(dimension1);
        panel.setFocusable(true);
        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Graphics graphics1 = panel.getGraphics();

        Player player = new Player(400, 315);

        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(900));
        blocks.add(new Block(1100));
        blocks.add(new Block(1300));
        blocks.add(new Block(1500));
        blocks.add(new Block(1700));

        List<Element> elements = new ArrayList<>();
        elements.add(player);
        elements.addAll(blocks);

        Image grassImage = null;
        try {
            grassImage = ImageIO.read(OppsDemo.class.getResource("images/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < blocks.size(); i++) {
                Block b = blocks.get(i);
                if (!b.hidden && player.intersects(b)) {
                    b.hidden = true;
                    player.update(-20, 0);
                    break;
                }
            }

            graphics1.clearRect(0, 0, 800, 450);

            graphics1.setColor(Color.cyan);
            graphics1.fillRect(0, 0, 800, 450);
            graphics1.drawImage(grassImage, 0, 405, null);

            for (int i = 0; i < elements.size(); i++) {
                Element e = elements.get(i);
                e.update();
                if(!e.hidden) {
                    graphics1.drawImage(e.image, e.x, e.y, null);
                }
            }
        }
    }
}
