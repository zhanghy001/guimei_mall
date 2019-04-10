package cn.guimei_mall.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Hao on 2019/3/20.
 */
public class ConfigManager {
    //加载配置文件
    // 饿汉模式
//    static ConfigManager configManager = new ConfigManager();
//    static {
//        confingManager = new ConfigManager();
//    }



    static ConfigManager confingManager;
    Properties properties;
    public ConfigManager(){
        properties = new Properties();
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    // 单利 懒汉模式
    public static ConfigManager getInstance(){
        if (confingManager == null){
            confingManager = new ConfigManager();
        }
        return  confingManager;
    }

    // 根据key获得value方法
    public String getValues(String key){
        return properties.getProperty(key);
    }


}
