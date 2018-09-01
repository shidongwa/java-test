package com.stone.ToJava8.exercise_6.before;

class Resource {
  public Resource() { System.out.println("Creating...."); }
  public void op1() { System.out.println("some operation 1"); }
  public void op2() { System.out.println("some operation 1"); }
  public void finalize() { System.out.println("external resource cleaned up"); }
}

public class Sample {
	public static void main(String[] args) {
	  Resource resource = new Resource();
	  resource.op1();
	  resource.op2();
	  //cleanup?
  }
}