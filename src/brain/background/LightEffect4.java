package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

public class LightEffect4 extends GameObject {
    float lightEffectX = 350;
    float lightEffectY = 550;
    float speedX = 1.5f;
    float speedY = (float) (speedX * 0.46);


    public LightEffect4(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new ImageRenderer("assets/images/background/light5.png");

    }

    @Override
    public void run() {
        this.position.addUp(speedX,-speedY);

        if(position.x > 384){
            position.x = -20;
            position.y = 500;
        }
    }
}
