package bases;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/28/17.
 */
public class ImageRenderer implements Renderer {
    public BufferedImage image;
    public int type;

    public ImageRenderer(String url){
        this.image = Utils.loadImage(url);
    }

    public void render(Graphics g, Vector2D position){
        if(image != null){
            g.drawImage(
                    image,
                    (int) (position.x - image.getWidth() /2),
                    (int) (position.y - image.getHeight() /2),
                    null);
        }
    }

    public int getWidth(){
        return image.getWidth();
    }

    public int getHeight(){
        return image.getHeight();
    }
}
