package brain.background;

import bases.AudioUtils;
import bases.GameObject;
import brain.FallingObjects.FallingObjects;
import com.sun.javafx.text.TextLine;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Score extends GameObject {

    public static int score;

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Moonshiner",Font.BOLD,30));
        g.drawString("Score : " +Score.score,290,40);

    }

    public Score(){
        score = 0;
    }
    public static void addScore(int num){
        AudioUtils.play(AudioUtils.loadSound("audios/sfx_point.wav"));
        score+=num;
    }
    public void run(){
//        System.out.println(FallingObjects.Speed);
        if(score >=4){
            FallingObjects.Speed = 4;
        }
        if(score>=8){
            FallingObjects.Speed = 5;
        }
        if(score >= 13){
            FallingObjects.Speed = 8;
        }
        if(score >= 20){
            FallingObjects.Speed = 9;
        }
    }
}
