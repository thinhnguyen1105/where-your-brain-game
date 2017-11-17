package brain.background;

import bases.*;

//import java.awt.*;

/**
 * Created by duyanh on 11/18/17.
 */
public class ParticleEffect2 extends GameObject {

    public Vector2D velocity;

    public ParticleEffect2(){
        velocity = new Vector2D();
//        this.renderer = new Animation(
//                Utils.loadImage("assets/images/bullets/circle.png"),
//                Utils.loadImage("assets/images/bullets/circle2.png"),
//                Utils.loadImage("assets/images/bullets/circle3.png"),
//                Utils.loadImage("assets/images/bullets/circle4.png")
//        );
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);


    }

//    private void move(){
//
//        for (float angle = -30; angle <= 360; angle += 30){
//            velocity = Vector2D.DOWN.rotate(angle);
//            this.velocity.set(velocity);
//
//            this.position.addUp(velocity);
//
//        }
//    }


}
