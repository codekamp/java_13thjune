package Game;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.String;
import java.net.URL;
import java.util.Random;

/**
 * Created by cerebro on 01/07/16.
 */
abstract public class Element {

    protected static Random randomGenerator = new Random();

    protected int x = 0;
    protected int y = 0;
    protected int xVel = 0;
    protected int yVel = 0;
    protected int xAcc = 0;
    protected int yAcc = 0;
    private int height;
    private int width;
    private Rectangle rectangle = new Rectangle();
    public Image image = null;
    public boolean hidden = false;

    public Element(int width, int height) {
        super();
        this.height = height;
        this.width = width;
    }

    protected void update() {
        this.xVel += this.xAcc;
        this.yVel += this.yAcc;
        this.x += this.xVel;
        this.y += this.yVel;
    }

    public void update(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    private Rectangle getRectangle() {
        rectangle.setBounds(this.x, this.y, this.width, this.height);
        return rectangle;
    }


    public boolean intersects(Element e) {

        return this.getRectangle().intersects(e.getRectangle());
    }

    public boolean isClicked(int clickX, int clickY) {
        return this.getRectangle().contains(clickX, clickY);
    }
}
