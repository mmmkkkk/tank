package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseExplode;
import cn.bulaoerhuoblog.tank.resource.Audio;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class Explode extends BaseExplode {
    public static int WIDTH = ResourceManager.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceManager.getInstance().explodes[0].getHeight();

    private int step = 0;

    public Explode(int x, int y) {
        setX(x);
        setY(y);
        new Audio("audio/blast.wav").start();
    }

    @Override
    public void paint(Graphics g) {
        if (step >= ResourceManager.getInstance().explodes.length) {
            return;
        }
        g.drawImage(ResourceManager.getInstance().explodes[step++], getX(), getY(), null);
        if (step >= ResourceManager.getInstance().explodes.length) {
            die();
        }
    }

    @Override
    public void die() {
        setLiving(false);
    }
}
