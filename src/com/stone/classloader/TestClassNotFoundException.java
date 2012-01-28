package com.stone.classloader;

public class TestClassNotFoundException {

	/**
	 * Remove com.stone.classloader.ClassToBeRemoved in the classpath(bin dir),then we can see this exception.
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("in TestClassNotFoundException");
		
		Class.forName("com.stone.classloader.ClassToBeRemoved");
	}

}
