package tile;

import main.game_panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class manager
{
    game_panel gp;
    Tile[] tile;
    int mapnum[][];
    public manager(game_panel gp)
    {
        this.gp=gp;
        tile =new Tile[10];
        mapnum=new int[gp.worldcol][gp.worldrow];
        tileimage();
        loadmap("/maps/world01.txt");
    }
    public void tileimage()
    {
        try
        {
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision=true;
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
            tile[2].collision=true;
            tile[3]=new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            tile[4]=new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision=true;
            tile[5]=new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/road07.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void loadmap(String path)
    {
        try
        {
            InputStream is=getClass().getResourceAsStream(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int row=0,col=0;
            while(col<gp.worldcol && row<gp.worldrow)
            {
                String line=br.readLine();
                while(col<gp.worldcol)
                {
                    String numbers[]=line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapnum[col][row]=num;
                    col++;
                }
                if(col==gp.worldcol)
                {
                    col=0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        int worldcol=0;
        int worldrow=0;

        while(worldcol<gp.worldcol && worldrow<gp.worldrow)
        {
            int tilenum=mapnum[worldcol][worldrow];
            int worldx=worldcol*gp.size;
            int worldy=worldrow*gp.size;
            int screenx=worldx-gp.player.worldx+gp.player.screenx;
            int screeny=worldy-gp.player.worldy+gp.player.screeny;
            if(worldx+gp.size>gp.player.worldx-gp.player.screenx &&
                    worldx-gp.size<gp.player.worldx+gp.player.screenx &&
                    worldy+gp.size>gp.player.worldy-gp.player.screeny &&
                    worldy-gp.size<gp.player.worldy+gp.player.screeny)
            {
                g2.drawImage(tile[tilenum].image,screenx,screeny,gp.size,gp.size,null);
            }
            worldcol++;
            if(worldcol==gp.worldcol)
            {
                worldcol=0;
                worldrow++;
            }
        }
    }
}
