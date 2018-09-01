package com.stone.ToJava8.exercise_3.before;

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
}

public class Sample {
	public static void main(String[] args) {
	  List<TimeSlot> timeSlots = Arrays.asList(
	    new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot());
	    
	  //...
	  
	  
	  TimeSlot firstAvailableTimeSlot = null;
	  for(TimeSlot timeSlot : timeSlots) {
	    if(timeSlot.isAvailable()) {
	      timeSlot.schedule();
	      firstAvailableTimeSlot = timeSlot;
	      break;
	    }
	  }
	  
	  System.out.println("TimeSlot is " + firstAvailableTimeSlot);
  }
}