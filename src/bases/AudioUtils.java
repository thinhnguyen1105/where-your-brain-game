package bases;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 5/12/17.
 */
@SuppressWarnings("deprecation")
public class AudioUtils {

    public static void play(Clip clip){
        clip.setFramePosition(0); // reset con trỏ về đầu đoạn sound
        clip.start();
    }

    /**
     * For playing sound effect: wav
     * @param audioUrl
     * @return
     */
    public static Clip loadSound(String audioUrl) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void initialize() {
        new javafx.embed.swing.JFXPanel();
    }

    /**
     * For playing background music, must calll intialize first: mp3
     * @param audioUrl
     * @return
     */

    public static String uriString = new File("audios/Caravan Palace - Lone Digger Instrumental.mp3").toURI().toString();
    public static MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));

    public static MediaPlayer playMedia(String audioUrl) {
        String uriString = new File(audioUrl).toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();
        return mediaPlayer;
    }
}
