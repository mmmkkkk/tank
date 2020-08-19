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
public class Tank extends BaseTank {
    private static int SPEED = DEFAULT_SPEED;
    public static int WIDTH = ResourceManager.getInstance().p1tankU.getWidth();
    public static int HEIGHT = ResourceManager.getInstance().p1tankU.getHeight();

    private FireStrategy fireStrategy;

    private Random random = new Random();

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        setDir(dir);
        this.group = Group.GOOD;
        getRect().setRect(x,y,WIDTH,HEIGHT);
        setMoving(false);
        String fireStrategyName;
        if (this.group == Group.BAD) {
            fireStrategyName = PropertyManager.getInstance().get("badFS").toString();
        } else {
            fireStrategyName = PropertyManager.getInstance().get("goodFS").toString();
        }
        fireStrategy = FireStrategyManager.getStrategy(fireStrategyName);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            switch (getDir()) {
                case UP -> {g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankU : ResourceManager.getInstance().e1tankU, x, y, null); break;}
                case DOWN -> {g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankD : ResourceManager.getInstance().e1tankD, x, y, null); break;}
                case LEFT -> {g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankL : ResourceManager.getInstance().e1tankL, x, y, null); break;}
                case RIGHT -> {g.drawImage(this.group == Group.GOOD ? ResourceManager.getInstance().p1tankR : ResourceManager.getInstance().e1tankR, x, y, null); break;}
            }
            move();
        }
    }

    private void move() {
        if (!isMoving()) {
            return;
        }
        switch (getDir()) {
            case LEFT -> x -= SPEED;
            case UP -> y -= SPEED;
            case RIGHT -> x += SPEED;
            case DOWN -> y += SPEED;
        }
        boundsCheck();
        // update rect
        getRect().setRect(x,y,WIDTH,HEIGHT);

    }

    /**
     * TODO 移动到碰撞检测
     */
    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > GameObjectManger.GAME_WIDTH - Tank.WIDTH){
            x = GameObjectManger.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > GameObjectManger.GAME_HEIGHT - Tank.HEIGHT) {
            y = GameObjectManger.GAME_HEIGHT - Tank.HEIGHT - 2;
        }

    }

    private void randomDir() {
        setDir(Dir.values()[random.nextInt(4)]);
    }

    public void fire() {
        fireStrategy.fire(this);
    }
}
