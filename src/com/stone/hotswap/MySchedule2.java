package com.stone.hotswap;

import java.util.Timer;

public class MySchedule2 {

	public static void main(String[] args){   
		   Timer timer = new Timer();   
		   timer.schedule(new TimeRefreshTask2(), 1000, 1000*30);   
	}   
}
