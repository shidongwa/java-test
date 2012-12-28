package com.stone.javacore;

/**
 * test in one thread, if there is any deadlock when both parent and child methods 
 * have synchronized in one method call
 * it seems this is lock reentrant issue and it is allowed in java
 * @author dong
 *
 */


public class TestSynchronized {

	public static void main(String[] args){
		new Thread(){
			public void run(){
				System.out.println("start to run the thread");
				new ChildClass().doSomething();
				System.out.println("end of running the thread");
			}
		}.start();
	}
	
}


class ParentClass{
	public synchronized void doSomething(){
		System.out.println("do something in parent");
	}
}

class ChildClass extends ParentClass{
	public synchronized void doSomething(){
		System.out.println("do more things here");
		super.doSomething();
	}
}
