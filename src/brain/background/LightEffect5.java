package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

public class LightEffect5 extends GameObject {
    float lightEffectX = 50;
    float lightEffectY = 500;


    public LightEffect5(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new ImageRenderer("assets/images/background/light2.png");

    }

    @Override
    public void run() {
        this.position.addUp(0,-2);

        if(position.y < 0){
            position.y = 450;
        }
    }
}
