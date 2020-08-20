package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseTank;
import cn.bulaoerhuoblog.tank.object.model.Bullet;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.model.Tank;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author makun
 */
public class DefaultFireStrategy implements FireStrategy {

    private static DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

    private DefaultFireStrategy() {

    }


    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public List<GameObject> fire(int x, int y, Dir dir, Group group, Class targetBullet) {
        List<GameObject> bullets = new ArrayList<>(2);
        GameObject bullet = null;
        try {
            bullet = (GameObject)targetBullet.getDeclaredConstructor().newInstance(new Object[] {x,y,dir,group});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        bullets.add(bullet);
        return bullets;
    }
}
