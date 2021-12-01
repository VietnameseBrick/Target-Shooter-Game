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

class MenuPanel extends MainGame
{
    private Image screen;
    private Image menu;
    private double ans;

    public MenuPanel(String screen) 
    {
        this(new ImageIcon(screen).getImage());
    }

    public MenuPanel(Image screen) 
    {
        this.screen = screen;

        Dimension size = new Dimension(screen.getWidth(null), screen.getHeight(null));

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
        super.paintComponent(g);
        g.drawImage(screen, 0, 0, this);
    }

    class MouseHandler extends MainGame implements MouseListener, MouseMotionListener
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
            ShowPicture start = new ShowPicture();
            start.runner();
            jframe.setVisible(false);
            jframe.removeAll();
            jframe.dispose();
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