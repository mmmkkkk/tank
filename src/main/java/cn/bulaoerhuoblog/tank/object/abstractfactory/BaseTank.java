package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

/**
 * @author makun
 */
public abstract class BaseTank extends GameObject {
    public static final int DEFAULT_SPEED = Integer.parseInt(PropertyManager.getInstance().get("tankSpeed").toString());

    protected int width;
    protected int height;

    private boolean living = true;
    private boolean moving = true;
    private Dir dir = Dir.DOWN;

    private int preX, preY;

    @Override
    public void die() {
        living = false;
        moving = false;
    }


    protected void move(int SPEED) {
        if (!isMoving()) {
            return;
        }
        preX = x;
        preY = y;
        switch (getDir()) {
            case LEFT -> x -= SPEED;
            case UP -> y -= SPEED;
            case RIGHT -> x += SPEED;
            case DOWN -> y += SPEED;
        }
        // update rect
        getRect().setRect(x,y,width,height);
    }


    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
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
        this.x = this.preX;
        this.y = this.preY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
