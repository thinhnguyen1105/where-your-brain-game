package brain.input;

import java.awt.event.KeyEvent;

/**
 * Created by duyanh on 11/1/17.
 */
public class InputManager {
    public boolean jPressed;
    public boolean fPressed;
    public boolean spacePressed;

    public static final InputManager instance = new InputManager();

    private InputManager(){

    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_J){
            jPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_F){
            fPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = true;
        }

    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_J){
            jPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_F){
            fPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            spacePressed = false;
        }
    }

}
