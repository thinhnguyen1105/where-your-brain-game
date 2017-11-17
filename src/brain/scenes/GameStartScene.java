package brain.scenes;

import bases.*;
import brain.input.InputManager;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;
import brain.tutorialScene.LeftTuTorialScene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class GameStartScene extends GameObject implements Scene {
    LeftTuTorialScene leftTuTorialScene;





    public GameStartScene(){
        leftTuTorialScene = new LeftTuTorialScene();



    }

    @Override
    public void run() {

        InputManager inputManager = InputManager.instance;

        if(inputManager.spacePressed){
            GameObject.add(leftTuTorialScene);
            if(inputManager.fPressed){
                SceneManager.changeScene(new GamePlayScene());
            }
        }
    }

    @Override
    public void init() {
        GameObject sceneGameStart = new GameObject();
        sceneGameStart.renderer = new ImageRenderer("assets/images/Scenes/GameStartScene.png");
        sceneGameStart.position.set(192,300);

        GameObject.add(sceneGameStart);
        GameObject.add(new GameStartScene());
    }

    @Override
    public void deinit() {
        GameObject.clearAll();
    }
}
