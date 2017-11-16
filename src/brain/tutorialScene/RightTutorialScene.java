package brain.tutorialScene;

import bases.GameObject;
import bases.ImageRenderer;
import brain.scenes.GameStartScene;

public class RightTutorialScene extends GameObject {

    public RightTutorialScene(){
        this.renderer = new ImageRenderer("assets/images/background/tutorialRight.png");
        this.position.set(192,300);
    }
}
