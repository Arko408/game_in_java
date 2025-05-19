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
        mapnum=new int[gp.col][gp.row];
        tileimage();
        loadmap("/maps/mapofgame.txt");
    }
    public void tileimage()
    {
        try
        {
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
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
            while(col<gp.col && row<gp.row)
            {
                String line=br.readLine();
                while(col<gp.col)
                {
                    String numbers[]=line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapnum[col][row]=num;
                    col++;
                }
                if(col==gp.col)
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
        int col=0,row=0,x=0,y=0;
        while(col<gp.col && row<gp.row)
        {
            int tilenum=mapnum[col][row];
            g2.drawImage(tile[tilenum].image,x,y,gp.size,gp.size,null);
            col++;
            x+=gp.size;
            if(col==gp.col)
            {
                col=0;
                x=0;
                row++;
                y+=gp.size;
            }
        }
    }
}
