package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseExplode;
import cn.bulaoerhuoblog.tank.resource.Audio;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceManager.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceManager.getInstance().explodes[0].getHeight();

    GameObjectManger gm = null;

    private int step = 0;

    public RectExplode(int x, int y) {
        setX(x);
        setY(y);
        new Audio("audio/blast.wav").start();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 10 * step, 10 * step);
        step++;
        if (step >= 5) {
            step = 0;
        }
        g.setColor(c);
    }

}
