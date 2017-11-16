package brain;

import bases.GameObject;
import bases.ImageRenderer;

/**
 * Created by duyanh on 10/31/17.
 */
public class BackGround extends GameObject {

    public BackGround(){
        position.set(192,0);
        this.renderer = new ImageRenderer("assets/images/0.png");


    }
}
