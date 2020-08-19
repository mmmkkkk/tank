package cn.bulaoerhuoblog.tank.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author makun
 */
public class ResourceManager {
    private static ResourceManager INSTANCE =  new ResourceManager();
    private ResourceManager() {
        try {
            p1tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/p1tankU.gif"));
            p1tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/p1tankL.gif"));
            p1tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/p1tankD.gif"));
            p1tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/p1tankR.gif"));

            e1tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/enemy1U.gif"));
            e1tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/enemy1L.gif"));
            e1tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/enemy1D.gif"));
            e1tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/enemy1R.gif"));

            bulletP = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankmissile.gif"));

            for (int i = 0; i < 8; i++) {
                explodes[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/blast" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage p1tankL, p1tankU, p1tankD, p1tankR, e1tankU, e1tankD, e1tankL, e1tankR;

    public BufferedImage bulletP;

    public BufferedImage[] explodes = new BufferedImage[8];



    public static ResourceManager getInstance() {
        return INSTANCE;
    }

}
