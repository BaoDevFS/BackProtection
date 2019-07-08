package model;
public abstract class Option {
	protected Time timeDestination, timeNow;
	protected abstract void setTime(Time time);
	protected Time caculatedTime(Time time) {
		Time timeresult = new Time();
		if (time.getSecond() + timeNow.getSecond() >= 60) {
			timeresult.setSecond((time.getSecond() + timeNow.getSecond()) - 60);
			if (timeNow.getMinute() + 1 >= 60) {
				timeNow.setMinute(0);
				timeNow.setHour(timeNow.getHour() + 1);
			} else
				timeNow.setMinute(timeNow.getMinute() + 1);
		} else {
			timeresult.setSecond(time.getSecond() + timeNow.getSecond());
		}
		if (time.getMinute() + timeNow.getMinute() >= 60) {
			timeresult.setMinute((time.getMinute() + timeNow.getMinute()) - 60);
			timeNow.setHour(timeNow.getHour() + 1);
		} else {
			timeresult.setMinute(time.getMinute() + timeNow.getMinute());
		}
		timeresult.setHour(time.getHour() + timeNow.getHour());
		return timeresult;
	}
	protected int compare(Time o1, Time o2) {
		if (o1.getHour() == o2.getHour() && o1.getMinute() == o2.getMinute()
				&& o1.getSecond() == o2.getSecond()) {
			return 1;
		} else {
			return 0;
		}
	}
}
