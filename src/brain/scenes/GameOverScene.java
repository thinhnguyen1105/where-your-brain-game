package brain.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Scene;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/Scenes/GameOverScene.png");
        background.position.set(192,300);
        GameObject.add(background);
    }

    @Override
    public void deinit() {

    }
}
