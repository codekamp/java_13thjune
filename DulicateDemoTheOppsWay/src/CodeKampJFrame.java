import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 22/06/16.
 */
public class CodeKampJFrame extends JFrame implements ActionListener {

    public static int count = 0;

    private JLabel textLabel;
    private JButton changeColorButton;
    protected JButton duplicateButton;
    private List<CodeKampJFrame> childWindows;
    private int number;

    public CodeKampJFrame() {
        super();

        CodeKampJFrame.count++;

        this.number = CodeKampJFrame.count;
        this.setTitle("window " + this.number);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        this.textLabel = new JLabel();
        this.textLabel.setText("Hello world!");
        panel.add(this.textLabel);

        this.changeColorButton = new JButton();
        this.changeColorButton.setText("change color");
        this.changeColorButton.addActionListener(this);
        panel.add(this.changeColorButton);

        this.duplicateButton = new JButton();
        this.duplicateButton.setText("duplicate");
        this.duplicateButton.addActionListener(this);
        panel.add(this.duplicateButton);

        this.childWindows = new ArrayList<>();

        this.setSize(200, 200);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.changeColorButton) {
            if (this.textLabel.getForeground().equals(Color.red)) {
                this.changeColor(Color.green);
            } else {
                this.changeColor(Color.red);
            }
        } else {
            CodeKampJFrame frame = new CodeKampJFrame();
            this.childWindows.add(frame);
            frame.setVisible(true);
        }
    }

    public void changeColor(Color color) {

        for (int i = 0; i < this.childWindows.size(); i++) {
            this.childWindows.get(i).changeColor(color);
        }

        this.textLabel.setForeground(color);
        System.out.println("color of window number " + this.number + " changed");
    }
}
