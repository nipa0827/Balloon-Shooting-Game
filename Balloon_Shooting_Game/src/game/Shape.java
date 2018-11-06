package game;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Shape {
	ArrayList<JLabel> arrowList = new ArrayList<JLabel>(100);
	ArrayList<JLabel> baloonList = new ArrayList<JLabel>(100);

	public Shape() {
		getAllArrow();
		getAllBalloon();
	}

	public ArrayList<JLabel> getAllArrow() {

		for (int i = 0; i < 100; i++) {
			JLabel arrow = new JLabel();
			arrow.setIcon(new ImageIcon(getClass().getResource("arrow.png")));
			arrowList.add(arrow);
		}

		return arrowList;
	}

	public ArrayList<JLabel> getAllBalloon() {

		for (int i = 0; i < 100; i++) {
			JLabel balloon = new JLabel();
			balloon.setIcon(new ImageIcon(getClass()
					.getResource("balloon2.png")));
			baloonList.add(balloon);
		}

		return baloonList;
	}

}
