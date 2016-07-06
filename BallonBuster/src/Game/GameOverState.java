package Game;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by cerebro on 06/07/16.
 */
public class GameOverState extends State {
    @Override
    public void update(Graphics graphics) {
        graphics.clearRect(0,0,600,700);
        graphics.drawImage(Resources.gameOverImage, 0, 0, 600, 700, null);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        GamePanel.currentState = new PlayState();
    }
}
