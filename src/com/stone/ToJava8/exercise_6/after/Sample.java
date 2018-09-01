package com.stone.ToJava8.exercise_6.after;

import java.util.function.Consumer;

class Resource {
  private Resource() { System.out.println("Creating...."); }
  public void op1() { System.out.println("some operation 1"); }
  public void op2() { System.out.println("some operation 1"); }
  private void close() { System.out.println("external resource cleaned up"); }
  
  public static void use(Consumer<Resource> block) {
    Resource resource = new Resource();
    try {
      block.accept(resource);
    } finally {
      resource.close();
    }
  }
}

public class Sample {
	public static void main(String[] args) {
	  Resource.use(resource -> {
	    resource.op1();
  	  resource.op2();
	  });
  }
}