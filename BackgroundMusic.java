import java.io.*;
import sun.audio.*;
import java.net.URL;
import javax.sound.sampled.*;
/**
 * Write a description of class BackgroundMusic here.
 * 
 * @author
 * @version
 */
public class BackgroundMusic extends ShowPicture
{
    public void playMusic()
    {
        try
        {
            // Open an audio input stream.
            //             URL url = this.getClass().getClassLoader().getResource("danktunes.wav");
            File audio = new File("danktunes.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audio);
            // Get a sound clip resource.
            //             Clip clip = AudioSystem.getClip();
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Open audio clip and load samples from the audio input stream.
            Clip clip = (Clip) AudioSystem.getLine(info);

            //             clip.open(audioIn);
            clip.open(audioIn);
            clip.start();
            if (frame.isVisible() == true)
            {
                clip.start();
            }
            else if (frame1.isVisible() == true)//if(strike == 3 || count == 3 || tally == 100)
            {
                clip.stop();
                clip.close();
            }
        }
        catch (UnsupportedAudioFileException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) 
        {
            e.printStackTrace();
        }
        
        if (strike == 4)
        {
            System.exit(0);
        }
    }
}
