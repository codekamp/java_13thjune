package Game;

import javax.swing.*;

/**
 * Created by cerebro on 05/07/16.
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        super("CodeKamp Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        this.setContentPane(panel);
        this.pack();
        this.setResizable(false);
    }


}
