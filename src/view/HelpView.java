package view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnBig;
	Image imame;
	public HelpView() {
		setTitle("Help");
		try {
			imame=ImageIO.read(getClass().getResource("iconnewa.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(imame);
		setSize(400,200);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		initpanel();
		setVisible(true);
	}
	private void initpanel() {
		JPanel pnfunction = new JPanel();
		JLabel lbExplain = new JLabel("<html><p>Chức năng 1:</p>"
				+ "<p>Cảnh báo thời gian bạn đã làm việc với máy tính. </p>"
				+ "<p>Chức năng 2:</>"
				+ "<p> Tắt máy tính sau một khoảng thời gian.</p></html>");
		pnfunction.add(lbExplain);
		add(pnfunction);
	}
}
