package brain.FallingObjects;

import bases.GameObject;
import bases.Vector2D;
import bases.actions.*;
import brain.background.Score;
import brain.input.InputManager;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;
import brain.traps.TrapSpawner;
import brain.tutorialScene.LeftTuTorialScene;
import brain.tutorialScene.RightTutorialScene;

public class SpawnerManager extends GameObject {
    Spawner leftSpawner;
    Spawner rightSpawner;
    RightTutorialScene rightTutorialScene;

    public SpawnerManager(){

        Action waitAction = new ActionWait(1200);
        Action waitAction2 = new ActionWait(1200);
        Action waitAction3 = new ActionWait(1200);
        Action waitAction0 = new ActionWait(500);
        Action pressedAction = new Action() {
            InputManager inputManager = InputManager.instance;
            @Override
            public boolean run(GameObject owner) {
                removeByType(PlayerRightShape.class);
                removeByType(PlayerLeftShape.class);
                return inputManager.jPressed;
            }

            @Override
            public void reset() {

            }
        };

        Action rightTutorial = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.remove(leftSpawner);
                rightTutorialScene = new RightTutorialScene();
                GameObject.add(rightTutorialScene);
                return true;
            }

            @Override
            public void reset() {

            }
        };


        Action fallingLeftAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.remove(rightSpawner);
                leftSpawner = new Spawner(new Vector2D(105,-20));
                GameObject.add(leftSpawner);
                return true;
            }

            @Override
            public void reset() {
                
            }
        };

        Action fallingRightAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.add(new PlayerLeftShape());
                GameObject.add(new PlayerRightShape());
                GameObject.remove(rightTutorialScene);
                GameObject.remove(leftSpawner);
                rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(rightSpawner);

                return true;
            }

            @Override
            public void reset() {

            }
        };

        Action fallingBothAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                leftSpawner = new Spawner(new Vector2D(105,-20));
                rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(leftSpawner);
                GameObject.add(rightSpawner);
                return true;
            }

            @Override
            public void reset() {

            }
        };

        Action trapAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.add(new TrapSpawner());
                return true;
            }

            @Override
            public void reset() {

            }
        };


        Action actionSequence = new ActionSequence(fallingLeftAction, waitAction,rightTutorial,pressedAction,fallingRightAction,waitAction2,fallingBothAction, waitAction3, trapAction);
        this.addAction(actionSequence);

    }
}
