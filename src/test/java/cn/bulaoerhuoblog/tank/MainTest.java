package cn.bulaoerhuoblog.tank;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        try {
            BufferedImage image = ImageIO.read(new File("/home/makun/Downloads/img/p1tankD.gif"));
            assertNotNull(image);

            BufferedImage image1 = ImageIO.read(MainTest.class.getClassLoader().getResourceAsStream("images/p1tankD.gif"));
            assertNotNull(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}