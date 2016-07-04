package Game;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by cerebro on 01/07/16.
 */
public class Player extends Element {

    private AudioClip jumpAudio;
    public AudioClip hitAudio;

    public Player(int x) {
        super(72, 90);
        this.x = x;
        this.y = 315;
        this.jumpAudio = Applet.newAudioClip(Player.class.getResource("audios/onjump.wav"));
        this.hitAudio = Applet.newAudioClip(Player.class.getResource("audios/hit.wav"));
    }


    @Override
    protected String getImagePath() {
        return "images/run_anim1.png";
    }

    public void jump() {
        if (this.isOnGround()) {
            this.jumpAudio.play();
            this.yAcc = 2;
            this.yVel = -30;
        }
    }

    public boolean isOnGround() {
        return this.y == 315;
    }

    public void update() {
        super.update();

        if (this.y >= 315) {
            this.y = 315;
            this.yVel = 0;
            this.yAcc = 0;
        }
    }
}
