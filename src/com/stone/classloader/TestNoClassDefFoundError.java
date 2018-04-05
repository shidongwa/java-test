package com.stone.classloader;

/**
 * compile -> run code -> delete ClassToBeRemoved -> run codes then you can see below exception
 *
 *
Exception in thread "main" java.lang.NoClassDefFoundError: com/stone/classloader/ClassToBeRemoved
		at com.stone.classloader.TestNoClassDefFoundError.main(TestNoClassDefFoundError.java:14)
		Caused by: java.lang.ClassNotFoundException: com.stone.classloader.ClassToBeRemoved
		at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
		at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		... 1 more
*/
public class TestNoClassDefFoundError {

	private ClassToBeRemoved testCls;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TestNoClassDefFoundError test = new TestNoClassDefFoundError();
        
		
		test.testCls = new ClassToBeRemoved();
		System.out.println("just a test.");
	}

}
