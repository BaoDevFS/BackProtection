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
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import control.ButtonListener;

public class ShutDownView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonListener buttonListener;
	JPanel pnCenter,pnSouth;
	public ShutDownView(ButtonListener buttonListener) {
		this.buttonListener=buttonListener;
		Border bo = BorderFactory.createTitledBorder("ShutDown");
		setBorder(bo);
		setLayout(new BorderLayout());
		initpnCenter();
		pnSouth = new JPanel();
		JButton xacnhan= new JButton("Xác Nhận");
		xacnhan.setActionCommand("shutdown");
		Border bdb= BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
		xacnhan.setBorder(bdb);
		xacnhan.setFont(new Font("Courier New", Font.BOLD, 15));
		xacnhan.setBackground(Color.CYAN);
		xacnhan.addActionListener(buttonListener);
		pnSouth.add(xacnhan);
		add(pnSouth,BorderLayout.SOUTH);
	}
	private void initpnCenter() {
		Border bo = BorderFactory.createLineBorder(Color.PINK);
		pnCenter= new JPanel();
		pnCenter.setBorder(bo);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JLabel lb = new JLabel("Thời gian:");
		JRadioButton p1 = new JRadioButton("30p");
		JRadioButton p2 = new JRadioButton("1h");
		JRadioButton p3 = new JRadioButton("1h30p");
		JRadioButton p4 = new JRadioButton("2h");
		JRadioButton p5 = new JRadioButton("2h30");
		JRadioButton p6 = new JRadioButton("3h");
		JRadioButton p7 = new JRadioButton("4h");
		JRadioButton p8 = new JRadioButton("5h");
		JRadioButton p9 = new JRadioButton("6h");
		p1.setActionCommand("30psd");p5.setActionCommand("2h30psd");
		p2.setActionCommand("1hsd");p6.setActionCommand("3hsd");
		p3.setActionCommand("1h30psd");p7.setActionCommand("4hsd");
		p4.setActionCommand("2hsd");p8.setActionCommand("5hsd");
		p9.setActionCommand("6hsd");
		ButtonGroup bg = new ButtonGroup();
		bg.add(p1);bg.add(p2);bg.add(p3);bg.add(p4);
		bg.add(p5);bg.add(p6);bg.add(p7);bg.add(p8);bg.add(p9);
		p2.setSelected(true);
		p1.addActionListener(buttonListener);
		p2.addActionListener(buttonListener);
		p3.addActionListener(buttonListener);
		p4.addActionListener(buttonListener);
		p5.addActionListener(buttonListener);
		p6.addActionListener(buttonListener);
		p7.addActionListener(buttonListener);
		p8.addActionListener(buttonListener);
		p9.addActionListener(buttonListener);
		pnCenter.add(lb);
		pnCenter.add(p1);
		pnCenter.add(p2);
		pnCenter.add(p3);
		pnCenter.add(p4);
		pnCenter.add(p5);
		pnCenter.add(p6);
		pnCenter.add(p7);
		pnCenter.add(p8);
		pnCenter.add(p9);
		JScrollPane scrollPane = new JScrollPane(pnCenter);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      //  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 300, 100);
		add(scrollPane,BorderLayout.CENTER);
		/////
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("Test");
		jf.setSize(500, 250);
		jf.setAlwaysOnTop(true);
		ShutDownView mv = new ShutDownView(new ButtonListener());
		jf.add(mv);
		jf.setVisible(true);
	}

}
