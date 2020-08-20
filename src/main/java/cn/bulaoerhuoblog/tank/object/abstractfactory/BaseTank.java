package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

/**
 * @author makun
 */
public abstract class BaseTank extends GameObject {
    public static final int DEFAULT_SPEED = Integer.parseInt(PropertyManager.getInstance().get("tankSpeed").toString());


    /**
     * tank宽
     */
    protected int width;
    /**
     * tank高
     */
    protected int height;


    /**
     * 是否移动
     */
    private boolean moving = true;
    /**
     * 方向
     */
    private Dir dir = Dir.DOWN;

    private int preX, preY;

    private String fireStrategy;


    @Override
    public void die() {
        setLiving(false);
        moving = false;
    }


    protected void move(int SPEED) {
        if (!isMoving()) {
            return;
        }
        preX = getX();
        preY = getY();
        switch (getDir()) {
            case LEFT ->  setX(getX() - SPEED);
            case UP -> setY(getY() - SPEED);
            case RIGHT -> setX(getX() + SPEED);
            case DOWN -> setY(getY() + SPEED);
        }
        // update rect
        getRect().setRect(getX(),getY(),width,height);
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void back() {
        setX(this.preX);
        setY(this.preY);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public String getFireStrategy() {
        return fireStrategy;
    }

    public void setFireStrategy(String fireStrategy) {
        this.fireStrategy = fireStrategy;
    }
}
