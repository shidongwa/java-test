package com.stone.hotswap2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载MyManager的工厂
 * @author wy
 */
public class ManagerFactory {
    //记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();
    //要加载的类的classpath
    public static final String CLASS_PATH = "/Users/shidonghua/IdeaProjects/TestPrj/out/production/classes/";
    //实现热加载的类的全名称（包名+类名）
    public static final String MY_MANAGER = "com.stone.hotswap2.MyManager";

    public static BaseManager getManager(String className){
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();
        //loadTimeMap 不包含className为key的LoadInfo信息。证明这个类没有加载
        if(loadTimeMap.get(className) == null){
            load(className, lastModified);
        }
        //加载类的时间戳变化了，我们需要重新加载
        else if (loadTimeMap.get(className).getLoadTime() != lastModified){
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    public static void load(String className, long lastModified){
        MyClassLoder myClassLoder = new MyClassLoder(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoder.findClass(className);
        }catch (Exception e){
            e.printStackTrace();
        }
        BaseManager baseManager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoder, lastModified);
        loadInfo.setBaseManager(baseManager);
        loadTimeMap.put(className, loadInfo);
    }

    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
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
