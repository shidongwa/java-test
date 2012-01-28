package com.stone.classloader;

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
