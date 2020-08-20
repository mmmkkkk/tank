package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.Bullet;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class DefaultFireStrategy implements FireStrategy {

    private static DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

    private DefaultFireStrategy() {

    }


    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(BaseTank tank) {
        // TODO 子弹在正确位置出现
        int bX = tank.getX() + tank.getWidth() / 2 - Bullet.WIDTH;
        int bY = tank.getY() + tank.getHeight() / 2 - Bullet.HEIGHT;
        Dir[] dirs = Dir.values();
        new Bullet(bX, bY, tank.getDir(),tank.getGroup());
    }
}
