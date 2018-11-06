package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class Retry extends JFrame{
	
	JButton retryButton = new JButton();
	JButton exitButton = new JButton();
	String callerClassName;
	
	JPanel retryPanel1 = new JPanel();
	JPanel retryPanel2 = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel message = new JLabel();
	
	public Retry(String callerClassName){
		this.callerClassName = callerClassName;
		initComponenets();
	    setSize(700,500);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
	}
	
	public void initComponenets(){
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Balloon Shooting Game By:Suravi");
		setResizable(false);
		
		setLayout(new FlowLayout());

		retryPanel1.setBackground(new Color(153, 153, 153));
		
		retryPanel1.setFont(new Font("Times New Roman", 1, 36)); // NOI18N
		//label1.setText("        Bow and Arrow");
		
		retryPanel1.setLayout(new BorderLayout());
		message.setText("   Time up!");
		
		Font font = new Font("Verdana",Font.BOLD,30);
		message.setFont(font);
		label2.setIcon(new ImageIcon(getClass().getResource(
				"retry.png"))); // NOI18N

		retryButton.setFont(new Font("Times New Roman", 1, 14)); // NOI18N
		retryButton.setText("Retry");
		retryButton.setBackground(Color.green);
		retryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				retryButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//String callerClassName = new Exception().getStackTrace()[1].getClassName();
						System.out.println(callerClassName);
						if(callerClassName.matches("LEVEL-1")){
							
							setVisible(false);
							Level1 level1 = new Level1();
						}
						
						else if(callerClassName.matches("LEVEL-2")){
							setVisible(false);
							Level2 level2 = new Level2();
						}
						else if(callerClassName.matches("LEVEL-3")){
							setVisible(false);
							Level3 level3 = new Level3();
						}

						// hrow new UnsupportedOperationException("Not supported yet.");
					}
				});
			}
		});

		exitButton.setFont(new Font("Times New Roman", 1, 14)); // NOI18N
		exitButton.setText("Exit");
		exitButton.setBackground(Color.red);
		
		retryPanel1.add(label2);
		add(retryPanel1,BorderLayout.NORTH);
		
		//panel.setLayout(new GridLayout(1,2));
		
		retryPanel2.setLayout(new GridLayout(3,1));
		retryPanel2.add(message);
		exitButton.setBounds(700,500,200,200);
		retryPanel2.add(exitButton);
		retryButton.setBounds(700,600,200,200);
		retryPanel2.add(retryButton);
		
		add(retryPanel2,BorderLayout.EAST);

		pack();
	}

}
