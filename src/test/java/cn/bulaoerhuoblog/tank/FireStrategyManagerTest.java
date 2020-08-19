package cn.bulaoerhuoblog.tank;

import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategy;
import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireStrategyManagerTest {

    @Test
    public void testGetStrategy() {
        FireStrategy fireStrategy = FireStrategyManager.getStrategy("DefaultFire");
        assertNotNull(fireStrategy);
    }

}