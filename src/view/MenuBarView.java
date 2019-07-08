package view;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import control.ButtonListener;

public class MenuBarView {
	JFrame jFrame;
	JMenuBar jMenuBar;
	ButtonListener buttonListener;
	public MenuBarView(JFrame jFrame) {
		this.jFrame=jFrame;
		buttonListener = new ButtonListener();
		jMenuBar = new JMenuBar();
		initMenu();
		this.jFrame.setJMenuBar(jMenuBar);
	}
	private void initMenu() {
		JMenu jm = new JMenu("Help");
		JMenu startUp = new JMenu("StarUp");
		jm.setMnemonic('H');
		JMenuItem help = new JMenuItem("Help");
		help.setMnemonic('H');
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic('A');
		help.setActionCommand("Help");
		about.setActionCommand("About");
		help.addActionListener(buttonListener);
		about.addActionListener(buttonListener);
		jm.add(help);
		jm.add(about);
		JRadioButtonMenuItem on = new JRadioButtonMenuItem("ON");
		JRadioButtonMenuItem off = new JRadioButtonMenuItem("OFF");
		on.addActionListener(buttonListener);
		off.addActionListener(buttonListener);
		on.setSelected(true);
		ButtonGroup bt  = new ButtonGroup();
		bt.add(on);
		bt.add(off);
		JMenuItem startupWinDown = new JMenuItem("StartUpWinDown");
		startupWinDown.add(on);
		startupWinDown.add(off);
		startUp.add(on);
		startUp.add(off);
		jMenuBar.add(startUp);
		jMenuBar.add(jm);
	}
}
