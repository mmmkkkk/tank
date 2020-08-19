package cn.bulaoerhuoblog.tank.controller;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.collidercheck.Collider;
import cn.bulaoerhuoblog.tank.controller.collidercheck.ColliderChain;
import cn.bulaoerhuoblog.tank.object.abstractfactory.*;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.model.Tank;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author makun
 */
public class GameObjectManger {
    public static final int GAME_WIDTH = Integer.parseInt(PropertyManager.getInstance().get("gameWidth").toString());
    public static final int GAME_HEIGHT = Integer.parseInt(PropertyManager.getInstance().get("gameHeight").toString());

    private static GameObjectManger INSTANCE = new GameObjectManger();

    private Tank myTank;
    public java.util.List<GameObject> gameObjects = new ArrayList<>();
    public AbstractGameObjectFactory gf = new RectFactory();

    // 碰撞检测
    Collider collider = new ColliderChain();


    private GameObjectManger() {
        // 初始化玩家坦克
        myTank = new Tank(100, 400, Dir.DOWN);
        gameObjects.add(myTank);
        // 初始化敌方坦克
        int initTankCount = Integer.parseInt(PropertyManager.getInstance().get("initTankCount").toString());
        for (int i = 0; i < initTankCount; i++) {
            gameObjects.add(new Tank(50 + i * 80, 200, Dir.DOWN));
        }
    }

    public static GameObjectManger getInstance() {
        return INSTANCE;
    }

    public void paint(Graphics g) {
//        Color color = g.getColor();
//        g.setColor(Color.WHITE);
//        g.drawString("子弹数量" + bulletList.size(), 10, 60);
//        g.drawString("敌人数量" + enemyList.size(), 10, 80);
//        g.drawString("爆炸数量" + explodeList.size(), 10, 100);
//        g.setColor(color);

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                collider.collide(gameObjects.get(i), gameObjects.get(j));
            }
        }

    }

    public  BaseExplode createExplode(int x, int y) {
        return gf.createExplode(x, y);
    }

    public  BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return gf.createBullet(x, y, dir, group);
    }


    public void removeObject(Object o) {
        gameObjects.remove(o);
    }


    /**
     * TODO 响应按键
     */
//    private void setMainTankDir() {
//        if (!bL && !bR && !bU && !bD) {
//            myTank.setMoving(false);
//        } else {
//            myTank.setMoving(true);
//            if (bL) {
//                myTank.setDir(Dir.LEFT);;
//            }
//            if (bR) {
//                myTank.setDir(Dir.RIGHT);;
//            }
//            if (bU) {
//                myTank.setDir(Dir.UP);;
//            }
//            if (bD) {
//                myTank.setDir(Dir.DOWN);;
//            }
//        }
//    }


}
