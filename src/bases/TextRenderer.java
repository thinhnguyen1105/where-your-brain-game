package bases;

import java.awt.*;

public class TextRenderer implements Renderer {
    Graphics text;

    public TextRenderer( String text){
//        // Get the FontMetrics
//        FontMetrics metrics = g.getFontMetrics(font);
//        // Determine the X coordinate for the text
//        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
//        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
//        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
//        // Set the font
//        g.setFont(font);
//        // Draw the String
//        g.drawString(text, x, y);
//        this.text =

    }

    @Override
    public void render(Graphics g, Vector2D position) {
//        if (text != null){
//            g.drawString(
//                    text,
//                    (int) (position.x - text.getWidth() /2),
//                    (int) (position.y - text.getHeight() /2)
//                    );
//        }
    }
}
