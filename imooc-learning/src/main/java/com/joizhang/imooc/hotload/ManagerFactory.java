package com.joizhang.imooc.hotload;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载 manager 的工厂
 */
public class ManagerFactory {

    public static final String CLASS_PATH = "E:\\workspace\\justjava\\imooc-learning\\target\\classes\\com\\joizhang\\imooc\\hotload";
    /**
     * 实现热加载的类的全名称
     */
    public static final String MY_MANAGER = "com.joizhang.imooc.hotload.MyManager";
    /**
     * 记录热加载类的加载信息
     */
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();

    public static BaseManager getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replace("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            // 加载的时间戳变化了，依旧加载
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setManager(manager);
        loadTimeMap.put(className, loadInfo);
    }

    /**
     * 以反射的方式创建对象实例
     *
     * @param loadClass
     * @return
     */
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
