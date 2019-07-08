package model;

import java.time.LocalDateTime;


public class MyThread extends Thread{
	Time time;
	private final int FRAMES_PER_SECOND = 1;
	public MyThread(Time time) {
		this.time=time;
	}
	@Override
	public void run() {
		while (true) {
			//System.out.println("/////");
			long startTime = System.currentTimeMillis();
			LocalDateTime localtime= LocalDateTime.now();
			time.check(localtime.getHour(),localtime.getMinute(),localtime.getSecond());
			long endTime = System.currentTimeMillis();
			int sleepTime = (int) (1000 / FRAMES_PER_SECOND) - (int) (endTime - startTime);

			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime); // ms
				} catch (InterruptedException e) {

				}
			}
	}
	}
}
