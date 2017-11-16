package brain.background;

import bases.GameObject;
import brain.FallingObjects.FallingObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by duyanh on 11/4/17.
 */
public class ParticleEffect extends GameObject {
    public float x;
    public float y;

    public float dx;

    public float dy;

    public float size;

    public float life;

    public Color color;

    public ParticleEffect(float x, float y, float dx, float dy, float size, float life, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.size = size;
        this.life = life;
        this.color = color;
    }

    public boolean update(){
        x += dx;

        y += dy;

        life--;

        if(life <= 0){
            return true;
        }

        return false;

    }

    @Override
    public void run() {
        super.run();
        update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);

        Rectangle2D.Double rect = new Rectangle2D.Double(x - (size / 2), y - (size / 2), size, size);

//        g2d.fillRect(rect);

        g2d.draw(rect);

        g2d.fill(rect);

        g2d.dispose();
    }




}
