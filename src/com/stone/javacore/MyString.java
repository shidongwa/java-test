package com.stone.javacore;

import java.security.CodeSource;
import java.security.ProtectionDomain;



public class MyString {

	/**
	 * @param args
	 * 1. using -verbose VM arguments to observe class loading
	 * 2. can define our own String class
	 * 3. we can show the concrete location of non-system class
	 */
	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		
		System.out.println(str);
		
		//we can show the concrete location of non-system class
		ProtectionDomain pd = MyString.class.getProtectionDomain();   
		CodeSource cs = pd.getCodeSource();   
		System.out.println(cs.getLocation());
	}

}

// use defined String class
/*class String {
	
}*/
