package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseWall;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public class BulletWallCollider implements Collider {
    private static final BulletWallCollider INSTANCE = new BulletWallCollider();

    public static BulletWallCollider getInstance() {
        return INSTANCE;
    }
    
    private Collider next = null;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseWall) {
            BaseBullet b1 = (BaseBullet) o1;
            BaseWall w1 = (BaseWall) o2;
            if (b1.getRect().intersects(w1.getRect())) {
                w1.die();
                b1.die();
            }
        } else if (o1 instanceof BaseWall && o2 instanceof BaseBullet) {
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
