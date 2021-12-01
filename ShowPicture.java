import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javafx.animation.Timeline;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Point;
import java.io.*;
import sun.audio.*;
import java.net.URL;
import javax.sound.sampled.*;

class ShowPicture extends JPanel
{
    public static JFrame frame = new JFrame();
    public static JLabel label = new JLabel();
    public static JFrame frame1 = new JFrame();
    public static ImagePanel create = new ImagePanel(new ImageIcon("demonic.png").getImage());

    public static ImagePanel img = new ImagePanel(new ImageIcon("wallpaper.png").getImage());

    public static BackgroundMusic music = new BackgroundMusic();

    public static Cursor cursor = Cursor.getDefaultCursor();
    public static JLabel picture;
    public static JLabel picture2;
    public static JLabel picture3;
    public static JLabel smashpic;
    public static int strike = 0;
    public static int count = 0;
    public static int tally = 0;
    //     public static  int score = 0;
    //     Rectangle target = new Rectangle(img.getX(), img.getY(), img.getWidth(), img.getHeight());
    //     private static boolean bullseye;
    //     private static boolean miss;

    public void runner()

    {
        music.playMusic();
        //         ImagePanel img2 = new ImagePanel(new ImageIcon("CapShield05.png").getImage());

        frame.setResizable(false);
        //         frame.getContentPane().add(img2);
        frame.getContentPane().add(img);
        frame.pack();
        frame.setVisible(true);

        label = new JLabel();  
        label.setIcon(new ImageIcon("target2.png"));
        Dimension size = label.getPreferredSize();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursor = toolkit.getImage("hand.png");
        Point hotSpot = new Point(9, 10);
        Cursor customCursor = toolkit.createCustomCursor(cursor, hotSpot, "Cursor");

        frame.setCursor(customCursor);
        frame.setTitle("CustomCursor");

        try 
        {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("voice.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();

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
       
        class TimerListener extends ShowPicture implements ActionListener
        {
            private boolean popup;

            public TimerListener(boolean popup)
            {
                this.popup = popup;
            }

            public void actionPerformed(ActionEvent event)
            {                        
                if(popup == true)
                {
                    img.add(label);
                    label.setBounds((int)(Math.random() * (700) + 100), ((int)(Math.random() * 350 + 75)), size.width, size.height);
                    img.repaint();
                    tally++;
                }
                if (popup == false)
                {      
                    img.remove(label);
                    img.repaint();
                    tally++;
                }
                if (tally == 100)
                {
                    {
                        frame.setVisible(false);
                        frame.dispose();
                        try 
                        {
                            // Open an audio input stream.
                            URL url = this.getClass().getClassLoader().getResource("wow.wav");
                            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                            // Get a sound clip resource.
                            Clip wow = AudioSystem.getClip();
                            // Open audio clip and load samples from the audio input stream.
                            wow.open(audioIn);
                            wow.start();
                        } 
                        catch (UnsupportedAudioFileException w) 
                        {
                            w.printStackTrace();
                        } 
                        catch (IOException w) 
                        {
                            w.printStackTrace();
                        } 
                        catch (LineUnavailableException w) 
                        {
                            w.printStackTrace();
                        }

                        frame1.setResizable(false);
                        
                        frame1.getContentPane().add(create);
                        frame1.pack();
                        frame1.setVisible(true);
                    }                          
                }
            }
        }    

        ActionListener listener = new TimerListener(false);
        ActionListener listener2 = new TimerListener(true);

        final int DELAY = 550; // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, listener);
        t.start();
        t.setRepeats(true);

        final int DELAY2 = 550; // Milliseconds between timer ticks
        Timer t2 = new Timer(DELAY2, listener2);
        t2.start();
        t2.setRepeats(true);

    }
}