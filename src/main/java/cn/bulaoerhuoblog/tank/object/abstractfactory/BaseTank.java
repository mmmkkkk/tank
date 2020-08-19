package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

/**
 * @author makun
 */
public abstract class BaseTank extends GameObject {
    public static final int DEFAULT_SPEED = Integer.parseInt(PropertyManager.getInstance().get("tankSpeed").toString());

    private boolean living = true;
    private boolean moving = true;
    private Dir dir = Dir.DOWN;

    @Override
    public void die() {
        living = false;
        moving = false;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
