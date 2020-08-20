package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class RectBullet extends BaseBullet {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    private static int SPEED = DEFAULT_SPEED;


    public RectBullet(int x, int y, Dir dir, Group group) {
        setX(x);
        setY(y);
        setDir(dir);
        this.group = group;
        getRect().setRect(x, y, WIDTH, HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            Color c = g.getColor();
            g.setColor(Color.YELLOW);
            g.fillRect(getX() - WIDTH / 2, getY() - HEIGHT / 2, WIDTH, HEIGHT);
            g.setColor(c);
            move();
        }
    }

    private void move() {
        switch (getDir()) {
            case LEFT -> setX(getX() - SPEED);
            case UP -> setY(getY() - SPEED);
            case RIGHT -> setX(getX() + SPEED);
            case DOWN -> setY(getY() + SPEED);
        }

        // update rect
        getRect().setRect(getX(), getY(), WIDTH, HEIGHT);
    }

}
