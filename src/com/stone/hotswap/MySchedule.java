package com.stone.hotswap;

import java.util.Timer;

public class MySchedule {

	public static void main(String[] args){   
		   Timer timer = new Timer();   
		   timer.schedule(new TimeRefreshTask(), 1000, 1000*10);   
	}   
}
