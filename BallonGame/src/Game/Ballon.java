package Game;

/**
 * Created by cerebro on 05/07/16.
 */
public class Ballon extends Element {



    public Ballon(int x, int y) {
        super(128, 128);

        this.x = x;
        this.y = y;
        this.yVel = -5;
        this.image = Resources.ballonImage;
    }

    public void handleClick(int clickX, int clickY) {
        if (this.isClicked(clickX, clickY)) {
            Resources.burstAudio.play();
            this.hidden = true;
        }
    }

    protected void update() {
        super.update();

        if (this.y < -128) {
            this.y = 750;
            this.hidden = false;
        }
    }
}
