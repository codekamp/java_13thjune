package Game;

/**
 * Created by cerebro on 04/07/16.
 */
public class Cloud1 extends Cloud {
    public Cloud1(int x, int y) {
        super(x, y);
    }

    @Override
    protected String getImagePath() {
        return "images/cloud1.png";
    }
}
