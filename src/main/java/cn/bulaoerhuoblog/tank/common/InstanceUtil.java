package cn.bulaoerhuoblog.tank.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author m_a_k
 */
public class InstanceUtil {

    public static final String GET_INSTANCE = "getInstance";

    public static <T> T  getInstance(Class<T> tClass){
        Object instance = null;
        Method method = null;
        try {
            method = tClass.getDeclaredMethod(GET_INSTANCE);
            instance = method.invoke(null,new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载单例类：" + tClass + "失败");
        }

        return (T) instance;
    }

    public static Object  getInstance(String tClass) {
        Object instance = null;
        Method method = null;
        try {
            Class targetClass = Class.forName(tClass);
            method = targetClass.getDeclaredMethod(GET_INSTANCE);
            instance = method.invoke(null,new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载单例类：" + tClass + "失败");
        }

        return instance;
    }
}
