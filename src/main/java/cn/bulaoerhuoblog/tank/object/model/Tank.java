package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class Tank extends BaseTank {
    private static int SPEED = DEFAULT_SPEED;

    public Tank(int x, int y, Dir dir) {
        setX(x);
        setY(y);
        setDir(dir);
        this.group = Group.GOOD;
        width = ResourceManager.getInstance().p1tankU.getWidth();
        height = ResourceManager.getInstance().p1tankU.getHeight();
        getRect().setRect(x,y,width,height);
        setMoving(false);
        setFireStrategy(PropertyManager.getInstance().get("goodFS").toString());
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            switch (getDir()) {
                case UP -> g.drawImage(ResourceManager.getInstance().p1tankU, getX(), getY(), null);
                case DOWN -> g.drawImage(ResourceManager.getInstance().p1tankD,  getX(), getY(), null);
                case LEFT -> g.drawImage(ResourceManager.getInstance().p1tankL, getX(), getY(), null);
                case RIGHT -> g.drawImage(ResourceManager.getInstance().p1tankR, getX(), getY(), null);
            }
            move();
        }
    }

    private void move() {
        super.move(SPEED);
    }
}
