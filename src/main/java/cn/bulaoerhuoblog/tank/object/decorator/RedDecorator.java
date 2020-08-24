package cn.bulaoerhuoblog.tank.object.decorator;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

import java.awt.*;

/**
 * @author makun
 */
public class RedDecorator extends GameObjectDecorator {


    public RedDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        // paint

        // 同步位置
        setX(getGameObject().getX());
        setY(getGameObject().getY());
    }
}
