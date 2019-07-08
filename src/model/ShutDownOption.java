package model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

public class ShutDownOption extends DecoratedOption implements Observer{
	String shutdownCommand = null;
	Observable ob ;
	private boolean isrunning;
	public ShutDownOption(Observable ob) {
		this.ob=ob;
		ob.addObserver(this);
		isrunning=true;
	}
	
	public void setIsrunning(boolean isrunning) {
		this.isrunning = isrunning;
	}

	@Override
	public void setTime(Time time) {
		LocalDateTime localtime = LocalDateTime.now();
		timeNow = new Time(localtime.getHour(), localtime.getMinute(), localtime.getSecond());
		timeDestination = caculatedTime(time);
	}
	private void shutdown() {
		String osName = System.getProperty("os.name");        
		if (osName.startsWith("Win")) {
		  shutdownCommand = "shutdown.exe -s -t 0";
		} else if (osName.startsWith("Linux") || osName.startsWith("Mac")) {
		  shutdownCommand = "shutdown -h now";
		} else {
		  System.err.println("Shutdown unsupported operating system ...");
		  System.exit(0);
		}
		try {
			Runtime.getRuntime().exec(shutdownCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Time) {
			Time localtime = (Time) o;
			if (timeDestination != null) {
				if (localtime.getHour() == timeDestination.getHour()) {
					Time local = new Time(localtime.getHour(), localtime.getMinute(), localtime.getSecond());
					if (compare(local, timeDestination) == 1) {
						System.out.println(local.toString());
						System.out.println("BingGo");
						isrunning=false;
						shutdown();
					}
				} 
			}
		}
	}
	public boolean geIsrunning() {
		return isrunning;
	}
	public static void main(String[] args) {
		
	}
	
}
