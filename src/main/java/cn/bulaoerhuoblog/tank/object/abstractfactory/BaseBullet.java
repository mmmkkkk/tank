package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

/**
 * @author makun
 */
public abstract class BaseBullet extends GameObject {
    public static final int DEFAULT_SPEED = Integer.parseInt(PropertyManager.getInstance().get("bulletSpeed").toString());
    private Dir dir;

    private boolean living = true;

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public void die() {
        setLiving(false);
    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    
}
