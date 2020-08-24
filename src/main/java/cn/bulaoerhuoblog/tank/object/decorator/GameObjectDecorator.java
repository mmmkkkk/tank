package cn.bulaoerhuoblog.tank.object.decorator;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

import java.awt.*;

/**
 *
 * new RectDecorator(new RedDecorator(new Tank()))
 *
 * @author makun
 */
public abstract class GameObjectDecorator extends GameObject {
    private GameObject gameObject;

    public GameObjectDecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }


    @Override
    public abstract void paint(Graphics g);
    @Override
    public void die() {
        gameObject.die();
        setLiving(false);
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
