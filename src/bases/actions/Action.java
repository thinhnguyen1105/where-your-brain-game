package bases.actions;

import bases.GameObject;

public interface Action {
    boolean run (GameObject owner);
    void reset();
}
