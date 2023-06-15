package java_0614_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	private Image carImage;
	private int img_x = 100;
	private int img_y = 100;
	
	public MyPanel() {
		setBackground(Color.WHITE);
		
		try {
			carImage = new ImageIcon("C:/temp/car1.gif").getImage();
		} catch (Exception e) {
			System.out.println("Failed to load image");
			e.printStackTrace();
		}
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(carImage != null) {
			g.drawImage(carImage, img_x, img_y, null);
		}
	}
}

public class CarGame extends JFrame {
	public CarGame() {
		setTitle("Car 마우스로 움직이게 하기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		CarGame game = new CarGame();
	}
}
