package brain.background;

import bases.GameObject;
import bases.ImageRenderer;

/**
 * Created by duyanh on 10/31/17.
 */
public class BackGround extends GameObject {

    public BackGround(){
        position.set(192,300);
        this.renderer = new ImageRenderer("assets/images/background/background.png");


    }
}
