package entity;
import main.game_panel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class players extends Entity
{
    game_panel gp;
    KeyHandler key;
    public final int screenx;
    public final int screeny;
    int haskey=0;
    public players(game_panel gp,KeyHandler key2)
    {
        this.gp=gp;
        this.key=key2;
        screenx=gp.width/2-(gp.size/2);
        screeny=gp.height/2-(gp.size/2);
        solid=new Rectangle();
        solid.x=8;
        solid.y=16;
        solidareax=solid.x;
        solidareay=solid.y;
        solid.height=32;
        solid.width=32;
        defaultvalue();
        image();
    }
    public void defaultvalue()
    {
        worldx=gp.size*23;
        worldy=gp.size*21;
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
        if(key.up==true || key.down==true || key.left==true || key.right==true) {
            if (key.up == true) {
                direction = "up";
            } else if (key.down == true) {
                direction = "down";
            } else if (key.right == true) {
                direction = "right";
            } else if (key.left == true) {
                direction = "left";
            }
            collisionon = false;
            gp.checker.checktile(this);
            int objindex=gp.checker.checkobj(this,true);
            pickupobj(objindex);
            if (collisionon == false) {
                switch (direction) {
                    case "up":
                        worldy -= speed;
                        break;
                    case "down":
                        worldy += speed;
                        break;
                    case "left":
                        worldx -= speed;
                        break;
                    case "right":
                        worldx += speed;
                        break;
                }
            }


            counter++;
            if (counter > 10) {
                if (num == 1) {
                    num = 2;
                } else if (num == 2) {
                    num = 1;
                }
                counter = 0;
            }
        }
    }
    public void pickupobj(int id)
    {
        if(id!=999)
        {
            String objname=gp.obj[id].name;
            switch (objname)
            {
                case "key":
                    haskey++;
                    gp.obj[id]=null;
                    break;
                case "door":
                    if(haskey>0)
                    {
                        gp.obj[id]=null;
                        haskey--;
                    }
                    break;
                case "boots":
                    speed+=2;
                    gp.obj[id]=null;
                    break;
            }
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
        g2.drawImage(image,screenx,screeny,gp.size,gp.size,null);
    }
}
