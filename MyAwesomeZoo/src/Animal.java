import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by cerebro on 15/06/16.
 */
abstract public class Animal implements KeyListener {

    public String name;

    public void introduce() {
        System.out.println("Hi there! My name is " + this.name);
    }

    public void walk() {
        System.out.println("tak tak tak tak!");
    }


    public abstract void speak();

    //   github.com/codekamp


    @Override
    public void keyPressed(KeyEvent e) {

    }


}
