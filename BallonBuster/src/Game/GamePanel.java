package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 05/07/16.
 */
public class GamePanel extends JPanel implements MouseListener, Runnable {

    private Image image;
    private List<Element> elements;
    private int score = 0;
    private boolean gameOver = false;

    public GamePanel() {
        super();

        this.setPreferredSize(new Dimension(600,700));
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        Resources.load();
        this.image = new BufferedImage(600, 700, BufferedImage.TYPE_INT_RGB);
        Thread thread = new Thread(this, "Game Thread");
        thread.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(int i = 0; i < this.elements.size(); i++) {
            Element element = this.elements.get(i);

            if(element.wasClicked(e.getX(), e.getY())) {

                if(element instanceof Ballon) {
                    Resources.burstAudio.play();
                    element.hidden = true;
                    this.score += 10;
                } else if(element instanceof Bomb) {
                    this.gameOver = true;
                    Resources.burstAudio.loop();
                }
            }
        }
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

    @Override
    public void run() {


        this.elements = new ArrayList<>();
        this.elements.add(new Ballon(10, 800));
        this.elements.add(new Ballon(100, 600));
        this.elements.add(new Ballon(150, 900));
        this.elements.add(new Ballon(300, 1000));
        this.elements.add(new Ballon(400, 950));
        this.elements.add(new Ballon(20, 1200));
        this.elements.add(new Bomb(20, 1100));
        this.elements.add(new Bomb(450, 400));
        this.elements.add(new Bomb(300, 800));

        while (true) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics imageGraphics = this.image.getGraphics();
            Graphics panelGraphics = this.getGraphics();
            imageGraphics.clearRect(0,0,600,700);
            imageGraphics.setColor(Color.cyan);
            imageGraphics.fillRect(0,0,600,700);
            imageGraphics.setColor(Color.red);

            if(Ballon.escapedCount >= 10) {
                this.gameOver = true;
            }

            if (this.gameOver) {
                imageGraphics.drawImage(Resources.gameOverImage, 0, 0, 600, 700, null);
                imageGraphics.dispose();
                panelGraphics.drawImage(image, 0,0,null);
                panelGraphics.dispose();
                break;
            }





            imageGraphics.drawString("Score: " + Integer.toString(this.score), 500, 20);

            for (int i = 0; i < this.elements.size(); i++) {
                Element element = this.elements.get(i);
                element.update();
                if(!element.hidden) {
                    imageGraphics.drawImage(element.image, element.x, element.y, null);
                }
            }

            imageGraphics.dispose();



            panelGraphics.drawImage(this.image, 0, 0, null);
            panelGraphics.dispose();

        }
    }
}
