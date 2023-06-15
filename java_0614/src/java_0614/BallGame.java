package java_0614;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
//ex_07
import javax.swing.JPanel;



class MyPanel extends JPanel{
	
	int img_x = 100;//원의 현재 위치 x
	int img_y = 100;
	
	public MyPanel() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
		});
	}//graphics객체를 사용하여 현재 위치에 빨간색 원을 그립니다. 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//클래스인 jpanel의 paintComponent()
		//메서드를 먼저 실행하고, 그 후에 추가적인 그리기 작업을 수행합니다. 
		g.setColor(Color.RED);
		g.fillOval(img_x, img_y, 50, 50);
	}//50X50 크기의 원, img_x와 img_y는 원의 좌상단 모서리의 위치
}

public class BallGame extends JFrame {
	public BallGame() {
		setTitle("Ball 마우스로 움직이게 하기 ");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());//mypanel클래스의 인스턴스를 생성하여 
		//해당 컴포넌트에 추가하는 것이다
		//즉, ballgame 프레임 내부에는 mypanel이라는 패널이 추가 
		//패널의 paintComponent 메서드를 통해 그래픽이 그려지게 된다. 
		setVisible(true);
	}
	public static void main (String[] args) {
		BallGame game = new BallGame();
	}
}
