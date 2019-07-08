package model;

import java.util.Observable;

public class Time extends Observable{
	private int hour;
	private int minute;
	private int second;
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public Time() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "[hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	public void check(int hour,int minute,int second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
		setChanged();
		notifyObservers();
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}
