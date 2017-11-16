package brain.tutorialScene;

import bases.GameObject;
import bases.ImageRenderer;

public class LeftTuTorialScene extends GameObject {
    public LeftTuTorialScene(){
        this.renderer = new ImageRenderer("assets/images/background/tutorialLeft.png");
        this.position.set(192,300);
    }
}
