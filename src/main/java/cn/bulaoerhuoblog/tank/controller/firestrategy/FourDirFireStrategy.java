package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
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
public class FourDirFireStrategy implements FireStrategy {
    private static FourDirFireStrategy INSTANCE = new FourDirFireStrategy();


    private FourDirFireStrategy() {
    }

    public static FourDirFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public List<GameObject> fire(int x, int y, Dir dir, Group group, Class targetBullet) {
        Dir[] dirs = Dir.values();
        List<GameObject> bullets = new ArrayList<>(2);
        for (Dir dirTmp : dirs) {
            GameObject bullet = null;
            try {
                bullet = (GameObject) targetBullet.getDeclaredConstructor(new Class[] {int.class,int.class,Dir.class,Group.class}).newInstance(new Object[]{x, y, dirTmp, group});
            }  catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("FourDirFireStrategy 创建fire 失败");
            }
            bullets.add(bullet);
        }
        return bullets;
    }
}
