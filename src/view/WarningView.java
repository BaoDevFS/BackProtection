package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import control.ButtonListener;
import model.Time;

public class WarningView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Time time;
	ButtonListener bt;
	JPanel pn;
	Image imame;
	public WarningView(Time time) {
		setTitle("Cảnh báo!");
		setSize(550, 200);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(0);
		try {
			imame=ImageIO.read(getClass().getResource("iconnewa.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(imame);
		setLayout(new BorderLayout());
		this.time = time;
		bt = new ButtonListener();
		intit();
		setVisible(true);
	}

	public void intit() {
		initJlabel();
		initButton();
	}
	private void initJlabel() {
		pn = new JPanel();
		pn.setLayout(new BorderLayout());
		JLabel lbwarning = new JLabel("<html><p>Bạn đã ngồi hơn trên ghế" + time.toString()
				+ "Hãy tạm thời dừng công việc lại đứng"
				+ " lên và hít thở để tránh các nguy cơ bị bệnh về lưng.</p>"
				+ "<p>Và nhớ ngồi thẳng lưng nhá! (Đúng tư thế).</p></html>");
		lbwarning.setForeground(Color.RED);
		lbwarning.setAlignmentX(CENTER_ALIGNMENT);
		lbwarning.setFont(new Font("Courier New", Font.BOLD, 20));
		pn.add(lbwarning, BorderLayout.NORTH);
		Border bo = BorderFactory.createLineBorder(Color.CYAN);
		pn.setBorder(bo);
		add(pn, BorderLayout.CENTER);
	}
	private void initButton() {
		JButton btcontinue = new JButton("Tiếp Tục");
		JButton btback = new JButton("Trở Về Menu");
		Border bdb= BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA);
		btcontinue.setBorder(bdb);
		btcontinue.setFont(new Font("Courier New", Font.BOLD, 15));
		btcontinue.setBackground(Color.CYAN);
		btback.setBorder(bdb);
		btback.setFont(new Font("Courier New", Font.BOLD, 15));
		btback.setBackground(Color.CYAN);
		btcontinue.addActionListener(bt);
		btback.addActionListener(bt);
		JPanel jpbottom = new JPanel();
		jpbottom.add(btcontinue, BorderLayout.SOUTH);
		jpbottom.add(btback, BorderLayout.SOUTH);
		add(jpbottom, BorderLayout.SOUTH);
	}
}
