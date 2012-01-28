package com.stone.classloader;

/**
 * if at runtime, ClassToBeRemoved is deleted, we'll get java.lang.NoClassDefFoundError at class which reference this class.
 *  e.g. in our case, in the TestNoClassDefFoundError class 
 *
 * @author shidong
 *
 */
public class ClassToBeRemoved {

}

