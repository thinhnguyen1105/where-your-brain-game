package brain.scenes;

import bases.AudioUtils;
import bases.GameObject;
import bases.Scene;
import bases.Vector2D;
import brain.FallingObjects.Spawner;
import brain.FallingObjects.SpawnerManager;
import brain.background.*;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;
import brain.traps.TrapSpawner;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class GamePlayScene implements Scene {
    MediaPlayer backgroundMusic;

    @Override
    public void init() {
        backgroundMusic = AudioUtils.playMedia("audios/Lobo_Loco_-_01_-_Herbie_Munster_Party_ID_731.mp3");
        backgroundMusic.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                backgroundMusic.seek(Duration.ZERO);
            }
        });

        GameObject.add(new BackGround());

        GameObject.add(new Score());

        GameObject.add(new LightEffect1());

        GameObject.add(new LightEffect2());

        GameObject.add(new LightEffect3());

        GameObject.add(new LightEffect4());

        GameObject.add(new LightEffect5());

        GameObject.add(new LightEffect_Am2());

        GameObject.add(new LightEffect_Am3());

        GameObject.add(new PlayerRightShape());

        GameObject.add(new PlayerLeftShape());

        GameObject.add(new SpawnerManager());

        GameObject.add(new LifesOfPlayer());


    }

    @Override
    public void deinit() {
        GameObject.clearAll();
    }
}
