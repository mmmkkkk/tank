package cn.bulaoerhuoblog.tank.controller.collidercheck;

import cn.bulaoerhuoblog.tank.common.InstanceUtil;
import cn.bulaoerhuoblog.tank.consts.CommonConsts;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategy;
import cn.bulaoerhuoblog.tank.object.model.GameObject;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

/**
 * @author makun
 */
public class ColliderChain implements Collider {
    private Collider next;

    public ColliderChain() {
        // 加载碰撞检测 责任链模式
        String classStrs = PropertyManager.getInstance().get("colliderList").toString();
        String[] classArr = classStrs.split(CommonConsts.PROP_DELIMITER);
        Collider pre = null;
        for (String className : classArr) {
            Object o = InstanceUtil.getInstance(className);
            Collider collider = (Collider) o;
            if (pre != null) {
                collider.setNext(pre);
            }
            pre = collider;
        }
        next = pre;
    }

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (next != null) {
            next.collide(o1, o2);
        }
    }

    @Override
    public void setNext(Collider c) {
        next = c;
    }
}
