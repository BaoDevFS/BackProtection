package view;


import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import model.AutoStartUpWithWinDown;
import model.MyThread;
import model.Time;

public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainView m ;
	MyThread myThread;
	Time time;
	MenuBarView menuBarView;
	Image imame;
	public MyFrame() {
		setTitle("Protect Back");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setSize(500, 240);
		setLocationRelativeTo(null);
		new AutoStartUpWithWinDown();
		try {
			imame=ImageIO.read(getClass().getResource("iconnewa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(imame);
		menuBarView = new MenuBarView(this);
		m= new MainView(this);
		time = new Time();
		myThread = new MyThread(time);
		myThread.start();
		add(m);
		setVisible(true);
	}
	public MyThread getMyThread() {
		return myThread;
	}
	
	public Time getTime() {
		return time;
	}
	public void setMyThread(MyThread myThread) {
		this.myThread = myThread;
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
