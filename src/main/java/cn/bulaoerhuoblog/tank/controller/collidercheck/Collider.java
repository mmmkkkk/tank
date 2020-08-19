package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * 配装器
 * @author makun
 */
public interface Collider {
    /**
     * 碰撞检测
     * @param o1
     * @param o2
     * @return
     */
    void collide(GameObject o1,GameObject o2);

    /**
     * 设置责任链下一个
     */
    void setNext(Collider c);
}
