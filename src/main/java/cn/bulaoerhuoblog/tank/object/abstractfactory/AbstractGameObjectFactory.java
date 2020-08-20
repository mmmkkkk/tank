package cn.bulaoerhuoblog.tank.object.abstractfactory;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategyManager;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

import java.util.List;

/**
 * @author makun
 */
public abstract class AbstractGameObjectFactory {

    protected FireStrategyManager fireStrategyManager = FireStrategyManager.getInstance();

    public abstract BaseTank createTank(int x, int y, Dir dir);

    public abstract BaseExplode createExplode(int x, int y);

    public abstract List<GameObject> createBullet(int x, int y, Dir dir, Group group,String strategy);
}

