package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
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
public class EnemyTank extends BaseTank {
    private static int SPEED = DEFAULT_SPEED;




    private Random random = new Random();

    public EnemyTank(int x, int y, Dir dir) {
        setX(x);
        setY(y);
        setDir(dir);
        this.group = Group.BAD;
        width = ResourceManager.getInstance().p1tankU.getWidth();
        height = ResourceManager.getInstance().p1tankU.getHeight();
        getRect().setRect(x,y,width,height);
        setFireStrategy(PropertyManager.getInstance().get("badFS").toString());
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            switch (getDir()) {
                case UP -> g.drawImage(ResourceManager.getInstance().e1tankU, getX(), getY(), null);
                case DOWN -> g.drawImage(ResourceManager.getInstance().e1tankD, getX(), getY(), null);
                case LEFT -> g.drawImage(ResourceManager.getInstance().e1tankL, getX(), getY(), null);
                case RIGHT -> g.drawImage(ResourceManager.getInstance().e1tankR, getX(), getY(), null);
            }
            move();
        }
    }

    private void move() {
        if (random.nextInt(100) > 95) {
            GameObjectManger.getInstance().fire(getX(),getY(),getDir(),group,getFireStrategy());
        }
        if (random.nextInt(100) > 95) {
            randomDir();
        }
        super.move(SPEED);
    }

    private void randomDir() {
        setDir(Dir.values()[random.nextInt(4)]);
    }


}
