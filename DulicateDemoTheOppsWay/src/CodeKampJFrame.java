import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 22/06/16.
 */
public class CodeKampJFrame extends JFrame implements ActionListener {

    private JLabel textLabel;
    private JButton changeColorButton;
    protected JButton duplicateButton;

    public CodeKampJFrame() {
        super();

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

        this.setSize(500, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.changeColorButton) {
            if (this.textLabel.getForeground().equals(Color.red)) {
                this.textLabel.setForeground(Color.green);
            } else {
                this.textLabel.setForeground(Color.red);
            }
        } else {
            CodeKampJFrame frame = new CodeKampJFrame();
            frame.setVisible(true);
        }
    }
}
