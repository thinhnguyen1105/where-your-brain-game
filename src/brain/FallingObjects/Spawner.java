package brain.FallingObjects;


import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import brain.background.Score;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Spawner extends GameObject {
    public Vector2D position;
    Random rdm = new Random();
    int index;
    float objectSpeed = 3;

    FrameCounter frameCounter = new FrameCounter(250);

    public Spawner(Vector2D position){
        this.position = position;
    }
    public void spawn(int num){
        FallingObjects object = FallingObjects.create(num, objectSpeed);
        object.position.set(this.position);
        System.out.println("object created");
        GameObject.add(object);
    }
    public void run(){
        if(frameCounter.run()){
            index = ThreadLocalRandom.current().nextInt(0,4);

            spawn(index);
            frameCounter.reset();
        }
        if(Score.score >= 3){
            objectSpeed = 4;
        }
        if(Score.score >= 15){
            objectSpeed = 5;
        }
        if(Score.score >= 20){
            objectSpeed = 7;
        }

    }
}
