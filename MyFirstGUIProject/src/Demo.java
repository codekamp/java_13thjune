import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 20/06/16.
 */
public class Demo implements ActionListener {

    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 600;

    public static JTextField usernameTextField;
    public static JTextField passwordTextField;
    public static JButton loginButton;

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("CodeKamp");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(Demo.WINDOW_WIDTH, Demo.WINDOW_HEIGHT);

        JPanel panel1 = new JPanel();
        frame1.setContentPane(panel1);
        panel1.setBackground(Color.RED);

        Demo.usernameTextField = new JTextField();
        Demo.usernameTextField.setText("Username");
        panel1.add(Demo.usernameTextField);

        Demo.passwordTextField = new JTextField();
        Demo.passwordTextField.setText("Password");
        panel1.add(Demo.passwordTextField);


        Demo.loginButton = new JButton();
        Demo.loginButton.setText("Login");
        Demo.loginButton.addActionListener(new Demo());
        panel1.add(Demo.loginButton);

        frame1.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Demo.loginButton) {
            //login button has been clicked
            System.out.println("hello world!");

            System.out.println("Username is " + Demo.usernameTextField.getText());
            System.out.println("password is " + Demo.passwordTextField.getText());
        }
    }
}
