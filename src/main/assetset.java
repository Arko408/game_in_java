package main;

import object.objKey;
import object.objboots;
import object.objchest;
import object.objdoor;

public class assetset
{
    game_panel gp;
    public assetset(game_panel gp)
    {
        this.gp=gp;
    }
    public void setobj()
    {
        gp.obj[0]=new objKey();
        gp.obj[0].worldx=23*gp.size;
        gp.obj[0].worldy=7*gp.size;

        gp.obj[1]=new objKey();
        gp.obj[1].worldx=23*gp.size;
        gp.obj[1].worldy=40*gp.size;

        gp.obj[2]=new objKey();
        gp.obj[2].worldx=38*gp.size;
        gp.obj[2].worldy=8*gp.size;

        gp.obj[3]=new objdoor();
        gp.obj[3].worldx=10*gp.size;
        gp.obj[3].worldy=11*gp.size;

        gp.obj[4]=new objdoor();
        gp.obj[4].worldx=8*gp.size;
        gp.obj[4].worldy=28*gp.size;

        gp.obj[5]=new objdoor();
        gp.obj[5].worldx=12*gp.size;
        gp.obj[5].worldy=22*gp.size;

        gp.obj[6]=new objchest();
        gp.obj[6].worldx=10*gp.size;
        gp.obj[6].worldy=7*gp.size;

        gp.obj[7]=new objboots();
        gp.obj[7].worldx=37*gp.size;
        gp.obj[7].worldy=42*gp.size;
    }
}
