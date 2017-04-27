package com.my.tests;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExample {

	public static void main(String[] args) {

		Timer timer = new Timer();

		timer.schedule( new TimerTask() {
		    public void run() {
		       System.out.println("Running task");
		    }
		 }, 0, 1*2000);

	}
}
