package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

import java.util.List;

/**
 * @author makun
 */
public interface FireStrategy {
    /**
     * fire strategy
     * @param x
     * @param y
     * @param dir
     * @param group
     * @param targetBullet
     */
    List<GameObject> fire(int x, int y, Dir dir, Group group, Class targetBullet);
}
