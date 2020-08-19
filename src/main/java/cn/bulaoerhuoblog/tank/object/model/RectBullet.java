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
    public static final int WIDTH = ResourceManager.getInstance().bulletP.getWidth();
    public static final int HEIGHT = ResourceManager.getInstance().bulletP.getHeight();

    private static int SPEED = DEFAULT_SPEED;



    public RectBullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        setDir(dir);
        this.group = group;
        getRect().setRect(x,y,WIDTH,HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            Color c = g.getColor();
            g.setColor(Color.YELLOW);
            g.fillRect(x,y,15,15);
            g.setColor(c);
            move();
        }
    }

    private void move() {
        switch (getDir()) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        // update rect
        getRect().setRect(x,y,WIDTH,HEIGHT);
    }

}
