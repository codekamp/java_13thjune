package Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 06/07/16.
 */
public class Play2State extends State {

    private List<Element> elements;
    private int score = 0;

    public Play2State() {
        super();
        this.elements = new ArrayList<>();
        this.elements.add(new Ballon(10, 800, -20));
        this.elements.add(new Ballon(100, 600, -20));
        this.elements.add(new Ballon(150, 900, -20));
        this.elements.add(new Ballon(300, 1000, -20));
        this.elements.add(new Ballon(400, 950, -20));
        this.elements.add(new Ballon(20, 1200, -20));
        this.elements.add(new Bomb(20, 1100));
        this.elements.add(new Bomb(450, 400));
        this.elements.add(new Bomb(300, 800));
    }

    @Override
    public void update(Graphics graphics) {

        if(Ballon.escapedCount >= 10) {
            GamePanel.currentState = new GameOverState();
            Ballon.escapedCount = 0;
        }

        graphics.clearRect(0,0,600,700);
        graphics.setColor(Color.green);
        graphics.fillRect(0,0,600,700);
        graphics.setColor(Color.red);

        graphics.drawString("Score: " + Integer.toString(this.score), 500, 20);

        for (int i = 0; i < this.elements.size(); i++) {
            Element element = this.elements.get(i);
            element.update();
            if(!element.hidden) {
                graphics.drawImage(element.image, element.x, element.y, null);
            }
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        for(int i = 0; i < this.elements.size(); i++) {
            Element element = this.elements.get(i);

            if(element.wasClicked(e.getX(), e.getY())) {

                if(element instanceof Ballon) {
                    Resources.burstAudio.play();
                    element.hidden = true;
                    this.score += 10;
                } else if(element instanceof Bomb) {
                    Resources.burstAudio.play();
                    GamePanel.currentState = new GameOverState();

                }
            }
        }
    }
}
