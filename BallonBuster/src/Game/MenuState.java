package Game;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by cerebro on 06/07/16.
 */
public class MenuState extends State {
    @Override
    public void update(Graphics graphics) {
        graphics.clearRect(0,0,600,700);
        graphics.drawImage(Resources.menuImage, 0, 0, 600, 700, null);
//        graphics.fillRect(20, 200, 560, 100);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if (e.getX() > 20 && e.getX() < 580 && e.getY() > 200 && e.getY() < 300) {
            GamePanel.currentState = new PlayState();
        }
    }
}
