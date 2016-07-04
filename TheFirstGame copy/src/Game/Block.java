package Game;

import java.util.Random;

/**
 * Created by cerebro on 01/07/16.
 */
public class Block extends Element {

    private static Random randomGenerator = new Random();

    public Block(int x) {
        super(20, 50);
        this.x = x;
        this.xVel = -5;
        this.setRandomY();
    }

    @Override
    protected String getImagePath() {
        return "images/block.png";
    }

    @Override
    protected void update() {
        super.update();

        if (this.x < -100) {
            this.x = 900;
            this.setRandomY();
            this.hidden = false;
        }
    }

    protected void setRandomY() {
        int randomInt = randomGenerator.nextInt(2);

        if (randomInt == 0) {
            this.y = 355;
        } else {
            this.y = 305;
        }
    }
}
