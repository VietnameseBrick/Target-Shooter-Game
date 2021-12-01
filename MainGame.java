import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javafx.animation.Timeline;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JButton;
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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Handler;

public class MainGame extends JPanel implements KeyListener
{
    public static JLabel start;
    public static JFrame jframe = new JFrame();
    public static MenuPanel screen = new MenuPanel(new ImageIcon("Menu.jpg").getImage());
    public static ImageIcon image = new ImageIcon("ready.png");
    public static JLabel play = new JLabel(image);
    public static Rectangle button = new Rectangle(play.getWidth(), play.getHeight(), play.getWidth(), play.getHeight());

    public static void main(String [] args)
    {
        jframe.setResizable(false);
        //         jframe.getContentPane().add(men2);
        jframe.getContentPane().add(screen);
        jframe.pack();
        jframe.setVisible(true);
        start = new JLabel();  
        start.setIcon(new ImageIcon("ready.png"));
        Dimension noticeable = start.getPreferredSize();
        screen.add(start);
        start.setBounds(0, 450, noticeable.width, noticeable.height);

        jframe.setFocusable(true);

        //         Jjframe jframe = new Jjframe();
        //         JButton b1 = new JButton();
        //         jframe.setSize(500,500);     
        //         b1.setSize(400,400);
        //         b1.setVisible(true);
        //         b1.setText("HelloWorld");
        //         jframe.add(b1);
        //         jframe.setVisible(true);
        //     }

    }

    public void keyTyped (KeyEvent e)
    {
    }

    public void keyPressed (KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE)
        {
            jframe.setVisible(false);
            jframe.dispose();
        }
    }

    public void keyReleased (KeyEvent e)
    {
        //         int keyCode = e.getKeyCode();
        //         if(keyCode == KeyEvent.VK_ESCAPE)
        //         {
        //             jframe.setVisible(false);
        //             jframe.dispose();
        //         }
        //         else
        //         {
        //             System.out.println("Hi");
        //             //             ShowPicture start = new ShowPicture();
        //             //             start.runner();
        //         }
    }
}
