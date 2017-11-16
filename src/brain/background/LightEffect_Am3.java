package brain.background;

import bases.Animation;
import bases.GameObject;
import bases.Utils;

public class LightEffect_Am3 extends GameObject{

    float lightEffectX = 70;
    float lightEffectY = 100;


    public LightEffect_Am3(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new Animation(
                Utils.loadImage("assets/images/background/light4_Am1.png"),
                Utils.loadImage("assets/images/background/light4_Am2.png"),
                Utils.loadImage("assets/images/background/light4_Am3.png")
        );

    }

}
