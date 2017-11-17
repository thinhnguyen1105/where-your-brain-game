package brain.traps;

import bases.GameObject;
import bases.ImageRenderer;
import brain.FallingObjects.FallingObjects;

public class SpeedUp extends GameObject implements Traps {
    public SpeedUp(){
        this.renderer = new ImageRenderer("assets/shapeChangeAnimation/Diamond.png");
    }
    public void runEffect(FallingObjects owner){
        owner.Speed += 3;
    }
}
