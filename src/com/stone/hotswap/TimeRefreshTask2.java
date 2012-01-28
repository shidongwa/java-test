package com.stone.hotswap;

import java.lang.reflect.Method;

import com.stone.hotswap.swap.Foo;
import com.stone.hotswap.swap.IFoo;

public class TimeRefreshTask2 extends java.util.TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("time refresh task starts");
		
	    try { 
	        // 每次都创建出一个新的类加载器
	    	// using absolute file path, not sure how to using relative path
	        HotswapCL cl = new HotswapCL("C:\\workspace\\MyTestPrj\\bin", new String[]{"com.stone.hotswap.swap.Foo2"});
	        
	        Class cls = cl.loadClass("com.stone.hotswap.swap.Foo2"); 
	        	       
	        //this way  we will not get ClassCastException, cause IFoo is loaded by System class loader instead of HotswayCL.
	        IFoo foo2 = (IFoo)cls.newInstance();
	        foo2.sayHello();
	        

	    
	    }  catch(Exception ex) { 
	        ex.printStackTrace(); 
	    } 

	    
	}

}


