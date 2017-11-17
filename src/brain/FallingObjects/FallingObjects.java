package brain.FallingObjects;


import bases.AudioUtils;
import bases.GameObject;
import bases.physics.BoxCollider;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import brain.background.LifesOfPlayer;

public class FallingObjects extends GameObject {
    public BoxCollider hitBox;

    private static ArrayList<Integer> index = new ArrayList<>(Arrays.asList(0,1,2,3));

    public static float Speed = 3;

    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public static final int DIAMOND = 3;
    public static final int TRIANGLE = 2;

    public FallingObjects(){
        hitBox = new BoxCollider(5,5);
    }

    public static FallingObjects create(int type) {
        if (type == CIRCLE) {
            return new Circle();
        }
        if(type == SQUARE){
            return new Square();

        }
        if (type == DIAMOND){
            return new Diamond();
        }
        if(type == TRIANGLE){
            return  new Triangle();
        }
        return null;

    }
    public static FallingObjects changeShape(int type){
        index.remove(new Integer(type));
        int random = ThreadLocalRandom.current().nextInt(0,2);
        index.add(type);
        return create(index.get(random));
    }
    public void run(){
        this.position.addUp(0,Speed);
        this.hitBox.position.set(this.position);
        checkLife();
    }

    public void checkLife() {
        if (this != null) {
            if (this.position.y > 600 && this.isActive) {
                AudioUtils.play(AudioUtils.loadSound("audios/sfx_hit.wav"));
                LifesOfPlayer.minusLife();
                GameObject.remove(this);
            }
        }
        if(LifesOfPlayer.life <= 0){
            LifesOfPlayer.gameOver();
        }
    }
    public void addSpeed(int amount){
        this.Speed += amount;
    }

}
