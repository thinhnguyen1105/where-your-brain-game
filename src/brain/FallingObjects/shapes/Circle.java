package brain.FallingObjects.shapes;

import bases.*;
import brain.FallingObjects.FallingObjects;
import brain.background.ParticleEffect;
import brain.background.ParticleEffect2;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

import java.awt.*;
import java.util.Random;


public class Circle extends FallingObjects {

    public final int type = 0;
    FrameCounter frameCounter = new FrameCounter(30);
    public Circle(){
        super();
//this.renderer = new ImageRenderer("assets/shape/circle.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/circle.png"),
                Utils.loadImage("assets/shape/circle1.png"),
                Utils.loadImage("assets/shape/circle2.png"),
                Utils.loadImage("assets/shape/circle3.png"),
                Utils.loadImage("assets/shape/circle4.png"),
                Utils.loadImage("assets/shape/circle5.png"),
                Utils.loadImage("assets/shape/circle6.png")

        );

    }

    @Override
    public void run() {
        super.run();
        collide();





    }

    public void addParticle(){


        for (float angle = -30; angle <= 360; angle += 30){
            ParticleEffect2 pe = GameObject.recycle(ParticleEffect2.class);
            pe.position.set(this.position);
            Vector2D velocity = Vector2D.DOWN.rotate(angle).scale(-8);
            pe.velocity.set(velocity);
            pe.renderer = new Animation(
                    Utils.loadImage("assets/images/bullets/circle.png"),
                    Utils.loadImage("assets/images/bullets/circle2.png"),
                    Utils.loadImage("assets/images/bullets/circle3.png"),
                    Utils.loadImage("assets/images/bullets/circle4.png")

            );
            GameObject.add(pe);


        }
    }


    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);

                addParticle();

                GameObject.remove(this);//remove object from gameobject vector
            }
        }
        if(this.position.x > 200){
            if(this.hitBox.collideWith(PlayerRightShape.boxCollider) && this.type == PlayerRightShape.currentType ){
                Score.addScore(1);

                addParticle();
                GameObject.remove(this);
            }
        }

    }
}
