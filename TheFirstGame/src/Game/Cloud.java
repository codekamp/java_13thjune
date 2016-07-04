package Game;

/**
 * Created by cerebro on 04/07/16.
 */
abstract public class Cloud extends Element {
    public Cloud(int x, int y) {
        super(129,71);

        this.x = x;
        this.y = y;
        this.xVel = -1;
    }

    @Override
    protected void update() {
        super.update();

        if (this.x < -150) {
            this.x = 850;
            this.setRandomY();
        }
    }

    protected void setRandomY() {
        this.y = Block.randomGenerator.nextInt(100) + 50;
    }
}
