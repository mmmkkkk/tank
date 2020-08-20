package cn.bulaoerhuoblog.tank.controller.firestrategy;

import cn.bulaoerhuoblog.tank.common.InstanceUtil;
import cn.bulaoerhuoblog.tank.consts.CommonConsts;
import cn.bulaoerhuoblog.tank.resource.PropertyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author makun
 */
public class FireStrategyManager {
    private static Map<String,FireStrategy> strategyMap = new HashMap<>();
    private static FireStrategyManager INSTANCE = new FireStrategyManager();

    private FireStrategyManager() {
        // 加载fire策略  策略模式
        String classStrs = PropertyManager.getInstance().get("fireStrategy").toString();
        String[] classArr = classStrs.split(CommonConsts.PROP_DELIMITER);
        for (String className : classArr) {
            Object o = InstanceUtil.getInstance(className);
            System.out.println(className);
            System.out.println(o);
            System.out.println(strategyMap == null);
            strategyMap.put(className.substring(className.lastIndexOf(".") + 1), (FireStrategy) o);
        }
    }

    public static FireStrategyManager getInstance() {
        return INSTANCE;
    }

    public FireStrategy getStrategy(String key) {
        return strategyMap.get(key);
    }
}
