package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public class TankTankCollider implements Collider {
    private static final TankTankCollider INSTANCE = new TankTankCollider();

    public static TankTankCollider getInstance() {
        return INSTANCE;
    }

    private Collider next = null;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseTank) {
            BaseTank t1 = (BaseTank) o1;
            BaseTank t2 = (BaseTank) o2;
            if (t1.getRect().intersects(o2.getRect())) {
                if (t1.getGroup() == t2.getGroup()) {
                    t1.back();
                    t2.back();
                } else {
                    BaseTank good = t1.getGroup() == Group.GOOD ? t1 : t2;
                    good.die();
                    GameObjectManger.getInstance().explode(good.getX(), good.getY(), good.getGroup());

                }

            }
        }
        if (next != null) {
            next.collide(o1, o2);
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
