package Game;

/**
 * Created by cerebro on 05/07/16.
 */
public class Ballon extends Element {

    public static int escapedCount = 0;

    public Ballon(int x, int y) {
        this(x, y, -5);
    }

    public Ballon(int x, int y, int yVel) {
        super(x, y, 128, 128);

        this.image = Resources.ballonImage;
        this.yVel = yVel;
    }

    @Override
    public void update() {
        super.update();

        if (this.y < -128) {
            if (!this.hidden) {
                Ballon.escapedCount++;
            }
            this.y = 800;
            this.hidden = false;

            this.x = Util.randomInt(0, 472);
        }
    }
}
