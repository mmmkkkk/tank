package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.model.Bullet;
import cn.bulaoerhuoblog.tank.object.model.Explode;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class DefaultFactory extends AbstractGameObjectFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new Tank(x, y, dir);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new Explode(x, y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new Bullet(x, y, dir, group);
    }
}
