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

public class Square extends FallingObjects {
    FrameCounter frameCounter = new FrameCounter(30);
    public final int type = 1;

    public Square(){

        super();
//        this.renderer = new ImageRenderer("assets/shape/Rectangle.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/Rectangle.png"),
                Utils.loadImage("assets/shape/Rectangle1.png"),
                Utils.loadImage("assets/shape/Rectangle2.png"),
                Utils.loadImage("assets/shape/Rectangle3.png"),
                Utils.loadImage("assets/shape/Rectangle4.png"),
                Utils.loadImage("assets/shape/Rectangle5.png"),
                Utils.loadImage("assets/shape/Rectangle6.png")
        );
    }

    @Override
    public void run() {
        super.run();
        collide();


    }

    public void addParticle(){
//        GameObject.add(new ParticleEffect2(this.position.x, this.position.y));

        for (float angle = -30; angle <= 360; angle += 30){
            ParticleEffect2 pe = GameObject.recycle(ParticleEffect2.class);
            pe.position.set(this.position);
            Vector2D velocity = Vector2D.DOWN.rotate(angle).scale(-8);
            pe.velocity.set(velocity);
            pe.renderer = new Animation(
                    Utils.loadImage("assets/images/bullets/Rectangle.png"),
                    Utils.loadImage("assets/images/bullets/Rectangle1.png"),
                    Utils.loadImage("assets/images/bullets/Rectangle2.png"),
                    Utils.loadImage("assets/images/bullets/Rectangle3.png")

            );
            GameObject.add(pe);

        }


    }

    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);

                addParticle();
                GameObject.remove(this);
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
