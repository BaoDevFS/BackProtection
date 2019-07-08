package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import control.ButtonListener;

public class MainView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jf;
	ButtonListener bt;
	JPanel pnCenter,pnInCenter;
	ShutDownView shutDownView;

	public MainView(JFrame jf) {
		this.jf = jf;
		setLayout(new BorderLayout());
		bt = new ButtonListener(this);
		initpnCenter();
		
		shutDownView = new ShutDownView(bt);
		add(shutDownView, BorderLayout.EAST);
	}


	public ButtonListener getBt() {
		return bt;
	}


	private void initpnCenter() {
		pnCenter = new JPanel();
		Border bo = BorderFactory.createTitledBorder("Tùy chọn thời gian cảnh báo");
		pnCenter.setBorder(bo);
		pnCenter.setLayout(new BorderLayout());
		initRadioButton();
		initpnSouth();
		add(pnCenter, BorderLayout.CENTER);
	}
	private void initpnSouth() {
		JPanel pnSouth = new JPanel();
		JButton xacnhan = new JButton("Xác Nhận");
		Border bdb = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
		xacnhan.setBorder(bdb);
		xacnhan.setFont(new Font("Courier New", Font.BOLD, 15));
		xacnhan.setBackground(Color.CYAN);
		xacnhan.addActionListener(bt);
		pnSouth.add(xacnhan);
		//add(pnSouth, BorderLayout.SOUTH);
		pnCenter.add(pnSouth,BorderLayout.SOUTH);
	}

	private void initRadioButton() {
		pnInCenter = new JPanel();
		pnInCenter.setLayout(new BoxLayout(pnInCenter, BoxLayout.Y_AXIS));
		JLabel lb = new JLabel("Thời gian:");
		Border bo = BorderFactory.createLineBorder(Color.PINK);
		pnInCenter.setBorder(bo);
		pnInCenter.add(lb);
		JRadioButton p1 = new JRadioButton("30p");
		JRadioButton p2 = new JRadioButton("1h");
		JRadioButton p3 = new JRadioButton("1h30p");
		JRadioButton p4 = new JRadioButton("2h");
		ButtonGroup bg = new ButtonGroup();
		bg.add(p1);
		bg.add(p2);
		bg.add(p3);
		bg.add(p4);
		p3.setSelected(true);
		p1.addActionListener(bt);
		p2.addActionListener(bt);
		p3.addActionListener(bt);
		p4.addActionListener(bt);
		pnInCenter.add(p1);
		pnInCenter.add(p2);
		pnInCenter.add(p3);
		pnInCenter.add(p4);
		
		pnCenter.add(pnInCenter,BorderLayout.CENTER);
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame("Test");
		jf.setSize(500, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setAlwaysOnTop(true);
		MainView mv = new MainView(jf);
		jf.add(mv);
		jf.setVisible(true);
	}
}
