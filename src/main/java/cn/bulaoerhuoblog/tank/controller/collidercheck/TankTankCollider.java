package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.model.Tank;

/**
 * @author makun
 */
public class TankTankCollider implements Collider{
    private Collider next = null;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(o2.getRect())) {

            }
        }
        next.collide(o1,o2);
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
