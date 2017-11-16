package brain.background;

import bases.*;
import brain.scenes.GameOverScene;
import brain.scenes.GamePlayScene;

import java.awt.*;

public class LifesOfPlayer extends GameObject {
    public static int life =5;
    int lifeX = 20;
    int lifeY = 10;
    ImageRenderer lifesOfPlayer;

    public LifesOfPlayer() {
        this.position.set(lifeX, lifeY);
        lifesOfPlayer = new ImageRenderer("assets/images/background/life.png");
    }

    public static void minusLife() {
        life--;
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < life; i++) {
            g.drawImage(lifesOfPlayer.image, lifeX + i * 50, lifeY, null);
        }
    }

    public static void gameOver() {
        AudioUtils.play(AudioUtils.loadSound("audios/sfx_die.wav"));
        SceneManager.changeScene(new GameOverScene());
    }
}
