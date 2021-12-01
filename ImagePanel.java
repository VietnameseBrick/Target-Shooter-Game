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
class ImagePanel extends ShowPicture
{
    private Image img;
    private Image menu;
    private double ans;
    public static int score = 0;
    private int x = 0;
    private int y = 0;
    private int dank = 0;
    public static ImagePanel screen = new ImagePanel(new ImageIcon("demonic.png").getImage());
    private Image hit; 

    public ImagePanel(String img) 
    {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) 
    {
        this.img = img;

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        setLayout(null);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
    }

    public void paintComponent(Graphics g) 
    {
        int time = (100 - tally) / 2;
        g.drawImage(img, 0, 0, null);
        g.setColor(Color.white);
        g.setFont(new Font("OCR A Extended", Font.PLAIN, 30)); 
        int value = score;
        g.drawString("Score: " + score + "", 1000, 40);
        g.drawString("Time Remaining: " + time, 850, 70);

        hit = Toolkit.getDefaultToolkit().getImage("cod.png");
        g.drawImage(hit, x - 24, y - 25, 50, 50, null);
        if(strike == 3 || tally == 100)
        {
            g.setFont(new Font("OCR A Extended", Font.PLAIN, 30)); 
            g.drawString("Your Score: " + score, 325, 250);
            g.drawString("Press anywhere on screen to exit.", 200, 350);
        }
    }

    public int getScore()
    {
        return score;
    }

    class MouseHandler extends ShowPicture implements MouseListener, MouseMotionListener
    {
        public void mouseMoved(MouseEvent e) 
        {

        }

        public void mouseDragged(MouseEvent e) 
        {

        }

        public void mousePressed(MouseEvent e) 
        {

        }

        public void mouseReleased(MouseEvent e) 
        {
            x = e.getX();
            y = e.getY();
            double a = label.getX() + 128.0;
            double b = label.getY() + 128.0;
            double x = e.getX();
            double y = e.getY();
            ans = Math.sqrt(((x-a)*(x-a)) + ((y-b)*(y-b)));

            if(ans <= 128.0 && count != 3)
            {
                score++;
                dank++;

                img.remove(label);
                img.repaint();
                try {
                    // Open an audio input stream.
                    URL url = this.getClass().getClassLoader().getResource("hitsound.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                    // Get a sound clip resource.
                    Clip clip = AudioSystem.getClip();
                    // Open audio clip and load samples from the audio input stream.
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException r) {
                    r.printStackTrace();
                } catch (IOException r) {
                    r.printStackTrace();
                } catch (LineUnavailableException r) {
                    r.printStackTrace();
                }
            }
            else if (ans > 128.0 && count != 3)
            {
                strike++;
                try {
                    // Open an audio input stream.
                    URL url = this.getClass().getClassLoader().getResource("fall.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                    // Get a sound clip resource.
                    Clip clip = AudioSystem.getClip();
                    // Open audio clip and load samples from the audio input stream.
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException f) {
                    f.printStackTrace();
                } catch (IOException f) {
                    f.printStackTrace();
                } catch (LineUnavailableException f) {
                    f.printStackTrace();
                }
            } 

            if (strike == 1)
            {
                picture = new JLabel();  
                picture.setIcon(new ImageIcon("x-red.png"));
                Dimension appear = picture.getPreferredSize();
                img.add(picture);   
                picture.setBounds(20, 10, appear.width, appear.height);
                count = 1;
            }
            if (strike == 2)
            {
                picture2 = new JLabel();  
                picture2.setIcon(new ImageIcon("x-red.png"));
                Dimension visible = picture2.getPreferredSize();
                img.add(picture2);
                picture2.setBounds(120, 10, visible.width, visible.height);
                count = 2;
            }
            if(strike == 3)
            {
                picture3 = new JLabel();  
                picture3.setIcon(new ImageIcon("x-red.png"));
                Dimension noticeable = picture3.getPreferredSize();
                img.add(picture3);
                picture3.setBounds(220, 10, noticeable.width, noticeable.height);
                count = 3;

            }
            if (strike == 4)
            {
                System.exit(0);
            }
            if (count == 3)
            {
                count = 4;
                frame.setVisible(false);
                frame.dispose();

                //           System.out.print("Wow! You're score is: " + score + " ! You are AMAZING!");
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
                //         frame.getContentPane().add(men2);
                frame1.getContentPane().add(create);
                frame1.pack();
                frame1.setVisible(true);
            }
        }        

        public int getScore()
        {
            return score;
        }

        public void mouseEntered(MouseEvent e) 
        {

        }

        public void mouseExited(MouseEvent e) 
        {

        }

        public void mouseClicked(MouseEvent e) 
        {

        }
    }
}