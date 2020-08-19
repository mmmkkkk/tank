package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;

/**
 * @author makun
 */
public abstract class AbstractGameObjectFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);

    public abstract BaseExplode createExplode(int x, int y);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group);
}

