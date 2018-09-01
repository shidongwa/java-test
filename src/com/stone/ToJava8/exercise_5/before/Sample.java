package com.stone.ToJava8.exercise_5.before;

import java.util.*;
import java.util.Collections;

public class Sample {
	public static void main(String[] args) {
	  List<Person> people = Arrays.asList(
	    new Person("Sara", 12),
	    new Person("Mark", 43),
	    new Person("Bob", 12),
	    new Person("Jill", 64));

    Collections.sort(people);
	  
	  System.out.println(people);
	  //This is evil, we took the list and modified it. Also, we intruded into the Person class with Comparable.
  }
}