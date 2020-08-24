package cn.bulaoerhuoblog.tank.object.decorator;

import cn.bulaoerhuoblog.tank.object.model.GameObject;

import java.awt.*;

/**
 * @author makun
 */
public class RectDecorator extends GameObjectDecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        // 画装饰内容
        g.drawRect(getGameObject().getX() - 2, getGameObject().getY() - 2, getGameObject().getRect().width + 4, getGameObject().getRect().height + 4);
        // 画被装饰内容
        getGameObject().paint(g);
        g.setColor(c);

        // 同步位置
        setX(getGameObject().getX());
        setY(getGameObject().getY());
    }
}
