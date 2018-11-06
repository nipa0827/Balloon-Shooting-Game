package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Win {

	private JFrame frame;
	private int throwedArrow, burstedBalloon, bestScore;
	private String level;

	public Win(int throwedArrow, int burstedBalloon, String level, int bestScore) {
		this.throwedArrow = throwedArrow;
		this.burstedBalloon = burstedBalloon;
		this.level = level;
		this.bestScore = bestScore;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Balloon Shooting Game By: Suravi");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 50));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton nextButton = new JButton("NEXT");
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		nextButton.setForeground(Color.MAGENTA);
		nextButton.setBackground(Color.CYAN);
		nextButton.setBounds(291, 270, 210, 57);
		
		if (level.equals("LEVEL-1") || level.equals("LEVEL-2")){
		frame.getContentPane().add(nextButton);
		}
		JLabel label1 = new JLabel("Congratulation!!!!");
		label1.setForeground(Color.GREEN);
		label1.setBounds(107, 11, 292, 35);
		label1.setFont(new Font("Verdana", Font.BOLD, 25));
		frame.getContentPane().add(label1);

		Font font = new Font("Verdana", Font.BOLD, 22);

		if (level.equals("LEVEL-1") || level.equals("LEVEL-2")) {
			JLabel label2 = new JLabel("You Win the Level.");
			label2.setForeground(Color.YELLOW);
			label2.setBounds(49, 74, 338, 24);
			label2.setFont(font);
			frame.getContentPane().add(label2);
		} else {
			JLabel label2 = new JLabel("You Win the game.");
			label2.setForeground(Color.YELLOW);
			label2.setBounds(49, 74, 338, 24);
			label2.setFont(font);
			frame.getContentPane().add(label2);
		}

		JLabel label3 = new JLabel("Total number of throwed arrow: "
				+ throwedArrow);
		label3.setForeground(Color.YELLOW);
		label3.setBounds(49, 109, 470, 35);
		frame.getContentPane().add(label3);
		label3.setFont(font);

		JLabel label4 = new JLabel("Total number of bursted balloon: "
				+ burstedBalloon);
		label4.setForeground(Color.YELLOW);
		label4.setBounds(49, 149, 489, 32);
		frame.getContentPane().add(label4);
		label4.setFont(font);

		if (level.equals("LEVEL-1")) {
			JLabel label5 = new JLabel("Your Score: "+burstedBalloon*30);
			label5.setForeground(Color.YELLOW);
			label5.setBounds(49, 182, 350, 32);
			frame.getContentPane().add(label5);
			label5.setFont(font);
		}
		else if (level.equals("LEVEL-2")) {
			JLabel label5 = new JLabel("Your Score: "+burstedBalloon*40);
			label5.setForeground(Color.YELLOW);
			label5.setBounds(49, 182, 350, 32);
			frame.getContentPane().add(label5);
			label5.setFont(font);
		}
		else if (level.equals("LEVEL-3")) {
			JLabel label5 = new JLabel("Your Score: "+burstedBalloon*50);
			label5.setForeground(Color.YELLOW);
			label5.setBounds(49, 182, 350, 32);
			frame.getContentPane().add(label5);
			label5.setFont(font);
		}
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(level.equals("LEVEL-1")){
					frame.setVisible(false);
					new Level2();
				}
				else if(level.equals("LEVEL-2")){
					frame.setVisible(false);
					new Level3();
				}
				
			}
		});

		JLabel label6 = new JLabel("Best Score: "+bestScore);
		label6.setForeground(Color.YELLOW);
		label6.setBounds(49, 219, 338, 24);
		frame.getContentPane().add(label6);
		label6.setFont(font);
		frame.setSize(600, 450);
		frame.setBackground(Color.LIGHT_GRAY);
	}
}