package main;

import entity.players;
import tile.manager;

import javax.swing.*;
import java.awt.*;

public class game_panel extends JPanel implements Runnable
{
    public final int tile=16;
    public final int scale=3;
    public final  int size=tile*scale;
    public final int col=16;
    public final int row=12;
    public final int width=col*size;
    public final int height=row*size;
    public final int worldcol=50;
    public final int worldrow=50;
    public final int worldwidth=size*worldcol;
    public final int worldheight=size*worldrow;
    KeyHandler key=new KeyHandler();
    Thread thread;
    public players player=new players(this,key);
    int fps=60;
    manager tilem=new manager(this);
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
        tilem.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
