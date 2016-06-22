import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 22/06/16.
 */
public class Demo implements ActionListener {

    public static int count = 0;

    public String name;

    public Demo() {
        Demo.count++;


        this.name = "Demo kaa " + Demo.count + " object";
    }

    public JLabel label1;
    public JButton button1;
    public JButton button2;

    public static void main(String[] args) {
        Demo.createWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("action performed called on " + this.name);

        if(e.getSource() == this.button2) {
            Demo.createWindow();

        } else if(e.getSource() == this.button1) {
            if (this.label1.getForeground().equals(Color.red)) {
                this.label1.setForeground(Color.green);
            } else {
                this.label1.setForeground(Color.red);
            }
        }
    }

    public static void createWindow() {
        Demo demo1 = new Demo();

        JFrame frame1 = new JFrame(demo1.name);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);

        JPanel panel1 = new JPanel();
        frame1.setContentPane(panel1);

        demo1.label1 = new JLabel();
        demo1.label1.setText("hello world");
        panel1.add(demo1.label1);

        demo1.button1 = new JButton();
        demo1.button1.setText("Change Color");
        panel1.add(demo1.button1);

        demo1.button2 = new JButton();
        demo1.button2.setText("Duplicate");
        panel1.add(demo1.button2);

        demo1.button1.addActionListener(demo1);
        demo1.button2.addActionListener(demo1);

        System.out.println(demo1.name);

        frame1.setVisible(true);
    }
}
