package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objchest extends superobject
{
    public objchest()
    {
        name="door";
        try
        {
            image= ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
