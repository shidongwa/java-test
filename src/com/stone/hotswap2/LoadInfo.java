package com.stone.hotswap2;

/**
 * 封装加载类的信息
 * @author wy
 */
public class LoadInfo {
    //自定义的类加载
    private MyClassLoder myClassLoder;
    //记录要加载的类的时间戳 -->加载的时间
    private long loadTime;

    private BaseManager baseManager;

    public LoadInfo(MyClassLoder myClassLoder, long loadTime) {
        super();
        this.myClassLoder = myClassLoder;
        this.loadTime = loadTime;
    }

    public MyClassLoder getMyClassLoder() {
        return myClassLoder;
    }

    public void setMyClassLoder(MyClassLoder myClassLoder) {
        this.myClassLoder = myClassLoder;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
