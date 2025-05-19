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
}
