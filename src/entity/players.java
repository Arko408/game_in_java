package entity;
import main.game_panel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class players extends entity2
{
    game_panel gp;
    KeyHandler key;
    public players(game_panel gp,KeyHandler key2)
    {
        this.gp=gp;
        this.key=key2;
        defaultvalue();
        image();
    }
    public void defaultvalue()
    {
        x=100;
        y=100;
        speed=5;
        direction="down";

    }
    public void image()
    {
        try
        {
            up1= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_down_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_left_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/playerpic/boy_right_2.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }
    public void update()
    {
        if(key.up==true)
        {
            direction="up";
            y-=speed;
        }
        else if(key.down==true)
        {
            direction="down";
            y+=speed;
        }
        else if(key.right==true)
        {
            direction="right";
            x+=speed;
        }
        else if(key.left==true)
        {
            direction="left";
            x-=speed;
        }
        counter++;
        if(counter>10)
        {
            if(num==1)
            {
                num=2;
            }
            else if(num==2)
            {
                num=1;
            }
            counter=0;
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image=null;
        switch (direction)
        {
            case "up":
                if(num==1)
                {
                    image=up1;
                }
                if(num==2)
                {
                    image=up2;
                }
                break;
            case "down":
                if(num==1)
                {
                    image=down1;
                }
                if(num==2)
                {
                    image=down2;
                }
                break;
            case "left":
                if(num==1)
                {
                    image=left1;
                }
                if(num==2)
                {
                    image=left2;
                }
                break;
            case "right":
                if(num==1)
                {
                    image=right1;
                }
                if(num==2)
                {
                    image=right2;
                }
                break;
        }
        g2.drawImage(image,x,y,gp.size,gp.size,null);
    }
}
