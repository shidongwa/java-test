package com.stone.classloader.log;


import java.lang.reflect.Method;
/**
 * @author yankai913@gmail.com
 * @date 2014-6-12
 */
public class ClassLoaderTest {

    public void say() {
        System.out.println("hello world");
    }


    public static void main(String[] args) throws Exception {
        // 打印java虚拟机的ClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());
        // 自定义ClassLoader
        ClassLoader myLoader = new MyClassLoader();
        Class<?> clazz = myLoader.loadClass("com.stone.classloader.log.ClassLoaderTest");
        Object obj = clazz.newInstance();
        // 打印自定义ClassLoader加载的Class对象
        System.out.println(obj.getClass());
        // 打印被加载的Class对象是由哪个ClassLoader加载的
        System.out.println(obj.getClass().getClassLoader());
        /*
         * 对于任意一个类，由加载它的ClassLoader和它本身决定了在jvm虚拟机中的唯一性。
         * 也就是说比较2个类，只有它们都是由同一个ClassLoader加载，那么比较才有意义。
         * 否则，即使是同一个类文件，只要加载它们的ClassLoader不同，那么这2个类必定不相等。
         */
        // false
        System.out.println(obj instanceof com.stone.classloader.log.ClassLoaderTest);
        // 由自定义ClassLoader加载后，在程序里运行。
        Method method = clazz.getDeclaredMethod("say", new Class<?>[]{});
        method.invoke(obj, new Object[]{});
        // 获取当前上下文的ClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 改变上下文的ClassLoader
        Thread.currentThread().setContextClassLoader(myLoader);
        // 获取当前上下文的ClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 改变当前上下文的ClassLoader可以改变在当前线程派生出的子线程的上下文ClassLoader
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t2 = Thread.currentThread();
                System.out.println(t2.getName() + ":" + t2.getContextClassLoader());
            }
        });
        t.start();
        Thread.sleep(3000);
        // 获取CallClassLoader
        Class<?> clz = Class.forName("com.stone.classloader.log.ClassLoaderTest");
        System.out.println(clz);
        System.out.println(clz.getClassLoader());
        System.out.println(clz.getClass());
        System.out.println(clz.getClass().getClassLoader());
    }
}
