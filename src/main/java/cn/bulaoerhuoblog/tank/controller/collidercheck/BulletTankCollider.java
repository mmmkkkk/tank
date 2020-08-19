package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;

/**
 * @author makun
 */
public class BulletTankCollider implements Collider {
    private Collider next = null;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet b1 = (BaseBullet) o1;
            BaseTank t1 = (BaseTank) o2;
            if (b1.getGroup() == t1.getGroup()) {
                next.collide(o1,o2);
            }
            if (b1.getRect().intersects(t1.getRect())) {
                t1.die();
                b1.die();
                GameObjectManger.getInstance().removeObject(t1);
                GameObjectManger.getInstance().removeObject(b1);
            }

        } else if (o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            collide(o2, o1);
        } else {
            next.collide(o1, o2);
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
