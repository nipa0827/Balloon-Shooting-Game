package game;


import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame frame;

	public Welcome() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame("Balloon Shooting Game By: Suravi");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(650,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel label1 = new JLabel("Balloon Shooting Game");
		label1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label1.setBounds(10, 21, 450, 31);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon(getClass().getResource("Home.jpg")));
		label2.setBounds(10, 63, 467, 387);
		frame.getContentPane().add(label2);
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level1 level1 = new Level1();
				frame.setVisible(false);
			}
		});
		newGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newGameButton.setBounds(487, 84, 137, 87);
		frame.getContentPane().add(newGameButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help();
			}
		});
		helpButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		helpButton.setBounds(487, 198, 137, 94);
		frame.getContentPane().add(helpButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				System.exit(0);
				frame.dispose();
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitButton.setBounds(487, 322, 137, 94);
		frame.getContentPane().add(exitButton);
	}
	
	
}