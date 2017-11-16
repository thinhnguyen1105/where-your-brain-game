package brain.background;

import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;

public class LightEffect_Am2 extends GameObject {

    float lightEffectX = 350;
    float lightEffectY = 250;


    public LightEffect_Am2(){
        position.set(lightEffectX,lightEffectY);
        this.renderer = new Animation(
                Utils.loadImage("assets/images/background/light4_Am1.png"),
                Utils.loadImage("assets/images/background/light4_Am2.png"),
                Utils.loadImage("assets/images/background/light4_Am3.png")
        );

    }
}
