package brain.traps;

import bases.GameObject;
import bases.ImageRenderer;

import java.util.concurrent.ThreadLocalRandom;

public class ShapeShifting extends GameObject implements Traps {

    public ShapeShifting(){
        this.renderer = new ImageRenderer("assets/shapeChangeAnimation/Diamond.png");
    }
}
