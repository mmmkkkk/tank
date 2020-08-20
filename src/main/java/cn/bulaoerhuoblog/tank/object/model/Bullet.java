package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class Bullet extends BaseBullet {
    public static final int WIDTH = ResourceManager.getInstance().bulletP.getWidth();
    public static final int HEIGHT = ResourceManager.getInstance().bulletP.getHeight();
    private static int SPEED = DEFAULT_SPEED;



    public Bullet(int x, int y, Dir dir, Group group) {
        setX(x);
        setY(y);
        setDir(dir);
        this.group = group;
        getRect().setRect(x,y,WIDTH,HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            g.drawImage(ResourceManager.getInstance().bulletP, getX(), getY(), null);
            move();
        }
    }

    private void move() {
        switch (getDir()) {
            case LEFT ->  setX(getX() - SPEED);
            case UP -> setY(getY() - SPEED);
            case RIGHT -> setX(getX() + SPEED);
            case DOWN -> setY(getY() + SPEED);
        }

        // update rect
        getRect().setRect(getX(),getY(),WIDTH,HEIGHT);
    }
}
