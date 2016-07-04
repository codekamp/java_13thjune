package Main;

/**
 * Created by cerebro on 30/06/16.
 */
public class Demo implements Runnable {

    volatile public static int flatCount = 10;

    public static void main(String[] args) {

        Demo demo1 = new Demo();
        Thread thread1 = new Thread(demo1, "codekamp thread");
        thread1.start();

        Demo.countPakistanis();
        Demo.countIndians();

    }

    synchronized public static void countIndians() {
        for (int i = 1; i < 10000; i++) {
            System.out.println(i + " Indian on thread " + Thread.currentThread().getName());

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void countPakistanis() {
        for (int i = 1; i < 5000; i++) {
            System.out.println(i + " Pakistanion thread " + Thread.currentThread().getName());

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        Demo.countIndians();
    }
}
