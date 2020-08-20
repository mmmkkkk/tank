package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;

/**
 * @author makun
 */
public interface FireStrategy {
    /**
     * fire strategy
     * @param tank
     */
    void fire(BaseTank tank);
}
