package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.Bullet;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class FourDirFireStrategy implements FireStrategy {
    private static FourDirFireStrategy INSTANCE = new FourDirFireStrategy();


    private FourDirFireStrategy() {
    }

    public static FourDirFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(BaseTank tank) {
        // TODO 子弹在正确位置出现
        int bX = tank.getX() + tank.getWidth() / 2 - Bullet.WIDTH;
        int bY = tank.getY() + tank.getHeight() / 2 - Bullet.HEIGHT;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            GameObjectManger.getInstance().createBullet(bX, bY, dir,tank.getGroup());
        }
    }
}
