package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseBullet;
import cn.bulaoerhuoblog.tank.object.model.GameObject;

/**
 * @author makun
 */
public class BulletBoundCollider implements Collider {
    private Collider next;

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet) {
            BaseBullet b1 = (BaseBullet) o1;
            if (b1.getX() < 0 || b1.getY() < 0 || b1.getX() > GameObjectManger.GAME_WIDTH || b1.getY() > GameObjectManger.GAME_HEIGHT) {
                b1.die();
                GameObjectManger.getInstance().removeObject(b1);
                return;
            }
            next.collide(o1, o2);
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
