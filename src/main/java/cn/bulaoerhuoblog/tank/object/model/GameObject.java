package cn.bulaoerhuoblog.tank.object.model;

import cn.bulaoerhuoblog.tank.common.Group;

import java.awt.*;

/**
 * @author makun
 */
public abstract class GameObject {
    private int x, y;

    private Rectangle rect = new Rectangle();

    protected Group group = Group.BAD;

    /**
     * 是否存活
     */
    private boolean living = true;

    /**
     * 绘制自身
     * @param g
     */
    public abstract void paint(Graphics g);

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    /**
     * 物体死亡
     */
    public abstract void die();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

}
