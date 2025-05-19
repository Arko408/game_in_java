package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class objKey extends superobject
{
    public objKey()
    {
        name="key";
        try
        {
            image= ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
