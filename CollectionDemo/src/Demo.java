import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cerebro on 24/06/16.
 */
public class Demo {
    public static void main(String[] args) {

        Random random1 = new Random();
        int aRandomInt = random1.nextInt(4);

        Animal aRandomAnimal;

        switch (aRandomInt) {
            case 0:
                aRandomAnimal = new Dog();
                break;
            case 1:
                aRandomAnimal = new Cat();
                break;
            case 2:
                aRandomAnimal = new Tiger();
                break;
            default:
                aRandomAnimal = new Kangaro();
                break;
        }

        aRandomAnimal.speak();
    }
}
