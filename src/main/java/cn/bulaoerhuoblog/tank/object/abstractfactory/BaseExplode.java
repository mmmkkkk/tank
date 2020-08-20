package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public abstract class BaseExplode extends GameObject {
    @Override
    public void die() {
        setLiving(false);
    }
}
