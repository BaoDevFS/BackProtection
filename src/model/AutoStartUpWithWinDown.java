package model;

import java.lang.reflect.InvocationTargetException;

import test.WinRegistry;

public class AutoStartUpWithWinDown {
	String value;
	public AutoStartUpWithWinDown() {
		if(System.getProperty("user.dir").equalsIgnoreCase("D:\\")||System.getProperty("user.dir").equalsIgnoreCase("C:\\")){
			value = System.getProperty("user.dir")+"BackProtection.exe";
		}else {
			value = System.getProperty("user.dir")+"\\BackProtection.exe";
		}
		try {
			WinRegistry.writeStringValue(WinRegistry.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", "BackProtection", value,0);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
