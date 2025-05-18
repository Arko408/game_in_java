package main;

import javax.swing.*;
import java.awt.*;

public class game_panel extends JPanel implements Runnable
{
    final int tile=16;
    final int scale=3;
    final int size=tile*scale;
    final int col=16;
    final int row=14;
    final int width=col*size;
    final int height=row*size;
    Thread thread;
    public game_panel()
    {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    public void startthread()
    {
        thread =new Thread(this);
        thread.start();
    }
    @Override
    public void run()
    {
        while(thread!=null)
        {
            update();
            repaint();
        }
    }
    public void update()
    {

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.darkGray);
        g2.fillRect(150,150,size,size);
        g2.dispose();
    }
}
