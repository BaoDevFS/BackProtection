package model;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import view.MainView;
import view.MyFrame;
import view.WarningView;

public class MainOption extends Option implements Observer {
	private WarningView warningView;
	private MainView mainView;
	private Time inputWarningView;
	private Observable ob;

	public MainOption(Time time) {
		this.ob = time;
		ob.addObserver(this);
	}
	@Override
	public void setTime(Time time) {
		LocalDateTime localtime = LocalDateTime.now();
		timeNow = new Time(localtime.getHour(), localtime.getMinute(), localtime.getSecond());
		this.inputWarningView = time;
		timeDestination = caculatedTime(time);
	}

	public void setMainView(MainView mv) {
		this.mainView = mv;
	}

	public MainView getMv() {
		return mainView;
	}

	public WarningView getWr() {
		return warningView;
	}

	@SuppressWarnings("deprecation")
	synchronized @Override public void update(Observable o, Object arg) {
		if (o instanceof Time) {
			Time localtime = (Time) o;
			if (timeDestination != null) {
				if (localtime.getHour() == timeDestination.getHour()) {
					Time local = new Time(localtime.getHour(), localtime.getMinute(), localtime.getSecond());
					if (compare(local, timeDestination) == 1) {
						 warningView = new WarningView(inputWarningView);
						if(mainView.getBt().getShutDownOption()==false) {
						MyFrame jf = (MyFrame) mainView.getJf();
						MyThread mt = jf.getMyThread();
						mt.suspend();
						}
					}
				}
			}
		}
	}
}
