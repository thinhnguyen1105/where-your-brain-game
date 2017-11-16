package bases;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/28/17.
 */
public class Animation implements Renderer {

    public BufferedImage[] images;
    public int currentImageIndex;
    FrameCounter frameCounter;
    boolean repeat;
    public boolean ended;


    //... dùng để: mày cứ nhét ảnh vào đấy, tao sẽ gom tất cả ảnh thành 1 mảng
    public Animation(boolean repeat, BufferedImage... images){
        this.images = images;
        this.frameCounter = new FrameCounter(5);
        this.repeat = repeat;
    }

    public Animation(BufferedImage... images){
        this(true,images);

    }

    @Override
    public void render(Graphics g, Vector2D position) {
        // 1. Draw current image
        BufferedImage currentImage = images[currentImageIndex];
        g.drawImage(currentImage,
                (int) position.x - currentImage.getWidth() / 2,
                (int) position.y - currentImage.getHeight() / 2,
                null);

        // 2. Move to next image

        if(frameCounter.run()){
            moveToNextFrame();
            frameCounter.reset();
        }



    }

    private void moveToNextFrame() {
        if(currentImageIndex == images.length - 1){
            if(repeat)
                currentImageIndex = 0;
            else
                ended = true;
        }else{
            currentImageIndex++;
        }
    }
}
