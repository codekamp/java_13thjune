package Game;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by cerebro on 06/07/16.
 */
abstract public class State {

    public abstract void update(Graphics graphics);

    public abstract void onMousePressed(MouseEvent e);
}
