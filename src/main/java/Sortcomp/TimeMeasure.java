package Sortcomp;

import java.util.concurrent.TimeUnit;

public class TimeMeasure {
	
	private long startTime;
	
	public TimeMeasure() {
		this.startTime = System.nanoTime();
	}
	
	public void startTimer() {
		this.startTime = System.nanoTime();
	}
	
	public Integer stopTimer() {
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		return Math.toIntExact(timeElapsed / 1000000);
	}
}
