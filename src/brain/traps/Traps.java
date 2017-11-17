package brain.traps;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import brain.FallingObjects.FallingObjects;

public interface Traps {
    BoxCollider hitBox = new BoxCollider(10,10);
    public void runEffect(FallingObjects owner);
}
