package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity
{
    public int worldx,worldy,speed;
    public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2;
    public String direction;
    public int counter=0;
    public int num=1;
    public Rectangle solid;
    public int solidareax,solidareay;
    public boolean collisionon=false;
}
