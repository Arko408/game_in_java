package main;

import entity.Entity;

public class checkcollision
{
    game_panel gp;
    public checkcollision(game_panel gp)
    {
        this.gp=gp;
    }
    public void checktile(Entity entity)
    {
        int entityleftworldx=entity.worldx+entity.solid.x;
        int entityrightworldx=entity.worldx+entity.solid.x+entity.solid.width;
        int entitytopworldy=entity.worldy+entity.solid.y;
        int entitybottomworldy=entity.worldy+entity.solid.y+entity.solid.height;

        int entityleftcol=entityleftworldx/gp.size;
        int entityrightcol=entityrightworldx/gp.size;

        int entitytoprow=entitytopworldy/gp.size;
        int entitybottomrow=entitybottomworldy/gp.size;

        int tilenum1,tilenum2;
        switch (entity.direction)
        {
            case "up":
                entitytoprow=(entitytopworldy-entity.speed)/gp.size;
                tilenum1=gp.tilem.mapnum[entityleftcol][entitytoprow];
                tilenum2=gp.tilem.mapnum[entityrightcol][entitytoprow];
                if(gp.tilem.tile[tilenum1].collision==true || gp.tilem.tile[tilenum2].collision==true)
                {
                    entity.collisionon=true;
                }
                break;
            case "down":
                entitybottomrow=(entitybottomworldy+entity.speed)/gp.size;
                tilenum1=gp.tilem.mapnum[entityleftcol][entitybottomrow];
                tilenum2=gp.tilem.mapnum[entityrightcol][entitybottomrow];
                if(gp.tilem.tile[tilenum1].collision==true || gp.tilem.tile[tilenum2].collision==true)
                {
                    entity.collisionon=true;
                }
                break;
            case "left":
                entityleftcol=(entityleftworldx-entity.speed)/gp.size;
                tilenum1=gp.tilem.mapnum[entityleftcol][entitytoprow];
                tilenum2=gp.tilem.mapnum[entityleftcol][entitybottomrow];
                if(gp.tilem.tile[tilenum1].collision==true || gp.tilem.tile[tilenum2].collision==true)
                {
                    entity.collisionon=true;
                }
                break;
            case "right":
                entityrightcol=(entityrightworldx+entity.speed)/gp.size;
                tilenum1=gp.tilem.mapnum[entityrightcol][entitytoprow];
                tilenum2=gp.tilem.mapnum[entityrightcol][entitybottomrow];
                if(gp.tilem.tile[tilenum1].collision==true || gp.tilem.tile[tilenum2].collision==true)
                {
                    entity.collisionon=true;
                }
                break;
        }
    }
    public int checkobj(Entity entity,boolean player)
    {
        int index=999;
        for(int i=0 ; i<gp.obj.length ; i++)
        {
            if(gp.obj[i]!=null)
            {
                entity.solid.x=entity.worldx+entity.solid.x;
                entity.solid.y=entity.worldy+entity.solid.y;
                gp.obj[i].solidarea.x=gp.obj[i].worldx+gp.obj[i].solidarea.x;
                gp.obj[i].solidarea.y=gp.obj[i].worldy+gp.obj[i].solidarea.y;
                switch (entity.direction)
                {
                    case "up":
                        entity.solid.y-=entity.speed;
                        if(entity.solid.intersects(gp.obj[i].solidarea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionon=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                    case "down":
                        entity.solid.y+=entity.speed;
                        if(entity.solid.intersects(gp.obj[i].solidarea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionon=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                    case "left":
                        entity.solid.x-=entity.speed;
                        if(entity.solid.intersects(gp.obj[i].solidarea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionon=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                    case "right":
                        entity.solid.x+=entity.speed;
                        if(entity.solid.intersects(gp.obj[i].solidarea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionon=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                }
                entity.solid.x=entity.solidareax;
                entity.solid.y=entity.solidareay;
                gp.obj[i].solidarea.x=gp.obj[i].solidareax;
                gp.obj[i].solidarea.y=gp.obj[i].solidareay;
            }
        }
        return index;
    }
}
