package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.object.abstractfactory.BaseWall;
import cn.bulaoerhuoblog.tank.resource.ResourceManager;

import java.awt.*;

/**
 * @author makun
 */
public class Wall extends BaseWall {

    private int width = ResourceManager.getInstance().wall.getWidth();
    private int height = ResourceManager.getInstance().wall.getHeight();

    public Wall(int x,int y) {
        setX(x);
        setY(y);
        getRect().setRect(x,y,width,height);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving()) {
            g.drawImage(ResourceManager.getInstance().wall, getX(),getY(),null);
        }
    }
}
