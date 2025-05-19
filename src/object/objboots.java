package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objboots extends superobject
{
    public objboots()
    {
        name="boots";
        try
        {
            image= ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
