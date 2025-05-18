package main;

import entity.players;

import javax.swing.*;
import java.awt.*;

public class game_panel extends JPanel implements Runnable
{
    final int tile=16;
    final int scale=3;
    public final int size=tile*scale;
    final int col=16;
    final int row=14;
    final int width=col*size;
    final int height=row*size;
    KeyHandler key=new KeyHandler();
    Thread thread;
    players player=new players(this,key);
    int px=100;
    int py=100;
    int speed=4     ;
    int fps=60;
    public game_panel()
    {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    public void startthread()
    {
        thread =new Thread(this);
        thread.start();
    }
    @Override
    public void run()
    {
        double drawinterval=1000000000/fps;
        double nextdrawtime=System.nanoTime()+drawinterval;
        while(thread!=null)
        {
            update();
            repaint();
            try
            {
                double remaining=nextdrawtime-System.nanoTime();
                remaining=remaining/1000000;
                if(remaining<0)
                {
                     remaining=0;
                }
                thread.sleep((long)remaining);
                nextdrawtime+=drawinterval;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
