package brain.playershape;

import bases.AudioUtils;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Renderer;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import brain.FallingObjects.FallingObjects;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;
import brain.input.InputManager;

import java.util.ArrayList;

/**
 * Created by duyanh on 11/1/17.
 */
public class PlayerRightShape extends GameObject implements PhysicsBody {
    public static BoxCollider boxCollider;

    public ArrayList<FallingObjects> listShape;

    public static FallingObjects currentObject;
    public static int currentType;

    int count =0 ;

    public PlayerRightShape(){
        position.set(300,465);

        listShape = new ArrayList<>();

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

    public void getHit(){
        isActive = false;
    }

    private void changeShape() {
        InputManager inputManager = InputManager.instance;

        if(inputManager.jPressed){
            AudioUtils.play(AudioUtils.loadSound("audios/Sequence 01.wav"));
            if(count == listShape.size() - 1){
                count = 0;
                changeObject(count);
                currentType= count;
                inputManager.jPressed = false;
            }
            else if(count != listShape.size() - 1 ){
                count++;
                changeObject(count);
                currentType = count;
                inputManager.jPressed = false;

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

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void setIsActive(boolean isActive) {

    }
}
