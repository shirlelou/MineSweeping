package view;

import javax.sound.sampled.*;
import java.awt.event.MouseEvent;
import java.io.*;

public class Music {
    private static Clip music;
    private static AudioInputStream audioInputStream;
    Music(){
    }

    public static void start(){
        try {
            music=AudioSystem.getClip();
            InputStream inputStream=Music.class.getResourceAsStream("bgm1.wav");
            if (inputStream != null) {
                audioInputStream=AudioSystem.getAudioInputStream(inputStream);
            }
            music.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        music.start();
    }

    public static void loop(){
        try {
            music=AudioSystem.getClip();
            File file=new File("src//music//bgm1.wav");
            FileInputStream fileInputStream =new FileInputStream(file);
            InputStream is =new BufferedInputStream(fileInputStream);
            if (is != null) {
                audioInputStream=AudioSystem.getAudioInputStream(is);
            }
            music.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop(){
        if (audioInputStream!=null){
            music.close();
        }
    }


}
