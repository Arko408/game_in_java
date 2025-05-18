package entity;
import main.game_panel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
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
            y-=speed;
        }
        else if(key.down==true)
        {
            y+=speed;
        }
        else if(key.right==true)
        {
            x+=speed;
        }
        else if(key.left==true)
        {
            x-=speed;
        }
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.blue);
        g2.fillRect(x,y,gp.size,gp.size);
    }
}
