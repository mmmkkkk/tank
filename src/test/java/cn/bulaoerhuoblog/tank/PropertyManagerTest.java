package cn.bulaoerhuoblog.tank;

import cn.bulaoerhuoblog.tank.resource.PropertyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyManagerTest {

    @Test
    public void testGet() {
        Object val = PropertyManager.getInstance().get("initTankCount");
        assertEquals("10",val);
    }

}