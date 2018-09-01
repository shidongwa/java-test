package com.stone.ToJava8.exercise_5.after;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Sample {
  public static void printSorted(List<Person> people, Comparator<Person> comparator) {
    System.out.println("----------------------");
    people.stream()
          .sorted(comparator)
          .forEach(System.out::println);
  }
  
	public static void main(String[] args) {
	  List<Person> people = Arrays.asList(
	    new Person("Sara", 12),
	    new Person("Mark", 43),
	    new Person("Bob", 12),
	    new Person("Jill", 64));

    Function<Person, Integer> byAge = Person::getAge;
    Function<Person, String> byName = Person::getName;

    printSorted(people, comparing(byAge));
    printSorted(people, comparing(byName));
    
    printSorted(people, comparing(byAge).thenComparing(byName));
  }
}