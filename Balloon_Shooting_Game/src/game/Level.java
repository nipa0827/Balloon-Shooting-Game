package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class Level extends Shape implements Runnable{
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Level SEVERE = null;
	private int dicrease = 1;
	private int score = 0;
	Random rand;
	private JLabel balloon;
	private JFrame frame = new JFrame("Bow and arrow by:Suravi");
	private JButton arrow_button = new JButton();
	private JLabel playerImageLabel = new JLabel();
	private JPanel level_1_Panel = new JPanel();
	private JButton startButton = new JButton();
	private JLabel scoreLabel = new JLabel();
	// int[] intArray = {10, 5,1};
	private JLabel arrow1 = new JLabel();
	private int collision = 0;
	private int throwedArrow = 0;

	private JLabel label = new JLabel();

	private int time = 0;

	private int count = 0;

	private ArrayList<JLabel> baloonList = new ArrayList<JLabel>(100);
	private ArrayList<JLabel> arrowList = new ArrayList<JLabel>(100);

	// ArrayList<Integer> integers;

	boolean dontMatch = true;
	// int baloon;
	boolean flag = false;
	boolean counter = false;
	private int b = 0;
	private String level;
	private int speed;


	private int bestScore = 0;
	
	Score_Database database = new Score_Database();

	public Level(String level,int speed){
		
		this.level = level;
		this.speed = speed;
		initComponents();
		frame.setSize(920, 540);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}

	// @SuppressWarnings("unchecked")

	private void initComponents() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Balloon shooting game by: Suravi"); 
		level_1_Panel.setBackground(Color.white);
		level_1_Panel.setPreferredSize(new Dimension(900, 500));
		level_1_Panel.setLayout(null);
		
		baloonList = getAllBalloon();
		arrowList = getAllArrow();
		label.setText(level);
		Font font = new Font("Verdana", Font.BOLD, 25);
		label.setFont(font);
		label.setForeground(Color.red);
		level_1_Panel.add(label);
		label.setBounds(360, 10, 200, 100);
		scoreLabel.setText("Score : "+score);
		level_1_Panel.add(scoreLabel);
		scoreLabel.setBounds(800, 50, 80, 30);

		startButton.setText("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				arrow_button.setVisible(true);
				startButtonActionPerformed(evt);
			}
		});

		level_1_Panel.add(startButton);
		startButton.setBounds(360, 190, 179, 109);

		playerImageLabel.setIcon(new ImageIcon(getClass().getResource("739182.jpg")));
		// label1.setIcon(new ImageIcon(getClass().getResource("111.jpg")));
		level_1_Panel.add(playerImageLabel);
		playerImageLabel.setBounds(10, 20, 130, 160);

		arrow1.setIcon(new ImageIcon(getClass().getResource("arrow.png")));
		level_1_Panel.add(arrow1);
		arrow1.setBounds(70, 60, 130, 70);
		
		level_1_Panel.add(survivalTime);

		arrow_button.setBackground(Color.cyan);
		arrow_button.setFont(new Font("Tahoma", 1, 12));
		arrow_button.setText("Throw arrow");
		arrow_button.setVisible(false);

		arrow_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				arrow_buttonActionPerformed(evt);

			}
		});
		level_1_Panel.add(arrow_button);
		arrow_button.setBounds(20, 210, 113, 40);

		frame.getContentPane().add(level_1_Panel);
		level_1_Panel.setBounds(0, 0, 900, 500);
		frame.setVisible(true);

		frame.pack();
	}
	private JLabel survivalTime = new JLabel();
	private int second = 60;
	private void startButtonActionPerformed(ActionEvent evt) {
		startButton.setVisible(false);
		flag = false;
		new Thread(this).start();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				frame.setTitle("You have " + second-- + " seconds" + " to play");
				
				if (second == 0 && score<150) {
					Retry retry = new Retry(level); 
					frame.setVisible(false); 
					retry.setVisible(true); 
				}
				else if (score >= 150 && second==0) {
					frame.setVisible(false);
					frame.dispose();
					if(level.equals("LEVEL-1")){
						if(score>database.get_Level_1_score()){
							database.update_level_1_score(4, score);
							bestScore = database.get_Level_1_score();
						}
						else {
							bestScore = database.get_Level_1_score();
							
						}
					}
					else if(level.equals("LEVEL-2")){						
						if(score>database.get_Level_2_score()){
							database.update_level_2_score(1, score);
							bestScore = database.get_Level_2_score();
							//System.out.println(bestScore);
						}
						else {
							bestScore = database.get_Level_2_score();
							
						}
					}
					else {
						if(score>database.get_Level_3_score()){
							database.update_level_3_score(1, score);
							bestScore = database.get_Level_3_score();
							//System.out.println(bestScore);
						}
						else {
							bestScore = database.get_Level_3_score();
							
						}
					}
					
						Win win = new Win(throwedArrow, collision,level,bestScore);
						

				}
			}
		}, 0, 1000);
	}

	private void arrow_buttonActionPerformed(ActionEvent evt) {
		throwedArrow++;
		count++;
		new Thread(this).start();
		flag = true;
	}

	public static int getRandomNumberBetween(int min, int max) {
		Random foo = new Random();
		int randomNumber = foo.nextInt(max - min) + min;
		if (randomNumber == min) {
			return min + 1;
		} else {
			return randomNumber;
		}

	}

	public void moveArrow(int id) throws ArrayIndexOutOfBoundsException {
		try {
			boolean counter = false;
			JLabel arrow = new JLabel();

			arrow = arrowList.get(0);
			level_1_Panel.add(arrow);
			arrow.setBounds(60, 60, 130, 70);

			//System.out.println(arrowList.size());
			arrow_button.setEnabled(false);
			for (int i = 0; i < 500; i++) {

				try {
					// TimeUnit.SECONDS.sleep(1);
					Thread.sleep(speed);

				} catch (InterruptedException ex) {
					Logger.getLogger(Level.class.getName()).log(Level.SEVERE, null, ex);
				}

				Point point = arrow.getLocation();
				Point pointB = balloon.getLocation();
				
				
				if ((pointB.x - point.x)==120 && Math.abs(point.y - pointB.y) <= 35 && !counter) {
					dicrease = 5;
					//System.out.println("Crashed");

					if(level.equals("LEVEL-1"))score += 30;
					else if(level.equals("LEVEL-2")) score+=40;
					else score+= 50;
					scoreLabel.setText("Score: " + score);
					counter = true;
					Icon icon = new ImageIcon(getClass().getResource("burst-balloons1.jpg"));
					balloon.setIcon(icon);
					collision++;

					balloon.setLocation(point.x, point.y - 1);

				}
				
				arrow.setLocation(point.x + 2, point.y);

			}

			flag = false;

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		arrow_button.setEnabled(true);

	}

	
	public void moveBaloon(int b) {
		balloon = baloonList.get(b);
		level_1_Panel.add(balloon);
		balloon.setBounds(680, 410, 58, 74);
		for (int i = 0; i < 600; i++) {

			try {
				Thread.sleep(speed);
			} catch (InterruptedException ex) {
				Logger.getLogger(Level.class.getName()).log(Level.SEVERE, null, ex);
			}
			Point point = balloon.getLocation();
			balloon.setLocation(point.x, point.y + dicrease);
		}

	}
	
	int arrowId = 0;
	Timer timer;
	

	public void run() {
		int count = 0;

		if (flag) {
			int id = getRandomNumberBetween(0, 10);
			moveArrow(id);
		}
		else {
			
			for (int i = 0; i < 100; i++) {
				dicrease = -1;
				b = i;
				moveBaloon(i);
			}
		}

	}

}