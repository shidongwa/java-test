package com.stone.ToJava8.exercise_4.after;

import java.io.File;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Sample {
	public static void main(String[] args) {
	  File aDirectory = new File(".");
	  
	  System.out.println(
  	  Stream.of(aDirectory.listFiles())
	          .map(File::getName)
	          .collect(joining(", ")));
  }
}