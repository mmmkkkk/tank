package cn.bulaoerhuoblog.tank.resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author makun
 */
public class PropertyManager {

    private PropertyManager() {
        try {
            props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PropertyManager instance = new PropertyManager();

    private  Properties props = new Properties();

    public static PropertyManager getInstance() {
        return instance;
    }

    public Object get(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }
}
