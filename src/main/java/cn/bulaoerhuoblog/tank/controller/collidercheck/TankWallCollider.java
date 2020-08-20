package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseWall;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public class TankWallCollider  implements Collider {
    private static final TankWallCollider INSTANCE = new TankWallCollider();

    public static TankWallCollider getInstance() {
        return INSTANCE;
    }

    private Collider next;


    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseWall) {
            BaseTank t1 = (BaseTank) o1;
            BaseWall w1 = (BaseWall) o2;
            if (t1.getRect().intersects(w1.getRect())) {
                t1.back();
            }
        } else if (o1 instanceof BaseWall && o2 instanceof BaseTank) {
            collide(o2, o1);
        } else {
            if (next != null) {
                next.collide(o1, o2);
            }
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
