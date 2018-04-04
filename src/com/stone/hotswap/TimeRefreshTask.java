package com.stone.hotswap;

import java.lang.reflect.Method;

import com.stone.hotswap.swap.Foo;

public class TimeRefreshTask extends java.util.TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("time refresh task starts");
		
	    try { 
	        // 每次都创建出一个新的类加载器
	        HotswapCL cl = new HotswapCL("/Users/shidonghua/IdeaProjects/TestPrj/out/production/classes", new String[]{"com.stone.hotswap.swap.Foo"});
	        
	        Class cls = cl.loadClass("com.stone.hotswap.swap.Foo"); 
	        
	        //use reflection because foo should be in HotswapCL namespace,we have no way to reference it in system class loader(current classloader)
	        Object foo = cls.newInstance(); 
	        Method m = foo.getClass().getMethod("sayHello", new Class[]{}); 
	        m.invoke(foo, new Object[]{}); 
	       
	        //this should not work, cause Foo() belongs to two different class loader namespace.
/*	        Foo foo = (Foo)cls.newInstance();
	        foo.sayHello();*/
	        

	    
	    }  catch(Exception ex) { 
	        ex.printStackTrace(); 
	    } 

	    
	}

}


