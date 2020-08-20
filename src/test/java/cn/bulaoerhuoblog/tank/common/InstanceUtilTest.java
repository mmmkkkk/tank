package cn.bulaoerhuoblog.tank.common;

import cn.bulaoerhuoblog.tank.controller.firestrategy.FireStrategy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class InstanceUtilTest {

    @Test
    public void testGetInstance() {
        FireStrategy o = (FireStrategy) InstanceUtil.getInstance("cn.bulaoerhuoblog.tank.controller.firestrategy.DefaultFireStrategy");
        assertNotNull(o);
    }
}