package brain.traps;

import bases.GameObject;
import bases.ImageRenderer;
import brain.FallingObjects.FallingObjects;

import java.util.concurrent.ThreadLocalRandom;

public class ShapeShifting extends GameObject implements Traps {

    public ShapeShifting(){
        this.renderer = new ImageRenderer("assets/shapeChangeAnimation/Diamond.png");
    }
    public void runEffect(FallingObjects owner){
        owner.isActive = false;
        FallingObjects newobj = FallingObjects.changeShape(typeCheck(owner),owner.Speed);
        newobj.position.set(this.position);
        GameObject.add(newobj);
    }
}
