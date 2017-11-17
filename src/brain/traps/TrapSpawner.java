package brain.traps;

import bases.FrameCounter;
import bases.GameObject;

import java.util.concurrent.ThreadLocalRandom;

public class TrapSpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(250);
    int[] randomX = {105,300};
    Class[] randomType = {SpeedUp.class, ShapeShifting.class};
//to do: change spawning algorithm
    @Override
    public void run() {
        if(frameCounter.run()){
            GameObject trap = recycle(randomType[ThreadLocalRandom.current().nextInt(0,2)]);
            randomize(trap);
            GameObject.add(trap);
            frameCounter.reset();
        }
    }
    public void randomize(GameObject trap){
        int random = ThreadLocalRandom.current().nextInt(0,2);
        trap.position.set(randomX[random], ThreadLocalRandom.current().nextInt(100,200));
        Traps newTrap = (Traps) trap;
        newTrap.hitBox.position.set(trap.position);
    }
}
