package cn.bulaoerhuoblog.tank.controller;

import cn.bulaoerhuoblog.tank.common.Dir;
import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.collidercheck.Collider;
import cn.bulaoerhuoblog.tank.controller.collidercheck.ColliderChain;
import cn.bulaoerhuoblog.tank.object.abstractfactory.*;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.object.model.Wall;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author makun
 */
public class GameObjectManger {
    public static int GAME_WIDTH;
    public static int GAME_HEIGHT;
    public static final int REPAIN_INTERVAL = 50;
    private static GameObjectManger INSTANCE = new GameObjectManger();

    private BaseTank myTank;
    private java.util.List<GameObject> gameObjects = new ArrayList<>();
    private Map<Group, AbstractGameObjectFactory> factoryMap = new HashMap<>(8);

    /**
     * 碰撞检测
     */
    private Collider collider = new ColliderChain();


    private GameObjectManger() {
        GAME_WIDTH = Integer.parseInt(PropertyManager.getInstance().get("gameWidth").toString());
        GAME_HEIGHT = Integer.parseInt(PropertyManager.getInstance().get("gameHeight").toString());
        factoryMap.put(Group.GOOD, new DefaultFactory());
        factoryMap.put(Group.BAD, new Enemy1Factory());
        // 初始化玩家坦克
        myTank = factoryMap.get(Group.GOOD).createTank(GAME_WIDTH / 2, GAME_HEIGHT - 100, Dir.UP);
        gameObjects.add(myTank);
        // 初始化敌方坦克
        int initTankCount = Integer.parseInt(PropertyManager.getInstance().get("initTankCount").toString());
        for (int i = 0; i < initTankCount; i++) {
            gameObjects.add(factoryMap.get(Group.BAD).createTank(50 + i * 60, 50, Dir.DOWN));
        }

        // 初始化墙
        for (int i = 0; i < 20; i++) {
            gameObjects.add(new Wall(100 +  i * 15,200));
            gameObjects.add(new Wall(100 +  i * 15,215));
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

        // 碰撞检测
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                collider.collide(gameObjects.get(i), gameObjects.get(j));
            }
        }

        for (int i = 0; i < gameObjects.size(); i++) {
            if (!gameObjects.get(i).isLiving()) {
                removeObject(gameObjects.get(i));
            }
        }
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

    }

    // ------------------------------------------

    public void playerStop() {
        myTank.setMoving(false);
    }

    public void playerFire() {
        if (myTank.isLiving()) {
            fire(myTank.getX() + myTank.getWidth()/2, myTank.getY() + myTank.getHeight() /2, myTank.getDir(), myTank.getGroup(), myTank.getFireStrategy());
        }
    }

    public void playerTankMove(Dir dir) {
        myTank.setMoving(true);
        myTank.setDir(dir);
    }

    public void fire(int x, int y, Dir dir, Group group, String strategy) {
        // TODO 调整x、y使子弹从炮口发射l
        List<GameObject> bullets = factoryMap.get(group).createBullet(x, y, dir, group, strategy);
        addAllObject(bullets);
    }

    public void explode(int x, int y, Group group) {
        BaseExplode explode = factoryMap.get(group).createExplode(x, y);
        addObject(explode);
    }
    // ---------------------------------------------

    public void removeObject(Object o) {
        gameObjects.remove(o);
    }

    public void addObject(GameObject o) {
        gameObjects.add(o);
    }

    public void addAllObject(List<GameObject> o) {
        gameObjects.addAll(o);
    }

    // ------------------------------------------------


}
