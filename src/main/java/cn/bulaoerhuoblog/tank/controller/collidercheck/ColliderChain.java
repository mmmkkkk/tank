package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public class ColliderChain implements Collider {
    private Collider next = null;

    public ColliderChain() {

    }

    public void add(Collider c) {
        c.setNext(next);
        next = c;
    }

    @Override
    public void collide(GameObject o1, GameObject o2) {
        next.collide(o1,o2);
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
