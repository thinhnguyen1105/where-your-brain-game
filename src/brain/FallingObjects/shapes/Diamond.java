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


public class Diamond extends FallingObjects {
    FrameCounter frameCounter = new FrameCounter(30);
    public final int type = 3;
    public Diamond(){
        super();
//        this.renderer = new ImageRenderer("assets/shape/Diamond1.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/Diamond1.png"),
                Utils.loadImage("assets/shape/Diamond2.png"),
                Utils.loadImage("assets/shape/Diamond3.png"),
                Utils.loadImage("assets/shape/Diamond4.png"),
                Utils.loadImage("assets/shape/Diamond5.png"),
                Utils.loadImage("assets/shape/Diamond6.png")
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
                    Utils.loadImage("assets/images/bullets/Diamond.png"),
                    Utils.loadImage("assets/images/bullets/Diamond1.png"),
                    Utils.loadImage("assets/images/bullets/Diamond2.png"),
                    Utils.loadImage("assets/images/bullets/Diamond3.png")

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
