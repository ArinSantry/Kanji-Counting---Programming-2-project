/*
 * WAV.java, KanjiCounting, Team Millennium.
 * Helper class to CountingGame.java.
 * Sets up sound input streams to allow for audio files to play.
 */
package KanjiCounting;

import java.io.BufferedInputStream;
import javax.sound.sampled.*;
import java.io.InputStream;

/**
 * Audio files by Namiko Abe, "Learn Basic Counting and Numbers in Japanese." ThoughtCo.
 * @author Millennium
 */
public class WAV {
    private Clip clip;

    public WAV(String filename)
    {
        try
        {
            InputStream is = this.getClass().getResourceAsStream(filename);
            InputStream bis = new BufferedInputStream(is);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
        }
        catch (Exception e)
        {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
    }
        
    public void play()
    {
        if(clip.isRunning())
            clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }
}
