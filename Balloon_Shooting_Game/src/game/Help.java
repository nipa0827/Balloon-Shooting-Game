package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help {

	private JFrame frame;
	private JButton exitButton;

	public Help() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Balloon Shooting Game By: Suravi");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(800,650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		Font font = new Font("Verdana",Font.BOLD,22);
		
		exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		exitButton.setBackground(Color.GRAY);
		exitButton.setForeground(Color.MAGENTA);
		exitButton.setBounds(464, 502, 177, 45);
		frame.getContentPane().add(exitButton);
		
		JLabel label1 = new JLabel("HELP");
		label1.setBackground(new Color(240, 240, 240));
		label1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1.setBounds(21, 11, 129, 39);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Welcome to Balloon Shooting Game");
		label2.setForeground(Color.MAGENTA);
		label2.setBackground(Color.LIGHT_GRAY);
		label2.setBounds(21, 61, 553, 32);
		frame.getContentPane().add(label2);
		label2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel label3 = new JLabel("Show how good archer you are!");
		label3.setForeground(Color.YELLOW);
		label3.setBounds(21, 100, 553, 32);
		frame.getContentPane().add(label3);
		label3.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel label4 = new JLabel("How to play the game:");
		label4.setFont(new Font("Tahoma", Font.BOLD, 25));
		label4.setForeground(Color.MAGENTA);
		label4.setBounds(21, 138, 440, 32);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("1. Wait for the balloons to come in a optimal position.");
		label5.setFont(new Font("Tahoma", Font.BOLD, 25));
		label5.setForeground(Color.YELLOW);
		label5.setBounds(21, 179, 800, 32);
		frame.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("2. Riles the arrow from your bow.");
		label6.setForeground(Color.YELLOW);
		label6.setFont(new Font("Tahoma", Font.BOLD, 25));
		label6.setBounds(21, 222, 500, 32);
		frame.getContentPane().add(label6);
		
		JLabel label7 = new JLabel("Tips:");
		label7.setFont(new Font("Tahoma", Font.BOLD, 25));
		label7.setForeground(Color.MAGENTA);
		label7.setBounds(21, 265, 410, 39);
		frame.getContentPane().add(label7);
		
		JLabel lblNewLabel = new JLabel("1. Do not throw the arrow too early.");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(21, 315, 553, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label9 = new JLabel("2. So make good timing and hit in time.");
		label9.setForeground(Color.YELLOW);
		label9.setFont(new Font("Tahoma", Font.BOLD, 25));
		label9.setBounds(21, 353, 700, 39);
		frame.getContentPane().add(label9);
		
		JLabel label10 = new JLabel("3. You have one minute to play the game.");
		label10.setFont(new Font("Tahoma", Font.BOLD, 25));
		label10.setForeground(Color.YELLOW);
		label10.setBounds(21, 393, 700, 32);
		frame.getContentPane().add(label10);
		
		JLabel lblNewLabel_1 = new JLabel("Thank you for playing this game.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(21, 436, 470, 45);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setFont(font);
	}

}