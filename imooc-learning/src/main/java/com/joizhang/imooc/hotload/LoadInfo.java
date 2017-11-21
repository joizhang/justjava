package com.joizhang.imooc.hotload;

/**
 * 封装加载类的信息
 * @author joizhang
 */
public class LoadInfo {

    private MyClassLoader myClassLoader;

    /**
     * 记录要加载类的时间戳
     */
    private long loadTime;

    private BaseManager manager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        super();
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}
