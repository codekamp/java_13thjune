import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 21/06/16.
 */
public class Demo implements ActionListener {
    public static void main(String[] args) {
        Demo.createWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Demo.createWindow();
    }

    public static void createWindow() {
        JFrame frame1 = new JFrame();
        frame1.setSize(400, 400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        frame1.setContentPane(panel1);

        JButton button1 = new JButton();
        button1.setText("DUPLICATE");
        button1.addActionListener(new Demo());

        panel1.add(button1);

        frame1.setVisible(true);
    }
}
