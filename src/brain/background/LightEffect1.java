package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

public class LightEffect1 extends GameObject {
    float lightEffectX = 105;
    float lightEffectY = 300;


    public LightEffect1(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new ImageRenderer("assets/images/background/light1.png");

    }

    @Override
    public void run() {
        this.position.addUp(5,-2.3f);

        if(position.x > 384){
            position.x = -20;
            position.y = 400;
        }
    }
}
