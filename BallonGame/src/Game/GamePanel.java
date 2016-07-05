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

    volatile private Image image;
    private List<Element> elements;

    public GamePanel() {
        super();

        this.setPreferredSize(new Dimension(600, 700));
        this.setFocusable(true);
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        this.requestFocus();
        Resources.load();
        this.image = new BufferedImage(600, 700, BufferedImage.TYPE_INT_RGB);
        Thread thread = new Thread(this, "Game thread");
        thread.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < this.elements.size(); i++) {
            Ballon ballon = (Ballon)this.elements.get(i);
            ballon.handleClick(e.getX(), e.getY());
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

    @Override
    public void run() {


        this.elements = new ArrayList<>();
        elements.add(new Ballon(10, 800));
        elements.add(new Ballon(200, 900));
        elements.add(new Ballon(300, 650));
        elements.add(new Ballon(50, 400));
        elements.add(new Ballon(10, 800));

        while(true) {
            Graphics imageGraphics = this.image.getGraphics();
            Graphics panelGraphics = this.getGraphics();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            imageGraphics.clearRect(0,0,600,700);
            imageGraphics.setColor(Color.white);
            imageGraphics.fillRect(0,0,600,700);

            for (int i = 0; i < this.elements.size(); i++) {
                Element element = this.elements.get(i);
                element.update();
                if (!element.hidden) {
                    imageGraphics.drawImage(element.image, element.x, element.y, null);
                }
            }

            imageGraphics.dispose();

            panelGraphics.drawImage(this.image,0,0,null);

            panelGraphics.dispose();
        }
    }
}
