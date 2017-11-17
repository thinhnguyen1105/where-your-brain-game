package bases;

import bases.actions.Action;
import brain.FallingObjects.FallingObjects;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;
import brain.traps.Traps;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameObject {
    public Vector2D position;


    public Renderer renderer;

    public boolean isActive;

    public ArrayList<Action> actions;
    public ArrayList<Action> newActions;
    
    static Vector<GameObject> gameObjects = new Vector<>();

    static Vector<GameObject> newGameObjects = new Vector<>();

    static Vector<GameObject> rmGameObects = new Vector<>();

    public GameObject() {
        position = new Vector2D();
        isActive = true;
        actions = new ArrayList<>();
        newActions = new ArrayList<>();
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, position);
        }
    }

    public void run() {

    }

    public void runActions(){
        // run for all actions and if run return true then remove it
        this.actions.removeIf(action -> action.run(this));
        this.actions.addAll(newActions);
        newActions.clear();
    }

    public void addAction(Action action){
        newActions.add(action);
    }

    public void trapDetector() {
        if (this instanceof FallingObjects) {
            for (GameObject gameObject : gameObjects) {
                if (gameObject instanceof Traps && gameObject.isActive) {
                    if (((FallingObjects) this).hitBox.collideWith(((Traps) gameObject).hitBox)) {
                        gameObject.isActive = false;
                        ((Traps) gameObject).runEffect((FallingObjects)this);
//                        ((FallingObjects) this).Speed = 9;
                    }
                }
            }
        }
    }
    
    public static void runAll(){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.trapDetector();
                gameObject.run();
                gameObject.runActions();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        gameObjects.removeAll(rmGameObects);
        rmGameObects.clear();
    }
    public static void removeByType(Class cls){
        for(GameObject gameObject: gameObjects){
            if(gameObject.getClass().equals(cls)){
                rmGameObects.add(gameObject);
            }
        }
    }

    public static void remove(GameObject gameObject) {
        rmGameObects.add(gameObject);
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public static void clearAll() {
        gameObjects.clear();
        newGameObjects.clear();
    }
    public int typeCheck(GameObject gameObject){
        if(gameObject instanceof Circle){
            return 0;
        }
        if(gameObject instanceof Diamond){
            return 3;
        }
        if(gameObject instanceof Square){
            return 1;
        }
        if(gameObject instanceof Triangle){
            return 2;
        }
        return -1;
    }

    public static <T extends GameObject> T recycle(Class<T> cls){
        for(GameObject gameObject:gameObjects){
            if(gameObject.isActive==false && gameObject.getClass().equals(cls)){
                gameObject.isActive=true;
                return (T)gameObject;
            }
        }
        try {
            T newGameObject=  cls.newInstance();//new
            newGameObject.isActive = true;
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRenderer(Animation animation) {
    }
}
