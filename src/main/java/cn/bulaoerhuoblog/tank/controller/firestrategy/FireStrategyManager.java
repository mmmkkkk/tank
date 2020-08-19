package cn.bulaoerhuoblog.tank.controller.firestrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author makun
 */
public class FireStrategyManager {

    private FireStrategyManager() {}

    private static Map<String,FireStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("FourDirFireStrategy",FourDirFireStrategy.getInstance());
        strategyMap.put("DefaultFireStrategy", DefaultFireStrategy.getInstance());
    }

    public static FireStrategy getStrategy(String key) {
        return strategyMap.get(key);
    }
}
