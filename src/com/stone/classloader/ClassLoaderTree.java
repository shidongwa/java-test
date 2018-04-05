package com.stone.classloader;

/**
 compile -> run code -> delete ClassToBeRemoved -> run codes then you can see below exception

 Exception in thread "main" java.lang.ClassNotFoundException: com.stone.classloader.ClassToBeRemoved
 at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
 at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
 at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
 at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
 at java.lang.Class.forName0(Native Method)
 at java.lang.Class.forName(Class.java:264)
 at com.stone.classloader.TestClassNotFoundException.main(TestClassNotFoundException.java:14)
 in TestClassNotFoundException

 */
public class ClassLoaderTree { 

    public static void main(String[] args) { 
        ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } 
    } 
}
