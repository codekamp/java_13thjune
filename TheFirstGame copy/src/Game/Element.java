package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by cerebro on 01/07/16.
 */
abstract public class Element {

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
        URL url = Element.class.getResource(this.getImagePath());
        try {
            this.image = ImageIO.read(url);
        } catch (IOException e) {

        }
    }

    abstract protected String getImagePath();

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
}
