package brain.FallingObjects.shapes;


import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import brain.FallingObjects.FallingObjects;
import brain.background.ParticleEffect;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

import java.awt.*;
import java.util.Random;

public class Square extends FallingObjects {

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

    public void addParticle(boolean bool){
        Random rdm = new Random();

        float dx,dy;
        if(bool){
//            dx = (int) ((Math.random())*5);
//            dy = (int) ((Math.random())*5);
            dx = (int) ((rdm.nextInt(10) - 5));
            dy = (int) ((rdm.nextInt(10) - 5));
        }
        else{
            dx = (int) ((rdm.nextInt(10) - 5));
            dy = (int) ((rdm.nextInt(10) - 5));
        }
        int size = (int) (Math.random()*12);
//        int life = (int) Math.random()*(120)+380;
        int life =  100;

        GameObject.add(new ParticleEffect(position.x,position.y,dx,dy,size,life, Color.cyan));


    }

    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);

                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                GameObject.remove(this);
            }
        }
        if(this.position.x > 200){
            if(this.hitBox.collideWith(PlayerRightShape.boxCollider) && this.type == PlayerRightShape.currentType ){
                Score.addScore(1);

                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                GameObject.remove(this);
            }
        }


    }
}
