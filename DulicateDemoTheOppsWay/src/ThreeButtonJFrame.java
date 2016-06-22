import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by cerebro on 22/06/16.
 */
public class ThreeButtonJFrame extends CodeKampJFrame {

    private JButton thirdButton;

    public ThreeButtonJFrame() {
        super();

        this.thirdButton = new JButton();
        this.thirdButton.setText("Third Button");
        this.add(thirdButton);

        this.thirdButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.thirdButton) {
            System.out.println("third button clicked");
        } else if (e.getSource() == this.duplicateButton) {
            ThreeButtonJFrame frame = new ThreeButtonJFrame();
            frame.setVisible(true);
        } else {
            super.actionPerformed(e);
        }
    }
}
