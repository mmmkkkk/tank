package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategy;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategyManager;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;
import java.util.Random;

/**
 * @author makun
 */
public class Tank extends BaseTank {
    private static int SPEED = DEFAULT_SPEED;

    private Random random = new Random();

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
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
                case UP -> g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankU : ResourceManager.getInstance().e1tankU, x, y, null);
                case DOWN -> g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankD : ResourceManager.getInstance().e1tankD, x, y, null);
                case LEFT -> g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankL : ResourceManager.getInstance().e1tankL, x, y, null);
                case RIGHT -> g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankR : ResourceManager.getInstance().e1tankR, x, y, null);
            }
            move();
        }
    }

    private void move() {
        super.move(SPEED);
    }

}
