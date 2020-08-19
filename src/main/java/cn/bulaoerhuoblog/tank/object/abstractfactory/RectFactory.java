package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.model.RectBullet;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class RectFactory extends AbstractGameObjectFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new Tank(x, y, dir);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new RectExplode(x, y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new RectBullet(x, y, dir, group);
    }

}
