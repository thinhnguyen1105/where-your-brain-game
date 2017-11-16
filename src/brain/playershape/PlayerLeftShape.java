package brain.playershape;

import bases.*;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import brain.FallingObjects.FallingObjects;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;
import brain.input.InputManager;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by duyanh on 11/1/17.
 */
public class PlayerLeftShape extends GameObject implements PhysicsBody {
    public static BoxCollider boxCollider;

    public ArrayList<FallingObjects> listShape;

    public static FallingObjects currentObject;
    public static int currentType;

    int count =0 ;


    public PlayerLeftShape(){

        listShape = new ArrayList<>();

        position.set(105,465);
        boxCollider = new BoxCollider(20,20);
        boxCollider.position.set(this.position);

        listShape.add(new Circle());
        listShape.add(new Square());
        listShape.add(new Triangle());
        listShape.add(new Diamond());
        currentObject = listShape.get(0);
        currentType = 0;
        this.renderer = currentObject.renderer;

    }

    public void run(){
        changeShape();
    }

    private void changeShape() {
        InputManager inputManager = InputManager.instance;
        if(inputManager.fPressed){
            AudioUtils.play(AudioUtils.loadSound("audios/Sequence 01.wav"));
            if(count == listShape.size() - 1){
                count = 0;
                changeObject(count);
                currentType = count;
                inputManager.fPressed = false;
            }

            else if(count != listShape.size() - 1 ){
                count++;
                changeObject(count);
                currentType = count;
                inputManager.fPressed = false;

            }
        }

    }



    private void changeObject(int num) {
        currentObject = listShape.get(num);
        this.renderer = currentObject.renderer;
    }




    private void reset(){
        count = 0;
    }

    public void getHit(){
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void setIsActive(boolean isActive) {

    }
}
