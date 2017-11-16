package bases;

public class SceneManager {
    static Scene currentScene;
    static Scene nextScene;


    public static void changeScene(Scene newScene){
        nextScene = newScene;
    }

    public static void changeSceneIfNeeded(){
        // 1. Ask to change scene

        if(nextScene != null){
            if(currentScene != null)
                currentScene.deinit();
                nextScene.init();

                currentScene = nextScene;
                nextScene = null;
        }

        //2. If exist
    }
}
