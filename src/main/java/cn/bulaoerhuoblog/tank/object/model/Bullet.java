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
        this.x = x;
        this.y = y;
        setDir(dir);
        this.group = group;
        getRect().setRect(x,y,WIDTH,HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            g.drawImage(ResourceManager.getInstance().bulletP, x, y, null);
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
        // TODO 碰撞检测
//        if (x < 0 || y < 0 || x > GameObjectManger.GAME_WIDTH || y > GameObjectManger.GAME_HEIGHT) {
//            living = false;
//        }
    }
}
