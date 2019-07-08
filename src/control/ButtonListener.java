package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import model.MainOption;
import model.ShutDownOption;
import model.Time;
import test.WinRegistry;
import view.AboutView;
import view.HelpView;
import view.MainView;
import view.MyFrame;

public class ButtonListener implements ActionListener {
	static MainView manView;
	static Time inputTime,inputTimeShutdown;
	static MainOption mainOption;
	static ShutDownOption shutDownOption;
	
	public static boolean getShutDownOption() {
		if(shutDownOption==null) {
			return false;
		}else {
			return shutDownOption.geIsrunning();
		}
	}

	@SuppressWarnings("static-access")
	public ButtonListener(MainView mainView) {
		this.manView = mainView;
	}

	public ButtonListener() {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "30p":
			inputTime = new Time(0, 30, 0);
			break;
		case "1h":
			inputTime = new Time(1, 0, 0);
			break;
		case "1h30p":
			inputTime = new Time(1, 30, 0);
			break;
		case "2h":
			inputTime = new Time(2, 0, 0);
			break;
		case "30psd":
			inputTimeShutdown = new Time(0, 30, 0);
			break;
		case "1hsd":
			inputTimeShutdown = new Time(1, 0, 0);
			break;
		case "1h30psd":
			inputTimeShutdown = new Time(1, 30, 0);
			break;
		case "2hsd":
			inputTimeShutdown = new Time(2, 0, 0);
			break;
		case "2h30psd":
			inputTimeShutdown = new Time(2, 30, 0);
			break;
		case "3hsd":
			inputTimeShutdown = new Time(3, 0, 0);
			break;
		case "4hsd":
			inputTimeShutdown = new Time(4, 0, 0);
			break;
		case "5hsd":
			inputTimeShutdown = new Time(5, 0, 0);
			break;
		case "6hsd":
			inputTimeShutdown = new Time(6, 0, 0);
			break;
		case "Xác Nhận":
			if (inputTime == null) {
				inputTime = new Time(1, 30, 0);
			}
			if (mainOption == null) {
				MyFrame mf = (MyFrame) manView.getJf();
				mainOption = new MainOption(mf.getTime());
				mainOption.setTime(inputTime);
				mainOption.setMainView(manView);
				manView.getJf().setVisible(false);
			} else {
				mainOption.setTime(inputTime);
				MyFrame mf2 = (MyFrame) manView.getJf();
				mf2.getMyThread().resume();
				manView.getJf().setVisible(false);
			}
			break;
		case "shutdown":
			if (inputTimeShutdown == null) {
				inputTimeShutdown = new Time(1, 30, 0);
			}
			MyFrame mf = (MyFrame) manView.getJf();
			if(mainOption!=null) {
				mf.getMyThread().resume();
			}
			if(shutDownOption==null) {
			shutDownOption = new ShutDownOption(mf.getTime());
			shutDownOption.setTime(inputTimeShutdown);
			}else {
				shutDownOption.setTime(inputTimeShutdown);
				shutDownOption.setIsrunning(true);
			}
			break;
		case "Tiếp Tục":
			JFrame jf = mainOption.getWr();
			jf.setDefaultCloseOperation(1);
			jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
			//
			mainOption.setTime(inputTime);
			MyFrame mf2 = (MyFrame) manView.getJf();
			if(mf2.getMyThread().isInterrupted()==false) {
			mf2.getMyThread().resume();
			}
			break;
		case "Trở Về Menu":
			System.out.println("Back Menu");
			manView.getJf().setVisible(true);
			JFrame jf2 = mainOption.getWr();
			jf2.setDefaultCloseOperation(1);
			jf2.dispatchEvent(new WindowEvent(jf2, WindowEvent.WINDOW_CLOSING));
			break;
		case "Help":
			new HelpView();
			break;
		case "About":
			new AboutView();
			break;
		case "OFF":
			try {
				WinRegistry.deleteValue(WinRegistry.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", "BackProtection",0);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

}
