package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnBig;
	Image imame;
	public AboutView() {
		setTitle("About");
		try {
			imame=ImageIO.read(getClass().getResource("iconnewa.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(imame);
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		initpanel();
		setVisible(true);
	}

	private void initpanel() {
		pnBig = new JPanel();
		pnBig.setLayout(new GridLayout(1,2));
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JLabel lbNameApp = new JLabel("PROTECT BACK");
		JLabel lbVersion = new JLabel("Version: 1.0");
		JLabel lbText = new JLabel("Dev by BaoNguyen");
		pnCenter.add(lbNameApp);
		pnCenter.add(lbVersion);
		pnCenter.add(lbText);
		Imagebackground i = new Imagebackground();
		i.setSize(100, 150);
		pnBig.add(i);
		pnBig.add(pnCenter);
		add(pnBig,BorderLayout.CENTER);
	}
	class Imagebackground extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image image;
		public Imagebackground() {
			try {
				image = ImageIO.read(getClass().getResource("icon2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 5, 5, this);
		}
		
	}
	public static void main(String[] args) {
		new AboutView();
	}
}
