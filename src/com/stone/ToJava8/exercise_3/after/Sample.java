package com.stone.ToJava8.exercise_3.after;

import java.util.*;

class TimeSlot {
  static Random random = new Random();

  public void schedule() {
    //...
  }
  
  public boolean isAvailable() {
    //...
    return random.nextBoolean();
  }
  
  public boolean scheduleIfAvailable() {
    boolean open = isAvailable();
    if(open) schedule();
    return open;
  }
}

public class Sample {
	public static void main(String[] args) {
	  List<TimeSlot> timeSlots = Arrays.asList(
	    new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot());
	    
	  //...

	  System.out.println("TimeSlot is " +
	    timeSlots.stream()
	             .filter(TimeSlot::scheduleIfAvailable)
	             .findFirst());
  }
}