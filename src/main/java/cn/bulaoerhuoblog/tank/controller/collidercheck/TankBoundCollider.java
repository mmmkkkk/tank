package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class TankBoundCollider implements Collider {
    private static final TankBoundCollider INSTANCE = new TankBoundCollider();

    public static TankBoundCollider getInstance() {
        return INSTANCE;
    }

    private Collider next;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank) {
            BaseTank t1 = (BaseTank) o1;
            if (t1.getX() < 2) {
                t1.back();
            } else if (t1.getY() < 28) {
                t1.back();
            } else if (t1.getX() > GameObjectManger.GAME_WIDTH - t1.getWidth()) {
                t1.back();
            } else if (t1.getY() > GameObjectManger.GAME_HEIGHT - t1.getHeight()) {
                t1.back();
            } else {
                if (next != null) {
                    next.collide(o1, o2);
                }
            }
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
