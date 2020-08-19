package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.Tank;

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
