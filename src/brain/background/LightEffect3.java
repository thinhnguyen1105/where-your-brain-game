package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

public class LightEffect3 extends GameObject {
    float lightEffectX = 350;
    float lightEffectY = 150;
    float speedX = 2;
    float speedY = (float) (speedX * 0.46);


    public LightEffect3(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new ImageRenderer("assets/images/background/light3.png");

    }

    @Override
    public void run() {
        this.position.addUp(speedX,-speedY);

        if(position.x > 384){
            position.x = -20;
            position.y = 300;
        }
    }
}
