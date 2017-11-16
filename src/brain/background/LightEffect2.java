package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

public class LightEffect2 extends GameObject {
    float lightEffectX = 240;
    float lightEffectY = 250;


    public LightEffect2(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new ImageRenderer("assets/images/background/light2.png");

    }

    @Override
    public void run() {
        this.position.addUp(0,-5);

        if(position.y < 0){
            position.y = 450;
        }
    }
}
