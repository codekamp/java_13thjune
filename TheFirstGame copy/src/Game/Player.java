package Game;

/**
 * Created by cerebro on 01/07/16.
 */
public class Player extends Element {

    public Player(int x, int y) {
        super(72, 90);
        this.x = x;
        this.y = y;
    }


    @Override
    protected String getImagePath() {
        return "images/run_anim1.png";
    }
}
