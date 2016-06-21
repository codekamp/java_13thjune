import java.util.Random;

/**
 * Created by cerebro on 15/06/16.
 */
public class Game {

    public static void main(String[] args) {
//        Dog dog1 = new Dog();
//        dog1.name = "Jackie";
//
//        Animal animal1 = new Cat();
//
//        Cat cat1 = new Cat();
//        cat1.name = "Hilary";
//
//        Tiger tiger1 = new Tiger();
//        tiger1.name = "Sher Khan";
//
//        Kangaro kangaro1 = new Kangaro();
//        kangaro1.name = "Amar Singh";
//
//        dog1.introduce();
//        cat1.introduce();
//        tiger1.introduce();
//        kangaro1.introduce();
//
//        dog1.speak();
//        cat1.speak();
//        tiger1.speak();
//
//        dog1.walk();
//        cat1.walk();
//        tiger1.walk();
//        kangaro1.walk();

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
