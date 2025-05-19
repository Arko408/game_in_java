package object;

import main.game_panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class superobject
{
    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int worldx,worldy;
    public Rectangle solidarea=new Rectangle(0,0,48,48);
    public int solidareax=0;
    public int solidareay=0;
    public void draw(Graphics2D g2, game_panel gp)
    {
        int screenx=worldx-gp.player.worldx+gp.player.screenx;
        int screeny=worldy-gp.player.worldy+gp.player.screeny;
        if(worldx+gp.size>gp.player.worldx-gp.player.screenx &&
                worldx-gp.size<gp.player.worldx+gp.player.screenx &&
                worldy+gp.size>gp.player.worldy-gp.player.screeny &&
                worldy-gp.size<gp.player.worldy+gp.player.screeny)
        {
            g2.drawImage(image,screenx,screeny,gp.size,gp.size,null);
        }
    }
}
