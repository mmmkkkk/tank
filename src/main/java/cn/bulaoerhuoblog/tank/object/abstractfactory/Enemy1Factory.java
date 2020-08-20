package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategy;
import cn.bulaoerhuoblog.tank.object.model.*;

import java.util.List;


/**
 * @author makun
 */
public class Enemy1Factory extends AbstractGameObjectFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir) {
        return new EnemyTank(x, y, dir);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new Explode(x, y);
    }

    @Override
    public List<GameObject> createBullet(int x, int y, Dir dir, Group group,String strategy) {
        FireStrategy fireStrategy = fireStrategyManager.getStrategy(strategy);
        List<GameObject> bullets = fireStrategy.fire(x,y,dir,group, Bullet.class);
        return bullets;    }
}
